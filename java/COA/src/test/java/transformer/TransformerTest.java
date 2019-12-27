package transformer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransformerTest {

    private Transformer t;

    @Before
    public void init() {
        t = new Transformer();
    }

    @Test
    public void test_intToBinary_0() {
        assertEquals("00000000000000000000000000000000", t.intToBinary("0"));
    }

    @Test
    public void test_intToBinary_1() {
        assertEquals("00000000000000000000000000000001", t.intToBinary("1"));
    }

    @Test
    public void test_intToBinary_2() {
        assertEquals("11111111111111111111111111111111", t.intToBinary("-1"));
    }

    @Test
    public void test_intToBinary_3() {
        assertEquals("01111111111111111111111111111111", t.intToBinary(String.valueOf(Integer.MAX_VALUE)));
    }

    @Test
    public void test_intToBinary_4() {
        assertEquals("10000000000000000000000000000000", t.intToBinary(String.valueOf(Integer.MIN_VALUE)));
    }

    @Test
    public void test_binaryToInt_0() {
        assertEquals("0", t.binaryToInt("00000000000000000000000000000000"));
    }

    @Test
    public void test_binaryToInt_1() {
        assertEquals("1", t.binaryToInt("00000000000000000000000000000001"));
    }

    @Test
    public void test_binaryToInt_2() {
        assertEquals("1024", t.binaryToInt("00000000000000000000010000000000"));
    }

    @Test
    public void test_floatToBinary_0() {
        assertEquals("00000000000000000000000000000000", t.floatToBinary("0"));
    }

    @Test
    public void test_floatToBinary_1() {
        assertEquals("00000000000000000000000000000000", t.floatToBinary("-0"));
    }

    @Test
    public void test_floatToBinary_2() {
        assertEquals("00111111100000000000000000000000", t.floatToBinary("1"));
    }

    @Test
    public void test_floatToBinary_3() {
        assertEquals("00111111000000000000000000000000", t.floatToBinary("0.5"));
    }

    @Test
    public void test_floatToBinary_4() {
        assertEquals("01000000000000000000000000000000", t.floatToBinary("2"));
    }

    @Test
    public void test_floatToBinary_5() {
        assertEquals("10111111110000000000000000000000", t.floatToBinary("-1.5"));
    }

    @Test
    public void test_binaryToFloat_0() {
        assertEquals("0.0", t.binaryToFloat("00000000000000000000000000000000"));
    }

    @Test
    public void test_binaryToFloat_1() {
        assertEquals("+Inf", t.binaryToFloat("01111111100000000000000000000000"));
    }

    @Test
    public void test_binaryToFloat_2() {
        assertEquals("-Inf", t.binaryToFloat("11111111100000000000000000000000"));
    }

    @Test
    public void test_binaryToFloat_3() {
        assertEquals(String.valueOf((double)Float.MIN_VALUE), t.binaryToFloat("00000000000000000000000000000001"));
    }

    @Test
    public void test_binaryToFloat_4() {
        assertEquals(String.valueOf((double)Float.MAX_VALUE), t.binaryToFloat("01111111011111111111111111111111"));
    }

    @Test
    public void test_binaryToFloat_5() {
        assertEquals("2.0", t.binaryToFloat("01000000000000000000000000000000"));
    }

    @Test
    public void test_binaryToFloat_6() {
        assertEquals("1.0", t.binaryToFloat("00111111100000000000000000000000"));
    }

    @Test
    public void test_binaryToFloat_7() {
        assertEquals("-1.5", t.binaryToFloat("10111111110000000000000000000000"));
    }

    @Test
    public void test_decimalToNBCD_0() {
        assertEquals("11000000000000000000000100100011", t.decimalToNBCD("123"));
    }

    @Test
    public void test_decimalToNBCD_1() {
        assertEquals("11010001001000110100010101100111", t.decimalToNBCD("-1234567"));
    }

    @Test
    public void test_NBCDToDecimal_0() {
        assertEquals("123", t.NBCDToDecimal("11000000000000000000000100100011"));
    }

    @Test
    public void test_NBCDToDecimal_1() {
        assertEquals("-1234567", t.NBCDToDecimal("11010001001000110100010101100111"));
    }
}
