//https://leetcode.com/problems/climbing-stairs

// First Approach
// every solutuon is a combination of the previous two solutions
// Time Complexity: O(n) - Space Complexity: O(n)
class Solution {
    public int climbStairs(int n) {

        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        
        int[] dp = new int[n];

        dp[0] = 1;
        dp[1] = 2;
        // From n >= 3
        for(int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; 
        }

        return dp[n - 1];
    }
}

// Second Approach - Optimized using two variables
// Time Complexity: O(n) - Space Complexity: O(1)
class Solution {
    public int climbStairs(int n) {
        if(n <= 2)
            return n;
        
        int prev2 = 1; // dp[i - 2]
        int prev1 = 2; // dp[i - 1]

        for(int i = 2; i < n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1; // dp[i - 2] = dp[i - 1]
            prev1 = current; // dp[i - 1] = dp[i]
        }

        return prev1;
    }
}

// Third Approach - Using Maths and fibonnaci formula (from Copilot)
// Time Complexity: O(log n) - Space Complexity: O(1)
class Solution {
    public int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);
        double phi = (1 + sqrt5) / 2; // Proporción áurea
        double psi = (1 - sqrt5) / 2; // Complemento de la proporción áurea

        // Fórmula cerrada para el n-ésimo número de Fibonacci
        return (int) Math.round((Math.pow(phi, n + 1) - Math.pow(psi, n + 1)) / sqrt5);
    }
}