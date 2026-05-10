class Solution {
    public int maxProfit(int[] prices) {
     int left = 0;
    //  left
     int right = left + 1;
    //  right
     int maxP = 0;
    //  state
     while (right < prices.length) {
        // invalid window
        // price[left] > price[right]
        // [20, 30, 0]
        //      l   r
        // shrink left
        if (prices[left] > prices[right]) left = right;
        // window is valid expand right
        else maxP = Math.max(maxP, prices[right] - prices[left]);
        right++;
     }

     return maxP;   
    }
}
