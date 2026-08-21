class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] tokens = path.split("/");

        for (String token: tokens) {
            if (token.equals("") || token.equals(".")) continue;
            else if (token.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            }
            else stack.push(token);
        }

        String res = "/" + String.join("/", stack);
        return res;
    }
}