class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0)
            return result;

        backtrack(digits, 0, new StringBuilder(), result);

        return result;
    }

    public static void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        if (index == digits.length()) {
            result.add(current.toString());

            return;
        }

        for (char c: mapping[Character.getNumericValue(digits.charAt(index))].toCharArray()) {
            current.append(c);

            backtrack(digits, index+1, current, result);

            current.deleteCharAt(current.length() - 1);
        }
    }
}