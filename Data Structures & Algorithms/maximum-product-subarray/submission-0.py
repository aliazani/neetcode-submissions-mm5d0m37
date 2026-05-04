class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res: int = max(nums)
        curr_min: int = 1
        curr_max: int = 1

        for num in nums:
            tmp: int = curr_max * num
            curr_max = max(num * curr_max, num * curr_min, num)
            curr_min = min(tmp, curr_min * num, num)

            res = max(res, curr_max)
        return res