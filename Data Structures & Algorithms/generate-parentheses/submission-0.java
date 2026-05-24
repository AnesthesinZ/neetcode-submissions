class Solution {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), 0, 0, n);
        return res;
    }

    public void backtrack(StringBuilder sb, int open, int close, int total) {
        if (close == total && open == close) {
            res.add(sb.toString());
            return;
        }

        if (open < total) {
            sb.append('(');
            backtrack(sb, open + 1, close, total);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(')');
            backtrack(sb, open, close + 1, total);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
