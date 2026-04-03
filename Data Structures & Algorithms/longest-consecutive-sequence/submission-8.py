class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        numsSet: Set[int] = set(nums)
        longest: int = 0

        for n in nums:
            if (n-1 not in numsSet):
                l: int = 0

                while(n+l in numsSet): l += 1
                longest = max(longest, l)
        return longest
        