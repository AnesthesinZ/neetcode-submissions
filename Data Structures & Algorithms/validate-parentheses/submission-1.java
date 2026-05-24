class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> lookup = new HashMap<>();
        Stack<Character> openers = new Stack<>();

        lookup.put(')', '(');
        lookup.put(']', '[');
        lookup.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                openers.add(ch);
            } else if (openers.isEmpty()){
                return false;                
            } else {
                char top = openers.pop();
                if (lookup.get(ch) != top) {
                    return false;
                }
            }
        }

        return openers.isEmpty();

    }
}
