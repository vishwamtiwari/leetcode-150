class Solution {
    private HashMap<Integer, Integer> inMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return helper(postorder, 0, postorder.length - 1,
                inorder, 0, inorder.length -1);
    }

    private TreeNode helper(int[] postorder, int postStart, int postEnd,
                            int[] inorder, int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd) return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int inRoot = inMap.get(rootVal);
        int numsLeft = inRoot - inStart;

        root.left = helper(postorder, postStart, postStart + numsLeft - 1,
                inorder, inStart, inRoot - 1);
        root.right = helper(postorder, postStart + numsLeft, postEnd - 1,
                inorder, inRoot + 1, inEnd);

        return root;
    }
}