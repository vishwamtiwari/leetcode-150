class Solution {
    private int[][] directions = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    public void gameOfLife(int[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    int activeNeighbors = getActiveNeighbors(board, i, j);
                    if (activeNeighbors < 2 || activeNeighbors > 3) board[i][j] = -2; //will eventually be inactive/0
                } else if (board[i][j] == 0) {
                    int activeNeighbors = getActiveNeighbors(board, i, j);
                    if (activeNeighbors == 3) board[i][j] = -1; //will eventually become active/1
                }
            }
        }
        updateBoard(board);
        return;

    }

    private void updateBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1)
                    board[i][j] = 1;
                if (board[i][j] == -2)
                    board[i][j] = 0;
            }
        }
    }

    private int getActiveNeighbors(int[][] board, int i, int j) {
        int activeNeighbors = 0;
        for (int[] direction: directions) {
            int newRow = i + direction[0];
            int newCol = j + direction[1];

            if (newRow >= 0 && newRow < board.length
                    && newCol >=0 && newCol < board[0].length
                    && (board[newRow][newCol] == 1 || board[newRow][newCol] == -2)) {
                activeNeighbors++;
            }
        }
        return activeNeighbors;
    }
}