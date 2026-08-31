class Solution {
    //reverse preorder traversal helps build the link between the right subtree and the left subtree
    private TreeNode nextRight = null; //last visited node
    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.left = null;
        root.right = nextRight;
        nextRight = root;
    }
}