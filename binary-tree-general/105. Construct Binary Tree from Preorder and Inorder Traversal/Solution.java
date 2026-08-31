class Solution {
    private HashMap<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length -1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd,
                            int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inRoot = inMap.get(rootVal);
        int numsLeft = inRoot - inStart;

        root.left = helper(preorder, preStart + 1, preStart + numsLeft,
                inorder, inStart, inRoot - 1);
        root.right = helper(preorder, preStart + numsLeft + 1, preEnd,
                inorder, inRoot + 1, inEnd);

        return root;
    }
}