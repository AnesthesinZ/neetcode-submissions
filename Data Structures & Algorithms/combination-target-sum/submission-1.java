class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, 0, target, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums, int start, int target, List<Integer> subset) {

        if (start >= nums.length || target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }

        int number = nums[start];
        subset.add(number);
        // add the current number to subset.
        backtrack(nums, start, target - number, subset);
        subset.remove(subset.size() - 1);

        // not add the current number to subset
        backtrack(nums, start + 1, target, subset);
    }
}
