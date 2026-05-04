class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        best = max(nums)
        running_max = 1
        running_min = 1

        for n in nums:
            candidates = (n * running_max, n * running_min, n)
            running_max, running_min = max(candidates), min(candidates)
            best = max(best, running_max)

        return best
