class Solution {

    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), 0);
        return results;
    }

    public void backtrack(int[] nums, List<Integer> subset, int i) {
        if (i == nums.length) {
            results.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(nums, subset, i + 1);
        subset.remove(subset.size() - 1);

        while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
            i ++;
        }

        backtrack(nums, subset, i + 1);
    }
}
