//https://leetcode.com/problems/sqrtx

// First Approach - Linear Search
// Time Complexity: O(sqrt(n))
class Solution {
    public int mySqrt(int x) {
        if(x == 0)
            return 0;

        int currentVal = 2;
        long currentSquaredVal = 4;

        while(currentSquaredVal <= x) {
            currentVal++;
            currentSquaredVal = (long) currentVal * currentVal;
        }

        return currentVal - 1;
    }
}

// Second Approach - Binary Search
// Time Complexity: O(log(n))

class Solution {
    public int mySqrt(int x) {
        if(x < 2)
            return x;

        // All the possible solutions will be in this interval for x >= 2
        int left = 1, right = x / 2;
        int mid;
        long squaredMid;

        while(left <= right) {
            // Get the mid value in the current interval
            mid = left + ((right - left) / 2);
            squaredMid = (long) mid * mid;
        
            if(squaredMid == x)
                return mid;
            else if(squaredMid < x)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return right;
    }
}