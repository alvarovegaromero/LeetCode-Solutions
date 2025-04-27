//https://leetcode.com/problems/longest-common-subsequence

// Approach: Dynamic Programming
// Time Complexity: O(n*m) where n and m are the lengths of the two strings
// Space Complexity: O(n) where n is the length of the first string
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // Save length of biggest subsequence that ends in text1[i]
        int[] dp = new int[text1.length()];
        int longest = 0;

        for(char c : text2.toCharArray()) {
            // Keep biggest subsequence for expanding 
            int currentLength = 0;
            for(int i = 0; i < text1.length(); i++) {
                // Found a bigger subsequence. 
                // Keep in case we found a coincidence after 
                if(currentLength < dp[i])
                    currentLength = dp[i];
                // We can extend subsequence by 1
                else if (c == text1.charAt(i)) {
                    dp[i] = currentLength + 1;
                    longest = Math.max(longest, dp[i]);
                }
                // else void
            }
        }
        
        return longest;
    }
}