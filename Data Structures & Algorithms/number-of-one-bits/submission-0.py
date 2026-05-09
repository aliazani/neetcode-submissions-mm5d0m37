class Solution:
    def hammingWeight(self, n: int) -> int:
        res: int = 0

        while n:
            n &= n-1
            res += 1
        
        return res