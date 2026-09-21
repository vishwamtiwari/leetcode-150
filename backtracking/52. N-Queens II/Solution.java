class Solution {
    //Time Complexity: O(N!)
    //Space Complexity: O(N)

    public int totalNQueens(int n) {
        boolean cols[]= new boolean[n];
        boolean diags[]= new boolean[2*n-1];
        boolean antiDiags[]= new boolean[2*n-1];

        return backtrack(cols, diags, antiDiags, 0, n);
    }

    private int backtrack(boolean cols[], boolean diags[], boolean antiDiags[], int row, int n){
        if(row == n){
            return 1;
        }

        int count = 0;

        for(int col=0;col<n;col++){
            int diagId= row-col+n-1;
            int antiDiagId = row+col;

            if(cols[col] || diags[diagId] || antiDiags[antiDiagId])
                continue;

            cols[col]=true;
            diags[diagId]=true;
            antiDiags[antiDiagId]=true;

            count += backtrack(cols, diags, antiDiags, row+1, n);

            cols[col]=false;
            diags[diagId]=false;
            antiDiags[antiDiagId]=false;
        }

        return count;
    }
}