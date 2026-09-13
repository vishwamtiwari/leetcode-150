class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankset =  new HashSet<>(Arrays.asList(bank));

        Set<String> visited = new HashSet<>();

        Queue<String> queue = new ArrayDeque<>();

        queue.offer(startGene);
        visited.add(startGene);

        int level = 0;

        // BFS traversal
        while (!queue.isEmpty()) {
            int n = queue.size();

            while (n > 0) {
                String current = (String) queue.poll();

                if (current.equals(endGene))
                    return level;

                char[] chars = current.toCharArray();
                for (int i = 0; i < current.length(); i++) {
                    char original = chars[i];

                    for (char ch: "ACGT".toCharArray()) {
                        if (ch == original)
                            continue;

                        chars[i] = ch;

                        String nextGene = String.valueOf(chars);

                        if (!visited.contains(nextGene) && bankset.contains(nextGene)) {
                            visited.add(nextGene);
                            queue.add(nextGene);
                        }
                    }

                    chars[i] = original; // backtrack char
                }

                n--;
            }

            level++;
        }

        return -1;
    }
}