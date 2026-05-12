class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] < nums[right]) return nums[left];

            int middle = left + (right - left) / 2;
            // go to the left part
            if (nums[right] < nums[middle]) {
                left = middle + 1;
            } 
            // go to the right part
            else {
                right = middle;
            }
        }

        return nums[left];
    }
}