//https://leetcode.com/problems/longest-common-prefix

// m length of shortest string
// n length of the array of strings
// First Solution - Time Efficiency O(n * m^2) - Space Efficiency O(m)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int smallestSize = Integer.MAX_VALUE;
        boolean stringMatch;
        String firstPrefix;


        for (String str : strs) {
            if (str.length() < smallestSize) {
                smallestSize = str.length();
            }
        }

        for(int i = 0; i < smallestSize; i++) { 
            stringMatch = true;
            firstPrefix = strs[0].substring(0, smallestSize - i);

            for(int j = 1; j < strs.length && stringMatch; j++)
                if(!firstPrefix.equals(strs[j].substring(0, smallestSize - i)))
                    stringMatch = false;

            if(stringMatch)
                return firstPrefix;
        }

        return "";
    }
}

// Second Solution - Time Efficiency O(n * m) - Space Efficiency O(1)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int prefixLength = 0;
        char currentChar;

        for (int i = 0; i < strs[0].length(); i++) { 
            currentChar = strs[0].charAt(i); // Take i char from the first word

            // Check i char in other words until mismatch
            for (int j = 1; j < strs.length; j++) 
                if (i >= strs[j].length() || strs[j].charAt(i) != currentChar)
                    return strs[0].substring(0, prefixLength); // Executed once

            prefixLength++;
        }

        return strs[0]; // All the word with same prefix
    }
}