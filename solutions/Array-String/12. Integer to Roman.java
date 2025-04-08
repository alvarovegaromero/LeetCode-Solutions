//https://leetcode.com/problems/integer-to-roman

// Time Complexity: O(1) - Space Complexity: O(1) 
// The algorithm will run in constantly as number of roman numbers is fixed.
class Solution {
    public String intToRoman(int num) {
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        int index = 0;
        StringBuilder result = new StringBuilder();

        while(num > 0) {
            while(num >= values[index]) {
                num -= values[index];
                result.append(roman[index]);
            }

            index++;
        }

        return result.toString();
    }
}

// Another approach using a Map. Slower than the previous one, but easier to understand.
// Time Complexity: O(1) - Space Complexity: O(1)
class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> romanMap = new LinkedHashMap<>();
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");

        StringBuilder result = new StringBuilder();

        Iterator<Map.Entry<Integer, String>> iterator = romanMap.entrySet().iterator();

        while (num > 0 && iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();

            while (num >= entry.getKey()) {
                num -= entry.getKey();
                result.append(entry.getValue());
            }
        }

        return result.toString();
    }
}