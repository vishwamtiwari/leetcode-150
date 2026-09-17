class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(n, 0, 0, new StringBuilder(), result);

        return result;
    }

    void backtrack (int n, int openCount, int closedCount, StringBuilder combination, List<String> result) {
        if (combination.length() == 2 * n) {
            result.add(combination.toString());

            return;
        }

        if (openCount < n) {
            combination.append("(");

            backtrack(n, openCount + 1, closedCount, combination, result);

            combination.deleteCharAt(combination.length() - 1);
        }

        if (closedCount < openCount) {
            combination.append(")");

            backtrack(n, openCount, closedCount + 1, combination, result);

            combination.deleteCharAt(combination.length() - 1);
        }
    }
}