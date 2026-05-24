class Solution {

    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) { 
        backtrack(nums, new ArrayList<>());
        return results;
    }

    public void backtrack(int[] nums, List<Integer> subset) {
        if (subset.size() == nums.length) {
            results.add(new ArrayList<>(subset));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -100) {
                subset.add(nums[i]);
                int temp = nums[i];
                nums[i] = -100;
                backtrack(nums, subset);
                nums[i] = temp;
                subset.remove(subset.size() - 1);
            }
        }
    }
}
