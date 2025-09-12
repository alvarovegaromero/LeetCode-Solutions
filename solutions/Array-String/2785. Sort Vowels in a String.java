//https://leetcode.com/problems/sort-vowels-in-a-string

// Time Complexity: O(n + k * log k) 
// where n is the length of the string and k is the number of vowels
// Space Complexity: O(3*n) = O(n)
class Solution {
    public String sortVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList(
            'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'
        ));
        StringBuilder result = new StringBuilder();

        Queue<Character> priorityQueueVowels = new PriorityQueue<>();
        List<Integer> vowelsPositions = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(vowels.contains(c)) {
                priorityQueueVowels.add(c);
                vowelsPositions.add(i);
            }
        }

        for(int i = 0; i <  s.length(); i++) {
            char c = s.charAt(i);

            if(vowels.contains(c)) {
                result.append(priorityQueueVowels.poll());
            }
            else {
                result.append(c);
            }
        }

        return result.toString();
    }
}

// Second 
// Time Complexity: O(n)
// Space Complexity: O(n)
import java.util.*;

class Solution {
    private static final Set<Character> VOWELS = Set.of(
        'A','E','I','O','U','a','e','i','o','u'
    );
    
    private static final char[] vowelChars = {
        'A','E','I','O','U','a','e','i','o','u'
    };

    public String sortVowels(String s) {
        int[] count = new int[vowelChars.length];

        // Count vowels
        for (char c : s.toCharArray()) {
            for (int i = 0; i < vowelChars.length; i++) {
                if (c == vowelChars[i]) {
                    count[i]++;
                    break;
                }
            }
        }

        // Rebuild string with re-ordered string
        StringBuilder result = new StringBuilder(s.length());
        int vowelIndex = 0;

        for (char c : s.toCharArray()) {
            if (VOWELS.contains(c)) {
                while (count[vowelIndex] == 0) 
                    vowelIndex++;
                    
                result.append(vowelChars[vowelIndex]);
                count[vowelIndex]--;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}