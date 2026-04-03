class Solution:
    def findMin(self, nums: List[int]) -> int:
        l: int = 0
        r: int = len(nums) - 1

        while l < r:
            mid: int = (l + r) // 2
            print(f'l: {l}, r: {r}, mid: {mid}')

            if nums[mid] > nums[r]:
                l = mid + 1
            else:
                r = mid

        return nums[l]