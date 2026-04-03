class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int middle = (left + right) / 2;
        while (left < right) {
            if (nums[left] < nums[right]) return nums[left];
            middle = (left + right) / 2;

            if (nums[middle] > nums[right]) left = middle + 1;
            else right = middle;
        }
        return nums[left];
    }
}
