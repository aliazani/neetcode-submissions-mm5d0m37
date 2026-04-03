class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) return mid;

            // we are in the left part
            if (nums[left] <= nums[mid]) {

                // should go the right part
                if (target < nums[left] || target > nums[mid]) left = mid + 1;
                // search the left part
                else right = mid - 1;
            }

            // we are in the right part 
            else {
                // go to the left part
                if (target > nums[right] || target < nums[mid]) right = mid - 1;
                // search the right part 
                else left = mid + 1;

            }
        }
    return -1;

    }
}
