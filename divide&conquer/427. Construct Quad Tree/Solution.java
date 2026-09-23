class Solution {
    public Node construct(int[][] grid) {
        return solve(grid, 0, 0, grid.length);
    }

    public Node solve(int[][] grid, int x, int y, int n) {
        if (areAllSame(grid, x, y, n)) {
            return new Node(grid[x][y] == 1, true);
        }
        else {
            Node root = new Node(true, false);

            root.topLeft = solve(grid, x, y, n/2);
            root.topRight = solve(grid, x, y + n/2, n/2);
            root.bottomLeft = solve(grid, x + n/2, y, n/2);
            root.bottomRight = solve(grid, x + n/2, y + n/2, n/2);

            return root;
        }
    }

    boolean areAllSame(int[][] grid, int x, int y, int n) {
        int val = grid[x][y];

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (grid[i][j] != val)
                    return false;
            }
        }

        return true;
    }
}