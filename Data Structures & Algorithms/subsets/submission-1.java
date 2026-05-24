class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums, int start, List<Integer> subset) {
        if (start >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        // path that add current number
        subset.add(nums[start]);
        backtrack(nums, start + 1, subset);

        // path that not add current number
        subset.remove(subset.size() - 1);
        backtrack(nums, start + 1, subset);
    }
}
