class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        res: int = len(nums)
        for i in range(len(nums)): res += i - nums[i]
        
        return res
