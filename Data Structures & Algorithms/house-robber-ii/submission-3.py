class Solution:
    def rob(self, nums: List[int]) -> int:
        return max(nums[0], self.rob1(nums[1:]), self.rob1(nums[:-1]))

    
    def rob1(self, nums: List[int]) -> int:
        prev: int = 0
        p_prev: int = 0

        for num in nums:
            curr: int = max(num + p_prev, prev)

            p_prev = prev 
            prev = curr

        return prev