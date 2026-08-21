class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char[] tokens = s.replace(" ", "").toCharArray();

        int sign = 1;
        int res = 0;
        int num = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (Character.isDigit(tokens[i])) {
                num = (num * 10) + (tokens[i] - '0');
            } else if (tokens[i] == '+') {
                res += (sign * num);
                num = 0;
                sign = 1;
            } else if (tokens[i] == '-') {
                res += (sign * num);
                num = 0;
                sign = -1;
            } else if (tokens[i] == '(') {
                stack.push(res);
                stack.push(sign);
                num = 0;
                sign = 1;
                res = 0;
            } else if (tokens[i] == ')') {
                res += (sign * num);
                num = 0;

                int start_sign = stack.pop();
                int last_result = stack.pop();

                res *= start_sign;
                res += last_result;
            }
        }
        if (num != 0) {
            res += sign * num;
        }
        return res;
    }
}