class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left: int = 0
        right: int = len(nums) - 1

        while left <= right:
            mid = (left + right) // 2

            if nums[mid] == target:
                return mid

            # left half is sorted
            if nums[left] <= nums[mid]:
                if nums[left] > target or target > nums[mid]:
                    # otherwise search the right part
                    left = mid + 1
                else:
                    # target is between lowest left and mid => search the left part
                    right = mid - 1
                    

            # right half is sorted
            else:
                if  target > nums[right] or nums[mid] > target:
                    # otherwise search the left part
                    right = mid - 1

                else:
                    # target is between mid and greatest right => search the right part
                    left = mid + 1

        return -1