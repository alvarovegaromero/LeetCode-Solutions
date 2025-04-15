//https://leetcode.com/problems/3sum

// First Approach
// Time Complexity: O(n^2) - Sorting takes O(nlogn) and two pointers take O(n^2)
// Space Complexity: O(n^2) - O(n) only if we don't count the output list
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Sort the array first to handle duplicates easily
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            // Skip duplicates
            if(i > 0 && nums[i] == nums[i - 1]) 
                continue;

            List<List<Integer>> pairs = twoSum(nums, -nums[i], i + 1);

            for(List<Integer> pair : pairs) {
                List<Integer> triplet = new ArrayList<>();
                triplet.add(nums[i]);
                triplet.add(nums[pair.get(0)]);
                triplet.add(nums[pair.get(1)]);

                result.add(triplet);
            }
        }

        return result;
    }

    // Return all non-repeated pairs that sum to target 
    private List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> pairs = new ArrayList<>();
        int left = start, right = nums.length - 1;
        
        while(left < right) {
            int sum = nums[left] + nums[right];
            
            if(sum == target) {
                List<Integer> pair = Arrays.asList(left, right);
                pairs.add(pair);
                
                // Skip duplicates if solution found
                while(left < right && nums[left] == nums[left + 1]) 
                    left++;
                while(left < right && nums[right] == nums[right - 1]) 
                    right--;
                
                left++;
                right--;
            } else if(sum < target)
                left++;
            else
                right--;
        }
        
        return pairs;
    }
}

// Second Approach - Optimized
// Time Complexity: O(n^2)
// Space Complexity: O(n^2) - O(1) if we don't count the output list
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Sort the array first to handle duplicates easily
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) 
                continue;
                
            // Early termination: if number is positive, sum can't be zero
            if (nums[i] > 0)
                break;

            twoSum(nums, -nums[i], i + 1, result);
        }

        return result;
    }

    // Add pairs directly to the result list
    private void twoSum(int[] nums, int target, int start, List<List<Integer>> result) {
        int left = start, right = nums.length - 1;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            
            if (sum == target) {
                // Create and add triplet directly to result
                result.add(Arrays.asList(-target, nums[left], nums[right]));
                
                // Skip duplicates if solution found
                while (left < right && nums[left] == nums[left + 1]) 
                    left++;
                while (left < right && nums[right] == nums[right - 1]) 
                    right--;
                
                left++;
                right--;
            } else if (sum < target)
                left++;
            else
                right--;
        }
    }
}

// Third Approach - Using HashMap. Not optimal but an alternative
// Time Complexity: O(n^2)
// Space Complexity: O(n^2) - O(n) if we don't count the output list

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++)
            findPairs(nums, i, result);

        return new ArrayList<>(result);
    }

    private void findPairs(int[] nums, int index, Set<List<Integer>> result) {
        int target = -nums[index];
        // Store value and position. Save when iterated over it
        Map<Integer, Integer> seen = new HashMap<>();

        for(int i = index + 1; i < nums.length; i++) {
            int complement = target - nums[i];

            if(seen.containsKey(complement)){
                List<Integer> triplet = Arrays.asList(nums[index], nums[i], complement);

                //Sort to ensure uniqueness
                Collections.sort(triplet);
                result.add(triplet);
            }

            seen.put(nums[i], i);
        }
    }
}