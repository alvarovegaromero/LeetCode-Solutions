//https://leetcode.com/problems/word-break

// Dynamic Programming solution to the Word Break problem
// Time Complexity: O(n^2 * m) where n is the length of the string and m is the average length of words in the dictionary
// Space Complexity: O(n) for the dp array
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean [s.length() + 1]; //initially vals are set to false
        dp[0] = true; //base case: empty string can always be segmented
        Set<String> words = new HashSet<>(wordDict);

        // Iterate through the string s
        // and check if we can form the substring s[0:i] using the words in the dictionary
        // dp[i] will be true if s[0:i] can be segmented into words from the dictionary
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // once dp[i] is true, no need to check further
                }
            }
        }

        return dp[s.length()];
    }
}