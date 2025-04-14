//https://leetcode.com/problems/contains-duplicate-ii

// First Approach - 
// Time Complexity: O(n^2) - Space Complexity: O(1)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j] && Math.abs(i - j) <= k)
                    return true;
            }
        }

        return false;
    }
}

// Second Approach - Brute Force  with a limit on the second loop
// Time Complexity: O(n) - Space Complexity: O(n)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length && Math.abs(i - j) <= k; j++) {
                if(nums[i] == nums[j])
                    return true;
            }
        }

        return false;
    }
}

// Third Approach - Using HashSet
// Time Complexity: O(n) - Space Complexity: O(k)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> previousKValues = new HashSet<>();

        // Initialize sliding window
        for(int i = 0; i < k && i < nums.length; i++) {
            if(previousKValues.contains(nums[i]))
                return true;

            previousKValues.add(nums[i]); 
        }

        for(int i = k; i < nums.length; i++) {
            if(previousKValues.contains(nums[i]))
                return true;

            previousKValues.add(nums[i]);
            previousKValues.remove(nums[i - k]);
        }

        return false;
    }
}

// Fourth Approach - Using HashSet optimized
// Time Complexity: O(n) - Space Complexity: O(k)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> previousKValues = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!previousKValues.add(nums[i]))
                return true;

            if (previousKValues.size() > k)
                previousKValues.remove(nums[i - k]);
        }

        return false;
    }
}