//https://leetcode.com/problems/roman-to-integer

class Solution {
    public int romanToInt(String s) {        
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int result = 0;
        char currentChar;
        int size = s.length();

        // Constraint: S is a valid roman numeral in [1, 3999]
        for(int i = 0; i < size - 1; i++){
            currentChar = s.charAt(i);

            if (roman.get(currentChar) < roman.get(s.charAt(i + 1)))
                result -= roman.get(currentChar);
            else
                result += roman.get(currentChar);
        }

        return result + roman.get(s.charAt(size - 1));
    }
}