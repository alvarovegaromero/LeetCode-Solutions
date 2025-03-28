//https://leetcode.com/problems/is-subsequence

// Time complexity: O(n) with n being the length of the longest string
// Space complexity: O(1)
class Solution {
    public boolean isSubsequence(String s, String t) {
        int pointerS = 0, pointerT = 0;

        while(pointerS < s.length() && pointerT < t.length()) {
            if(s.charAt(pointerS) == t.charAt(pointerT))
                pointerS++;

            pointerT++;
        }

        return pointerS == s.length();
    }
}