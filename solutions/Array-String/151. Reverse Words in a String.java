//https://leetcode.com/problems/reverse-words-in-a-string

// First Solution - No optimization
// Time complexity: O(n) - Space complexity: O(n)
class Solution {
    public String reverseWords(String s) {
        s = s.trim(); //Remove trailing and beginning spaces
        List<String> words = new ArrayList<>();

        String currentWord = "";
        for(int i = 0; i < s.length(); i++) {
            if(Character.isLetterOrDigit(s.charAt(i)))
                currentWord += s.charAt(i);
            else if(currentWord != "") { //whitespace found after word
                words.add(currentWord);
                currentWord = "";
            }
            // whitespace with no word. Skip
        }

        // Last word;
        if(currentWord != "")
            words.add(currentWord);

        // Reverse word
        int left = 0, right = words.size() - 1;
        while(left < right) {
            String tmp = words.get(left);
            words.set(left, words.get(right));
            words.set(right, tmp);

            left++;
            right--;
        }

        // Combine words;
        String result = "";
        for(int i = 0; i < words.size(); i++) {
            result += words.get(i);

            if(i != words.size() - 1)
                result += " ";
        }

        return result;
    }
}

// Third Solution - Optimized with reverse function when adding words
// Time complexity: O(n) - Space complexity: O(n)
class Solution {
    public String reverseWords(String s) {
        s = s.trim(); //Remove trailing and beginning spaces

        if(s.length() == 0)
            return "";

        List<String> words = getWordsReverse(s);

        return convertStringsArrayIntoString(words);
    }

    private List<String> getWordsReverse(String s) {
        List<String> words = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();

        for(int i = s.length() - 1; i >= 0; i--){
            if(Character.isLetterOrDigit(s.charAt(i)))
                currentWord.insert(0, s.charAt(i));
            else if(currentWord.length() > 0) {
                words.add(currentWord.toString());
                currentWord.setLength(0); // reset
            }  
        }

        // Add last word if present
        if (currentWord.length() > 0)
            words.add(currentWord.toString());

        return words;
    }

    private String convertStringsArrayIntoString(List<String> words) {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < words.size(); i++) {
            result.append(words.get(i));

            // Do not add a space in the last pos
            if(i != words.size() - 1)
                result.append(" ");
        }

        return result.toString();
    }
}

// Third Approach
// Time complexity: O(n) - Space complexity: O(1)
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        if (s.length() == 0) 
            return "";

        return buildReversedWords(s);
    }

    private String buildReversedWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;
        
        while (i >= 0) {
            // Skip whitespaces until word found
            while (i >= 0 && s.charAt(i) == ' ') 
                i--;

            if (i < 0) 
                break;

            int end = i;

            // Find beginning of word
            while (i >= 0 && s.charAt(i) != ' ') 
                i--;

            if (result.length() > 0) 
                result.append(' ');
            
            // Note: substring includes beginning but excludes ending
            result.append(s.substring(i + 1, end + 1));
        }

        return result.toString();
    }
}