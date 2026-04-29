class Solution:
    def rob(self, nums: List[int]) -> int:
        max_until_prev: int = 0 #       dp[i-1]
        max_until_prev_prev: int = 0 #  dp[i-2]

        for n in nums:
            current = max(max_until_prev, max_until_prev_prev + n) # dp [i]

            max_until_prev_prev = max_until_prev
            max_until_prev = current
        
        return max_until_prev