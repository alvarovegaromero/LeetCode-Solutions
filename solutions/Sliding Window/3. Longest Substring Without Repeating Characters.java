//https://leetcode.com/problems/longest-substring-without-repeating-characters

// First Approach
// Time Complexity: O(n) - Space Complexity: O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1)
            return s.length();

        int left = 0, right = 0, longest = 0;
        Map<Character, Integer> mapValIndexes = new HashMap<>();

        while (right < s.length()) {
            char currentChar = s.charAt(right);

            if (mapValIndexes.containsKey(currentChar) &&
                mapValIndexes.get(currentChar) >= left) {
                //Second condition if that ocurrence does not affect current window
                left = mapValIndexes.get(currentChar) + 1;
            }

            mapValIndexes.put(currentChar, right);

            longest = Math.max(longest, right - left + 1);

            right++;
        }

        return longest;
    }
}