class Solution {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxSum;
    }

    private int solve(TreeNode root) {
        if (root == null)
            return 0;

        int leftSum = solve(root.left);
        int rightSum = solve(root.right);

        int leftOrRightMax = Math.max(leftSum, rightSum) + root.val;
        int onlyRootMax = root.val;
        int leftAndRightMax = leftSum + rightSum + root.val;

        maxSum = Math.max(Math.max(maxSum, onlyRootMax), Math.max(leftOrRightMax, leftAndRightMax));

        return Math.max(onlyRootMax, leftOrRightMax);
    }
}