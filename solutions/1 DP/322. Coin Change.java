//https://leetcode.com/problems/coin-change

// Time Complexity:  O(amount * len(coins))
// Space Complexity: O(amount)
class Solution {
    public int coinChange(int[] coins, int amount) {
        // minimumChangeDP[i] --> minimum numbers of coins to make up amount i
        int[] minimumChangeDP = new int [amount + 1];

        minimumChangeDP[0] = 0;

        // Initialize with impossible states 
        for(int i = 1; i < amount + 1; i++)
            minimumChangeDP[i] = amount + 1;

        // Get minimum coins for each amount
        for(int i = 1; i < amount + 1; i++) {
            for(int coin: coins) {
                // Coin can be used for current amount
                if(coin <= i)
                    minimumChangeDP[i] = Math.min(minimumChangeDP[i],
                                                minimumChangeDP[i - coin] + 1);
            }
        }

        return (minimumChangeDP[amount] < amount + 1) ? minimumChangeDP[amount] : -1;
    }
}