class Solution {
    int minDiff = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);

        return minDiff;
    }

    private void inOrderTraversal(TreeNode root) {
        if (root == null) return;

        inOrderTraversal(root.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, (root.val - prev));
        }

        prev = root.val;

        inOrderTraversal(root.right);
    }
}