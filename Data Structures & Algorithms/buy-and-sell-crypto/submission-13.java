class Solution {
    public int maxProfit(int[] prices) {
     int left = 0;
     int right = left + 1;
     int maxi = 0;
     
     while (right < prices.length && left < prices.length - 1) {
        if (prices[left] > prices[right]) left = right;
        else maxi = Math.max(maxi, prices[right] - prices[left]);
        right++;
     }

     return maxi;   
    }
}
