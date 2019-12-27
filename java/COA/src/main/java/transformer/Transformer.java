package transformer;

public class Transformer {

    /**
     * 整數 轉 二進制補碼
     * @param numStr
     * @return
     */
    public String intToBinary(String numStr) {
        int num = Integer.parseInt(numStr);
        if(num == 0) {
            return "00000000000000000000000000000000";  // 0 特別判斷
        }
        if(num == ((int)-Math.pow(2,31))) {
            return "10000000000000000000000000000000";  // 最小負數無法轉正數
        }
        // 判斷負數
        boolean isNegative = false;
        if(num < 0) {
            isNegative = true;
            num = -num;
        }

        StringBuilder result = new StringBuilder();
        while(num > 0) {
            if(num % 2 == 1) {
                result.append("1");
            } else {
                result.append("0");
            }
            num /= 2;
        }
        // 補全至32位
        appendZero(result, 32 - result.length());
        result.reverse();
        // 負數則取返加一，然後返回
        String ans = result.toString();
        if(isNegative) {
            return addOne(negation(ans)).substring(1);
        } else {
            return ans;
        }
    }

    /**
     * 無符號二進制數 轉 整數
     * @param binStr
     * @return
     */
    public String binaryToInt(String binStr) {
        return String.valueOf(Integer.valueOf(binStr, 2));
    }

    /**
     * 浮點數 轉 IEEE754Float
     * @param floatStr
     * @return
     */
    public String floatToBinary(String floatStr) {
        int exponentLen = 8, fragmentLen = 23;

        Double d = Double.parseDouble(floatStr);
        boolean isNegative = d < 0;
        // 判斷有限數
        if(!isFinite(d, exponentLen, fragmentLen)) {
            return isNegative ? "-Inf" : "+Inf";
        }
        // 答案
        StringBuilder result = new StringBuilder(1 + exponentLen + fragmentLen);
        // 判斷0
        if(d == 0) {
            result.append(isNegative ? "1" : "0");
            appendZero(result, exponentLen + fragmentLen);
            return result.toString();
        } else {
            result.append(isNegative ? "1" : "0");
            d = Math.abs(d);
            int bias = (int)((maxValue(exponentLen) + 1) / 2 - 1);
            if(d < minNormal(exponentLen, fragmentLen)) {
                appendZero(result, exponentLen);
                d = d * Math.pow(2, bias - 1);
                addFraction(result, d, fragmentLen);
            } else {
                d = addExponent(result, d, exponentLen);
                addFraction(result, d, fragmentLen);
            }
        }
        return result.toString();
    }

    /**
     * IEEE754Float 轉 浮點數
     * @param binStr
     * @return
     */
    public String binaryToFloat(String binStr) {
        boolean isNegative = binStr.charAt(0) == '1';
        String exp = binStr.substring(1, 9);
        String frag = binStr.substring(9);
        if("11111111".equals(exp)) {
            if(frag.contains("1")) {
                return "NaN";
            }
            return isNegative ? "-Inf" : "+Inf";
        }

        double d = 0.0;
        for(int i=0, l=frag.length() ; i<l ; i++) {
            d += (frag.charAt(i) - '0') / Math.pow(2, i+1);
        }

        if("00000000".equals(exp)) {
            if(!frag.contains("1")) {
                return "0.0";
            }
            d *= Math.pow(2, -126);
        } else {
            d += 1;
            int exponent = Integer.valueOf(binaryToInt(exp));
            d *= Math.pow(2, exponent - 127);
        }
        d = isNegative ? -d : d;
        return String.valueOf(d);
    }

    /**
     * 十進制整數 轉 NBCD
     * @param decimalStr
     * @return
     */
    public String decimalToNBCD(String decimalStr) {
        char[] nums = decimalStr.toCharArray();
        int p = 0;
        boolean isNegative = nums[0] == '-';

        StringBuilder result = new StringBuilder(32);
        if(isNegative) {
            result.append("1101");
            p++;
        } else {
            result.append("1100");
        }
        for(int i=0, l=7 - (nums.length - p) ; i<l ; i++) {
            result.append("0000");
        }
        for(int i=p, l=nums.length ; i<l ; i++) {
            result.append(integerRepresentation(String.valueOf(nums[i]), 4));
        }

        return result.toString();
    }

