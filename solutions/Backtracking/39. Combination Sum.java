//https://leetcode.com/problems/combination-sum

// Time Complexity: O(2^n) - where n is the number of candidates
// Because we explore all combinations of candidates (candidate can either be included or not)
// Space Complexity: O(n) - where n is the maximum depth of the recursion stack
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Help avoiding duplicated by sorting
        Arrays.sort(candidates);

        List<List<Integer>> results = new ArrayList<>();
        backtracking(0, target, new ArrayList<>(), candidates, results);
        return results;
    }

    void backtracking(int start, int target, List<Integer> currentCombination,
                      int[] candidates, List<List<Integer>> results) {
        // Valid combination
        if(target == 0) {
            results.add(new ArrayList<>(currentCombination));
            return;
        }

        // Try each candidate starting from start index
        for(int i = start; i < candidates.length; i++) {
            // Stop, prune the branch if we can not use current value
            if(candidates[i] > target)
                break;

            currentCombination.add(candidates[i]);
            backtracking(i, target - candidates[i], currentCombination,
                        candidates, results);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}