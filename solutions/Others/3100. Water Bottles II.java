//https://leetcode.com/problems/water-bottles-ii

// Time Complexity: O(n) where n is the number of bottles that can be exchanged
// Space Complexity: O(1)
class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        // Initially, all the bottles can be drinken (first iteration)
        int total = numBottles;
        int emptyBottles = numBottles;

        while(emptyBottles >= numExchange) {
            emptyBottles -= numExchange;
            total++; // one more bottle drinken
            emptyBottles++; // one more bottle empty
            numExchange++; // next exchange will be more expensive
        }

        return total; 
    }
}