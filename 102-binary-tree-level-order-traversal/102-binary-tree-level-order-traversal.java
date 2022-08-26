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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        int h=height(root);
        for(int i=1;i<=h;i++){
            ArrayList<Integer> temp=new ArrayList<>();
            levelorder(root,i,1,temp);
            ans.add(temp);
        }
        return ans;
    }
    public static void levelorder(TreeNode root,int i,int l,ArrayList<Integer> temp){
        if(root==null){
            return;
        }
        if(l==i){
            temp.add(root.val);
        }
        levelorder(root.left,i,l+1,temp);
        levelorder(root.right,i,l+1,temp);
    }
    public static int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=height(root.left);
        int h=height(root.right);
        return 1+Math.max(l,h);
    }
}