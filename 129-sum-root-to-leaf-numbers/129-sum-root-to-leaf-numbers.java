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
    public int sumNumbers(TreeNode root) {
        int[] sum={0};
        findsum(root,0,sum);
        return sum[0];
    }
    public static void findsum(TreeNode root,int cur,int[] sum){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            cur=cur*10+root.val;
            sum[0]+=cur;
            return;
        }
        findsum(root.left,cur*10+root.val,sum);
        findsum(root.right,cur*10+root.val,sum);
    }
}