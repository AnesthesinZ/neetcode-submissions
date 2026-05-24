class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> values = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if (token.equals("+")) {
                int right = values.pop();
                int left = values.pop();
                values.add(left + right);
            } else if (token.equals("-")) {
                int right = values.pop();
                int left = values.pop();
                values.add(left - right);
            } else if (token.equals("*")) {
                int right = values.pop();
                int left = values.pop();
                values.add(left * right);
            } else if (token.equals("/")) {
                int right = values.pop();
                int left = values.pop();
                values.add(left / right);
            } else {
                values.add(Integer.parseInt(token));
            }
        }

        return values.peek();
    }
}
