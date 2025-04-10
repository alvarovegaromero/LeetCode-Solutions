//https://leetcode.com/problems/valid-anagram

// First approach using a map
// Time complexity: O(n) - Space Complexity: O(n), n the length of strings
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        Map<Character, Integer> charCount  = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);
        }

        for(int i = 0; i < t.length(); i++) {
            char currentChar = t.charAt(i);

            Integer count = charCount.get(currentChar);
            if(count == null || count <= 0)
                return false;

            charCount.put(currentChar, count - 1);
        }

        return true;
    }
}

// Second approach using an array of size 26 
// Time complexity: O(n) - Space Complexity: O(1), since the size of the array is constant (26)
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] charCount = new int[26];

        for(int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }

        for(int count : charCount) {
            if(count != 0) // Any count is not zero --> not anagrams
                return false;
        }

        return true;
    }
}