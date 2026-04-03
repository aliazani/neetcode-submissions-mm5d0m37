class Solution:
    def findMin(self, nums: List[int]) -> int:
        l: int = 0
        r: int = len(nums) - 1

        while l < r:
            if nums[l] < nums[r]:
                return nums[l]
            mid: int = (l + r) // 2

            if nums[mid] > nums[r]:
                # mid > right => right part
                l = mid + 1
            else:
                # else => left part
                r = mid

        return nums[l]