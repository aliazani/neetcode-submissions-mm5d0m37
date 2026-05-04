class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        lis_from = [1] * len(nums)  # lis_from[i] = longest IS starting at index i

        for i in range(len(nums) - 1, -1, -1):
            for j in range(i + 1, len(nums)):
                if nums[i] < nums[j]:
                    lis_from[i] = max(lis_from[i], 1 + lis_from[j])

        return max(lis_from)