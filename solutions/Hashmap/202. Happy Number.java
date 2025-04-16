//https://leetcode.com/problems/happy-number

// First Approach - HashSet
// Time Complexity: O(log n) - Because getBySumOfSquaresOfDigits takes O(log n) time
// Space Complexity: O(n)
class Solution {
    public boolean isHappy(int n) {
        boolean result = false;
        int sum = n;
        Set<Integer> visitedValues = new HashSet<>();

        while(!result) {
            sum = getBySumOfSquaresOfDigits(sum);

            if(sum == 1) {
                result = true;
            } else if(visitedValues.contains(sum)) {
                return false;
            } else {
                visitedValues.add(sum);
            }
        }

        return result;
    }

    private int getBySumOfSquaresOfDigits(int n) {
        int result = 0;

        while(n > 0) {
            int digit = n % 10;
            n = n / 10; 
            result += digit * digit;
        }

        return result;
    }
}

// Second Approach
// Time Complexity: O(log n) - Space Complexity: O(n)
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visitedValues = new HashSet<>();

        while(n != 1) {
            n = getBySumOfSquaresOfDigits(n);

            if(visitedValues.contains(n)) {
                return false;
            }
            
            visitedValues.add(n);
        }

        // Happy number found
        return true;
    }

    private int getBySumOfSquaresOfDigits(int n) {
        int result = 0;

        while(n > 0) {
            int digit = n % 10;
            n = n / 10; 
            result += digit * digit;
        }

        return result;
    }
}

// Third Approach - Floyd's Cycle Detection Algorithm
// Time Complexity: O(log n) - Space Complexity: O(1)
class Solution {
    // Floyd Cycle Detection Algorithm
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getBySumOfSquaresOfDigits(n);

        while (fast != 1 && slow != fast) {
            slow = getBySumOfSquaresOfDigits(slow); // 1 step
            fast = getBySumOfSquaresOfDigits(getBySumOfSquaresOfDigits(fast)); // 2 steps
        }

        return fast == 1; //If == 1, happy number
    }

    private int getBySumOfSquaresOfDigits(int n) {
        int result = 0;

        while(n > 0) {
            int digit = n % 10;
            n = n / 10; 
            result += digit * digit;
        }

        return result;
    }
}

// Fourth Approach - Floyd's Cycle Detection Algorithm with Precomputed Squares
// Time Complexity: O(log n) - Space Complexity: O(1)

class Solution {
    private static final int[] DIGIT_SQUARES = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81};
    // Floyd Cycle Detection Algorithm
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getBySumOfSquaresOfDigits(n);

        // If fast == 1, happy number found
        // If slow == fast, cycle detected
        while (fast != 1 && slow != fast) {
            slow = getBySumOfSquaresOfDigits(slow); // 1 step
            fast = getBySumOfSquaresOfDigits(getBySumOfSquaresOfDigits(fast)); // 2 steps
        }

        return fast == 1; //If == 1, happy number
    }

    private int getBySumOfSquaresOfDigits(int n) {
        int result = 0;

        while(n > 0) {
            int digit = n % 10;
            n = n / 10; 
            result += DIGIT_SQUARES[digit];
        }

        return result;
    }
}