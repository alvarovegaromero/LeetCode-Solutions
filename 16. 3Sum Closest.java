//https://leetcode.com/problems/3sum-closest

// First Approach
// Time Complexity: O(n^2) - Space Complexity: O(1)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        
        for(int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            
            int left = i + 1, right = nums.length - 1;
            
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                // Update closest if current sum is closer to target
                if(Math.abs(sum - target) < Math.abs(closest - target))
                    closest = sum;
                
                if(sum < target)
                    left++;
                else if(sum > target)
                    right--;
                else // Equal to target.
                    return target;
            }
        }
        
        return closest;
    }
}

// Second Approach
// Time Complexity: O(n^2) - Space Complexity: O(1)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        
        for(int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            
            // Find twoSum that is equal (close) to the remaining part of target - nums[i]
            int twoSumValue = twoSumClosest(nums, i + 1, target - nums[i]);
            int currentSum = nums[i] + twoSumValue;
            
            // Update closest sum if needed
            if(Math.abs(currentSum - target) < Math.abs(closest - target))
                closest = currentSum;
            
            if(closest == target)
                return target;
        }
        
        return closest;
    }
    
    // Find the sum of two elements closest to target
    private int twoSumClosest(int[] nums, int start, int target) {
        int left = start, right = nums.length - 1;
        int closest = nums[left] + nums[right];
        
        while(left < right) {
            int sum = nums[left] + nums[right];
            
            if(Math.abs(sum - target) < Math.abs(closest - target))
                closest = sum;
            
            if(sum < target)
                left++;
            else if(sum > target)
                right--;
            else // Sum that is equal to target found
                return target;
        }
        
        return closest;
    }
}