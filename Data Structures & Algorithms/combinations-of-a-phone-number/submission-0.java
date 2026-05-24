class Solution {

    Map<Integer, List<Character>> digMap = new HashMap<>();
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return res;
        }

        digMap.put(2, List.of('a', 'b', 'c'));
        digMap.put(3, List.of('d', 'e', 'f'));
        digMap.put(4, List.of('g', 'h', 'i'));
        digMap.put(5, List.of('j', 'k', 'l'));
        digMap.put(6, List.of('m', 'n', 'o'));
        digMap.put(7, List.of('p', 'q', 'r', 's'));
        digMap.put(8, List.of('t', 'u', 'v'));
        digMap.put(9, List.of('w', 'x', 'y', 'z'));

        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    public void backtrack(String digits, int digitIdx, StringBuilder sb) {

        if (digitIdx == digits.length()) {
            res.add(sb.toString());
            return;
        }

        int curDigit = digits.charAt(digitIdx) - '0';
        List<Character> valList = digMap.get(curDigit);

        for (int i = 0; i < valList.size(); i++) {
            sb.append(valList.get(i));
            backtrack(digits, digitIdx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
