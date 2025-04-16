//https://leetcode.com/problems/word-pattern

// First approach
// Time Complexity: O(n) - Space Complexity: O(n)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if(words.length != pattern.length())
            return false;


        Map<String, Character> wordPatternMap = new HashMap<>();
        Map<Character, String> patternWordMap = new HashMap<>();

        for(int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            char currentPattern = pattern.charAt(i);

            Character mappedCharacter = wordPatternMap.get(currentWord);

            if(mappedCharacter == null) {
                if(patternWordMap.containsKey(currentPattern))
                    return false;

                wordPatternMap.put(currentWord, currentPattern);
                patternWordMap.put(currentPattern, currentWord);
            } else if (mappedCharacter != currentPattern)
                return false;
        }

        return true;
    }
}

// Second approach
// Same but get better results in leetcode
// Time Complexity: O(n) - Space Complexity: O(n)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if(words.length != pattern.length())
            return false;

        Map<String, Character> wordPatternMap = new HashMap<>();
        Map<Character, String> patternWordMap = new HashMap<>();

        for(int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            char currentPattern = pattern.charAt(i);

            if (!patternWordMap.containsKey(currentPattern))
                patternWordMap.put(currentPattern, currentWord);
            
            if (!wordPatternMap.containsKey(currentWord))
                wordPatternMap.put(currentWord, currentPattern);
        
            if (!patternWordMap.get(currentPattern).equals(currentWord) ||
                !wordPatternMap.get(currentWord).equals(currentPattern))
                return false;
        }

        return true;
    }
}