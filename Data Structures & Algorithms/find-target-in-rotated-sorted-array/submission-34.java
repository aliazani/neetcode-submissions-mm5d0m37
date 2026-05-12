class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) return mid;

            // left part is sorted
            if (nums[low] <= nums[mid]) {
                // target is in the left part
                if (nums[low] <= target && target < nums[mid]) high = mid - 1; 
                // if (target < nums[left] || target > nums[mid]) left = mid + 1;
                // search the left part
                // else right = mid - 1;
                else low = mid + 1;
            }

            // right part is sorted 
            else {
                // search the right part
                if (nums[mid] < target && target <= nums[high]) low = mid + 1;
                // go to the left part
                // if (target > nums[right] || target < nums[mid]) right = mid - 1;
                else high = mid - 1;
                // search the right part 
                // else left = mid + 1;
            }
        }
    return -1;

    }
}
