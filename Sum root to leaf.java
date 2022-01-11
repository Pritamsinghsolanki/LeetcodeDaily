class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return solve(root, 0);
    }

    public static int solve(TreeNode root, int val) {
        if (root == null)
            return 0;
        val = 2 * val + root.val;
        if (root.left == null && root.right == null)
            return val;
        int left = solve(root.left, val);
        int right = solve(root.right, val);
        return left + right;
    }
}