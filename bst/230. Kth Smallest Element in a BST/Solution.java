class Solution {
    int counter = 0;
    Integer ans = null;
    public int kthSmallest(TreeNode root, int k) {
        counter = 0;
        ans = null;

        inOrderTraversal(root, k);
        return ans;
    }

    private void inOrderTraversal(TreeNode root, int k) {
        if (root == null || ans != null) return;

        inOrderTraversal(root.left, k);
        counter++;
        if (counter == k) {
            ans = root.val;
            return;
        }
        inOrderTraversal(root.right, k);
    }
}