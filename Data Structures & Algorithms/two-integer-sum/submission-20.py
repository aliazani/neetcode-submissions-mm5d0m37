class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_indx: int = {}

        for i, val in enumerate(nums):
            residual: int = target - val

            if residual in num_indx: return [num_indx[residual], i]

            num_indx[val] = i