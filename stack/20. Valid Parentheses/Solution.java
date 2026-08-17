class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();

        for (char c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else {
                if (stack.isEmpty()) return false;

                char ch = stack.peek();
                if ((c == ')' && ch == '(') || (c == '}' && ch == '{') || (c == ']' && ch == '[')) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}