class Solution:
    def climbStairs(self, n: int) -> int:
        one: int = 1
        two: int = 1

        for i in range(n-1):
            one, two = one+ two, one
        
        return one