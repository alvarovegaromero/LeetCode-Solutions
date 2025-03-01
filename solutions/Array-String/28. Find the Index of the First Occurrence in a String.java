//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string

// First Solution - Time Efficiency O(n * m) - Space Efficiency O(m)
class Solution {
    public int strStr(String haystack, String needle) {
        
        for(int i = 0; i <= haystack.length() - needle.length(); i++)
            if(needle.equals(haystack.substring(i, i + needle.length())))
                return i;

        return -1;
    }
}

// Second Solution (KMP Algorithm) - Time Efficiency O(n + m) - Space Efficiency O (m) 
class Solution {
    public int strStr(String haystack, String needle) {
        int[] lps = computeLongestPrefixSuffixArray(needle);
        int i = 0; // index for haystack
        int j = 0; // index for needle

        // Iterate through needle
        while (i < haystack.length()) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                i++;
                j++;
            }

            // Substring found
            if (j == needle.length())
                return i - j;
            
            // Discrepancies found.
            else if (i < haystack.length() && needle.charAt(j) != haystack.charAt(i)) {
                // Jump to next possible solution where the coincidence may be found.
                // If que didn't have lps[], we would assign j=0 but we would
                if (j != 0)
                    j = lps[j - 1];
                // No prefix that is also suffix at the current pos 
                // (or all the possible solution are already explored)
                else
                    i++;
            }
        }
        return -1;
    }   

    private int[] computeLongestPrefixSuffixArray(String pattern) {
        // For every substring in the pattern (from [0, i] --> pos i)
        // Get the length of the largest prefix that is also suffix for the index i
        // Note: prefix must not include last char and suffixes must not include first char

        int[] lps = new int[pattern.length()];
        int length = 0;
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0)
                    length = lps[length - 1];
                else
                    i++;
            }
        }

        return lps;
    }
}