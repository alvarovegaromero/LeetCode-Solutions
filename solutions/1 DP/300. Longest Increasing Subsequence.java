//https://leetcode.com/problems/longest-increasing-subsequence

// Time Complexity: O(n log n) - Binary Search for each element
// Space Complexity: O(n) - subsequence list
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> subsequence = new ArrayList<>();

        for(int num: nums) {
            // If subsequence is empty or num is larger than last number
            if(subsequence.isEmpty() || num > subsequence.get(subsequence.size() - 1))
                subsequence.add(num);
            else {
                // Find right position to replace
                int left = 0, right = subsequence.size() - 1;

                while (left < right) {
                    int mid = (left + right) / 2;

                    if(subsequence.get(mid) < num)
                        left = mid + 1;
                    else
                        right = mid;
                }

                // Replace smallest num greater or equal than num;
                subsequence.set(left, num);
            }
        }

        return subsequence.size();
    }
}