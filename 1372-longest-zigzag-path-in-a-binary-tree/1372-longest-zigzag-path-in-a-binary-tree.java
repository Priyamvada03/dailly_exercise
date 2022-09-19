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
    public int longestZigZag(TreeNode root) {
      return  find(root,0,null);
    }
   private enum Direction {
	RIGHT, LEFT;
}
    public static int find(TreeNode root,int sum,Direction dir){
        if(root==null){
            return sum-1;
        }
        int left=find(root.left,dir==Direction.LEFT ? 1 : sum + 1,Direction.LEFT);
        int right=find(root.right,dir==Direction.RIGHT? 1 : sum + 1,Direction.RIGHT);
        return Math.max(left,right);
    }
}




