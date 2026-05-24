class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList<>());
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums, int start, List<Integer> res) {
        for (int i = start; i < nums.length; i++) {
            res.add(nums[i]);
            backtrack(nums, i + 1, res);
            result.add(List.copyOf(res));
            res.remove(res.size() - 1);
        }
    }
}
