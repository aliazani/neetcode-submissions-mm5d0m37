class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int mostWater = 0;

        while(left < right) { 
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            int s = width * height;

            mostWater = Math.max(mostWater, s);

            if (heights[left]< heights[right]) left++;
            else right--;
        }

        return mostWater;
    }
}
