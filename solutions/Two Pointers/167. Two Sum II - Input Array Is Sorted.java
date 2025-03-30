//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

// First approach - Nested loops
// Time complexity: O(n^2) - Space complexity: O(1)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++)
            for(int j = i + 1; j < numbers.length; j++)
                if(numbers[i] + numbers[j] == target)
                    return new int []{i+1, j+1};


        return new int []{};
    }
}

// Second approach - Break inner loop if sum is greater than target
// Time complexity: O(n^2) but less in average - Space complexity: O(1)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int sum;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                sum = numbers[i] + numbers[j];

                if (sum == target) 
                    return new int[]{i + 1, j + 1};

                if(sum > target)
                    break;
            }
        }
            
        
        return new int[]{};
    }
}

// Third approach - Two pointers. Good if we need one solution
// Time complexity: O(n) - Space complexity: O(1)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1, sum;
        
        while(left < right) {
            sum = numbers[left] + numbers[right];

            if(sum == target)
                return new int []{left + 1, right + 1};
            else if(sum < target)
                left++;
            else // sum > target
                right--;
        }
            
        return new int[]{};
    }
}