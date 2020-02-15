class Solution {
    public int maxArea(int[] height) {
        int ans = Math.min(height[0], height[1]);
        for(int i=0 ; i<height.length ; i++) {
            for(int j=i+1 ; j<height.length ; j++) {
                int pos = Math.min(height[i], height[j]) * (j - i);
                if(pos > ans) {
                    ans = pos;
                }
            }
        }
        return ans;
    }
}

class Solution2 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int ans = area(height, left, right);;
        while(left < right) {
            if(height[left] > height[right]) {
                int origin = height[right];
                do {
                    right--;
                } while(right > 0 && height[right] < origin);
            } else {
                int origin = height[left];
                do {
                    left++;
                } while(left < height.length && height[left] < origin);
            }
            int pos = area(height, left, right);
            if(pos > ans) {
                ans = pos;
            }
        }
        return ans;
    }

    private int area(int[] height, int left, int right) {
        return Math.min(height[left], height[right]) * (right - left);
    }
}