    /**
     * NBCD 轉 十進制整數
     * @param NBCDStr
     * @return
     */
    public String NBCDToDecimal(String NBCDStr) {
        boolean isNegative;
        if("1100".equals(NBCDStr.substring(0, 4))) {
            isNegative = false;
        } else {
            isNegative = true;
        }
        int result = 0;
        String rest = NBCDStr.substring(4);
        while(rest.length() > 0) {
            int next = Integer.parseInt(binaryToInt(rest.substring(0, 4)));
            result = result * 10 + next;
            rest = rest.substring(4);
        }
        return String.valueOf(isNegative ? -result : result);
    }

    /* private methods */

    /**
     * 按位取反
     * @param operand
     * @return
     */
    private String negation(String operand) {
        StringBuilder result = new StringBuilder();
        for(char c : operand.toCharArray()) {
            result.append(c == '0' ? '1' : '0');
        }
        return result.toString();
    }

    /**
     * 操作數加一，首位表示溢出位
     * @param operand
     * @return
     */
    private String addOne(String operand) {
        char[] result = operand.toCharArray();
        boolean carry = true;
        for(int i=result.length-1 ; i>=0 ; i--) {
            if(!carry) {
                break;
            }
            if(result[i] == '0') {
                result[i] = '1';
                carry = false;
            } else if(result[i] == '1') {
                result[i] = '0';
            }
        }
        char OF = carry ? '1' : '0';
        return OF + String.valueOf(result);
    }

    /**
     * 整數 轉 二進制 （取指定位數）
     * @param num
     * @param length
     * @return
     */
    private String integerRepresentation(String num, int length) {
        String result = intToBinary(num);
        return result.substring(result.length() - length);
    }

    /**
     * length位的無符號二進制數可表示的最大數
     * @param length
     * @return
     */
    private double maxValue(int length) {
        return Math.pow(2, length) - 1;
    }

    /**
     * 計算exponent非0的最小浮點數(即0 00000001 00000000000000000000000)
     * @param exponentLen
     * @param fragmentLen
     * @return
     */
    private double minNormal(int exponentLen, int fragmentLen) {
        int bias = (int)(((maxValue(exponentLen) + 1) / 2) - 1);  // 偏移量
        return Math.pow(2, 1 - bias);  // 指數為1，階碼為0
    }

    /**
     * 判斷數字是否為IEEE754Float定義的有限數
     * @param d
     * @param exponentLen
     * @param fragmentLen
     * @return
     */
    private boolean isFinite(double d, int exponentLen, int fragmentLen) {
        int bias = (int)(((maxValue(exponentLen) + 1) / 2) - 1);  // 偏移量
        int exponent = (int)(maxValue(exponentLen) - 1 - bias - fragmentLen);  // 指数
        double fragment = maxValue(fragmentLen + 1);  // 余数
        double maxVal = fragment * Math.pow(2, exponent);
        return -maxVal <= d && d <= maxVal;
    }

    /**
     * 對StringBuilder添加length個0
     * @param s
     * @param length
     */
    private void appendZero(StringBuilder s, int length) {
        while(length > 0) {
            s.append("0");
            length--;
        }
    }

    /**
     * 添加指數，同時消去d的指數
     * @param result
     * @param d
     * @return
     */
    private double addExponent(StringBuilder result, double d, int exponentLen) {
        int exp = getExponent(d);
        int bias = (int)((maxValue(exponentLen) + 1) / 2 - 1);
        result.append(integerRepresentation(String.valueOf(exp + bias), exponentLen));
        return d / Math.pow(2, exp) - 1;
    }

    /**
     * 計算指數
     * @param d
     * @return
     */
    private int getExponent(double d) {
        if(d == 0) {
            return 0;
        }
        int exp = 0;
        while(d >= 2) {
            d /= 2;
            exp++;
        }
        while(d < 1) {
            d *= 2;
            exp--;
        }
        return exp;
    }

    /**
     * 添加階碼
     * @param result
     * @param d
     */
    private void addFraction(StringBuilder result, double d, int fragmentLen) {
        if(d >= 1) {
            d = d - (int) d;
        }
        while(d > 0 && fragmentLen > 0) {
            d *= 2;
            result.append(d < 1 ? '0' : '1');
            d = d < 1 ? d : d - 1;
            fragmentLen--;
        }
        appendZero(result, fragmentLen);
    }

    /**
     * 計算num的位數
     * @param num
     * @return
     */
    private int getDigits(int num) {
        int count = 0;
        while(num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("123".substring(3).length());
    }
}
