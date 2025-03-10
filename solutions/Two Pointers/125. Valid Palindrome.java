//https://leetcode.com/problems/valid-palindrome

// First Solution - Time complexity: O(n) - Space complexity: O(n)
class Solution {
    public boolean isPalindrome(String s) {
        // Remove spaces and all the stuff that is not a letter/number
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        Deque<Character> queue = new ArrayDeque<>();
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toLowerCase().toCharArray()) {
            queue.offer(c);
            stack.push(c);
        }

        while (!queue.isEmpty())
            if (queue.poll() != stack.pop()) 
                return false;

        return true;
    }
}

// Second Solution - Time complexity: O(n) - Space complexity: O(1)
class Solution {
    public boolean isPalindrome(String s) {
        // Remove spaces and all the stuff that is not a letter/number
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int left = 0, right = s.length() - 1;

        while(left < right) { 
            if(s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }
        
        return true;
    }
}
