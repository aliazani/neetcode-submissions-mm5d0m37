class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        l: int = 0
        r: int = 1
        maxP: int = 0

        while r < len(prices):
            # profitable
            if prices[r] > prices[l]:
                profit = prices[r] - prices[l]
                maxP = max(maxP, profit)
            else:
                l = r
            
            r += 1
        return maxP