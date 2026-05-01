class Solution {
    public int coinChange(int[] coins, int amount) {
        int IMPOSSIBLE = amount + 1;

        int[] minCoins = new int[amount+1];
        minCoins[0] = 0;
        for (int i=1; i < minCoins.length; i++) {
            minCoins[i] = IMPOSSIBLE;
        }

        for(int target=1; target < amount +1; target++) {
            for (int coin: coins) {
                int remain = target - coin;

                if (remain >= 0) minCoins[target] = Math.min(minCoins[target], 1 + minCoins[remain]); 
            }

        }

        return minCoins[amount] != IMPOSSIBLE ? minCoins[amount] : -1;
    }
}
