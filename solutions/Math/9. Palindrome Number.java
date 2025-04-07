//https://leetcode.com/problems/palindrome-number

// First Approach - Use Deque and compare first and last elements
// Time Complexity: O(n) - Space Complexity: O(n)
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;

        int remainingInteger = x;
        Deque<Integer> dequeue = new ArrayDeque<>();

        while(remainingInteger > 0) {
            dequeue.addLast(remainingInteger % 10);
            remainingInteger /= 10;
        }
        
        // If odd number of elements, middle one shouldn't be processed
        while(dequeue.size() > 1) {
            if(dequeue.pollFirst() != dequeue.pollLast())
                return false;
        }

        return true;
    }
}

// Second Approach - Reverse the second number
// Time Complexity: O(n) - Space Complexity: O(1)
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) 
            return false;

        int original = x;
        int reversed = 0;
        int digit;

        while (x != 0) {
            digit = x % 10;

            // Constraint: int values without possible overflow. 
            // In case of handling possible overflow we would use this:
            // if (reversed > (Integer.MAX_VALUE - digit) / 10) 
            //    return false;
            
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        return original == reversed;
    }
}

// Third Approach - Reverse the first half of the number
// Time Complexity: O(log(n)) - Space Complexity: O(1)
class Solution {
    public boolean isPalindrome(int x) {
        // Negative or multiple of 10 (except 0) numbers can't be palindrome
        // Consider multiple of 10 as in odd numbers of digits, 
        // we need to ignore the middle digit
        if (x < 0 || (x % 10 == 0 && x != 0)) 
            return false;

        int reversed = 0;
        int digit;

        while (x > reversed) {
            digit = x % 10;
            
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        return (x == reversed) || (x == (reversed / 10));
    }
}