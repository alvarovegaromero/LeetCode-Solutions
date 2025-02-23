//https://leetcode.com/problems/gas-station

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, numStations = gas.length;
        for (int i = 0; i < numStations; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        // If totalGas < totalCost, impossible to find solution. 
        // Else, there is one unique solution (constraint)
        if (totalGas < totalCost) 
            return -1;
        
        int remainingGas = 0;
        int start = 0;

        // As only one solution is good, the one that finishes the array with
        // a positive remainingFuel, is the one we look for
        for (int i = 0; i < numStations; i++) {
            remainingGas += (gas[i] - cost[i]);
            if (remainingGas < 0) {
                remainingGas = 0;
                start = i + 1;
            }
        }

        return start;
    }
}