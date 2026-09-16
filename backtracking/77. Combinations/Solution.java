class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(n, k, 1, result, new ArrayList<>());

        return result;
    }

    void backtrack (int n, int k, int num, List<List<Integer>> result, List<Integer> combination) {
        if (combination.size() == k) {
            result.add(new ArrayList<>(combination));

            return;
        }

        for (int j = num; j <= n - (k - combination.size()) + 1; j++) {
            combination.add(j);

            backtrack(n, k, j+1, result, combination);

            combination.remove(combination.size() - 1);
        }
    }
}