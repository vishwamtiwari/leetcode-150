class Solution {
    private Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inOrderTraversal(root);
    }

    private boolean inOrderTraversal(TreeNode root) {
        if (root == null) return true;

        if (!inOrderTraversal(root.left)) return false;
        if (prev != null && root.val <= prev) return false;
        prev = root.val;

        return inOrderTraversal(root.right);
    }
}