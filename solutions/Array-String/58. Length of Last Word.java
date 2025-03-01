//https://leetcode.com/problems/length-of-last-word

// First solution - Time Efficiency: O(n) - Space Efficiency O(1)
class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;

        // Ignore empty spaces at the end
        while (i >= 0 && s.charAt(i) == ' ')
            i--;

        // Count lastWord length
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}

// Second Solution - Optimized
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();  // Eliminate empty spaces at the end and begining
        return s.length() - 1 - s.lastIndexOf(' ');
    }
}