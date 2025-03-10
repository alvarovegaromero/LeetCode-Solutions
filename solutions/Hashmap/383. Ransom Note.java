//https://leetcode.com/problems/ransom-note

// First Solution - Time complexity: O(n) - Space complexity: O(n)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;

        Map<Character, Integer> charFrequency = new HashMap<Character, Integer>();

        for(char currentChar : magazine.toCharArray())
            charFrequency.put(currentChar, charFrequency.getOrDefault(currentChar, 0) + 1);

        for(char currentChar : ransomNote.toCharArray()) {
            if (!charFrequency.containsKey(currentChar) || charFrequency.get(currentChar) <= 0)
                return false;

            charFrequency.put(currentChar, charFrequency.get(currentChar) - 1);
        }

        return true;
    }
}

// Second Solution - Time Efficiency: O(n) - Space Efficiency: O(1) 
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charFrequency = new int[26]; //only lower case letters

        for (char c : magazine.toCharArray())
            charFrequency[c - 'a']++;

        for (char c : ransomNote.toCharArray())
            if (--charFrequency[c - 'a'] < 0)
                return false;

        return true;
    }
}
