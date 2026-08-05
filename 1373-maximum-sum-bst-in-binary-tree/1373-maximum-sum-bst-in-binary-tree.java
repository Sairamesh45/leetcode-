/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;

    class Info
    {
        int max;
        int min;
        boolean isBST;
        int sum;

        Info(int max,int min, boolean isBST, int sum)
        {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
            this.sum = sum;
        }
    }
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    public Info dfs(TreeNode root)
    {
        if(root == null) return new Info(Integer.MIN_VALUE,Integer.MAX_VALUE,true,0);

        Info left = dfs(root.left);
        Info right = dfs(root.right);

        if(left.isBST && right.isBST && root.val > left.max && root.val < right.min)
        {
            int sum = left.sum + root.val + right.sum;

            ans = Math.max(sum,ans);

            return new Info(Math.max(root.val,right.max),Math.min(root.val,left.min),true,sum);
        }

        return new Info(0,0,false,0);
    }
}