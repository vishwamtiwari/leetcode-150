class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) return results;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (leftToRight) {
                    currentLevel.add(current.val);
                } else {
                    currentLevel.add(0, current.val);
                }

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            leftToRight = !leftToRight;

            results.add(currentLevel);
        }
        return results;
    }
}