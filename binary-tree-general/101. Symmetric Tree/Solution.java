class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirrorPair(root.left, root.right);
    }

    private boolean isMirrorPair(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val == t2.val) {
            return isMirrorPair(t1.left, t2.right) && isMirrorPair(t1.right, t2.left);
        }

        return false;
    }
}