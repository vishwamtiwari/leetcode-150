class Solution {
    int n;

    private int[] getCoord(int num) {
        int rowFromTop = (num-1)/n;
        int rowFromBottom = (n-1) - rowFromTop;

        int col = (num-1)%n;

        // right to left
        if ((n%2 == 1 && rowFromBottom%2 == 1) || (n%2 == 0 && rowFromBottom%2 == 0)) {
            col = (n-1) - col;
        }

        return new int[]{rowFromBottom, col};
    }


    public int snakesAndLadders(int[][] board) {
        n = board.length;

        int steps = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        visited[n-1][0] = true;

        queue.offer(1);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                int x = queue.poll();
                size--;

                if (x == n * n)
                    return steps;

                for (int k = 1; k <= 6; k++) {
                    int val = x+k;

                    if (val > n * n)
                        break;

                    int[] coord = getCoord(val);
                    int row = coord[0];
                    int col = coord[1];

                    if (visited[row][col])
                        continue;

                    visited[row][col] = true;
                    if (board[row][col] == -1) {
                        queue.offer(val);
                    } else {
                        queue.offer(board[row][col]);
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}