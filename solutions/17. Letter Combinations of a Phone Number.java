//https://leetcode.com/problems/letter-combinations-of-a-phone-number

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();

        if(digits.length() == 0)
            return results;
        
        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        backtracking(digits, 0, new StringBuilder(), results, digitToLetters);

        return results;
    }

    public void backtracking(String digits, int index, StringBuilder comb,
                            List<String> results,
                            Map<Character, String> digitToLetters) {

        if(index == digits.length()) {
            results.add(comb.toString());
            return;
        }

        String letters = digitToLetters.get(digits.charAt(index));
        for(char letter : letters.toCharArray()) {
            comb.append(letter);
            backtracking(digits, index + 1, comb, results, digitToLetters);
            comb.deleteCharAt(comb.length() - 1); //delete char added in loop
        }

    }
}