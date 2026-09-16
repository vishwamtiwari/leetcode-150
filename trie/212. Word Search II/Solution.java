class Solution {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; // Holds the complete word at leaf nodes
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = new TrieNode();

        for (String word: words) {
            TrieNode current = root;

            for (char ch: word.toCharArray()) {
                int index = ch - 'a';

                if (current.children[index] == null)
                    current.children[index] = new TrieNode();

                current = current.children[index];
            }

            current.word = word; // Store full word at the end of the branch
        }

        // Launch DFS from every cell on the board
        int rows = board.length;
        int cols = board[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, result);
            }
        }

        return result;
    }

    void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
        char ch = board[r][c];

        // Boundary/visited check or no matching prefix in Trie
        if (ch == '#' || node.children[ch - 'a'] == null)
            return;

        node = node.children[ch - 'a'];

        // Found a word from the dictionary
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // De-duplicate so it isn't added twice
        }

        // Mark cell visited in-place
        board[r][c] = '#';

        // Explore 4 directions
        int[] dRow = new int[] {-1, 1, 0, 0};
        int[] dCol = new int[] {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nRow = r + dRow[i];
            int nCol = c + dCol[i];

            if (nRow >=0 && nRow < board.length && nCol >=0 && nCol < board[0].length) {
                dfs(board, nRow, nCol, node, result);
            }
        }

        // Backtrack
        board[r][c] = ch;
    }
}