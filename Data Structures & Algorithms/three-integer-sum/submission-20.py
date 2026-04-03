class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res: List[List[int]] = []

        for i, n in enumerate(nums):
            if(i > 0 and n == nums[i-1]): continue
            
            # Now it's 2sum problem
            left: int = i+1
            right: int = len(nums) - 1
            while left < right:
                three_sum: int = n + nums[left] + nums[right]

                if three_sum > 0: right -= 1
                elif three_sum < 0: left += 1
                else:
                    res.append([n, nums[left], nums[right]])

                    left+= 1
                    while left < right and nums[left] == nums[left-1]: left += 1

        return res