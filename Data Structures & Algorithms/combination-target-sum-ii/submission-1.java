class Solution {

    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, new ArrayList<>(), 0);
        return results;
    }

    public void backtrack(int[] candidates, int target, List<Integer> subset, int i) {
        if (target == 0) {
            results.add(new ArrayList<>(subset));
            return;
        }

        if (i >= candidates.length || target < 0) {
            return;
        }

        subset.add(candidates[i]);
        backtrack(candidates, target - candidates[i], subset, i + 1);
        subset.remove(subset.size() - 1);

        while (i + 1 < candidates.length && candidates[i] == candidates[i+1]) {
            i++;
        }
        backtrack(candidates, target, subset, i + 1);
    }


}
