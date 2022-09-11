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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> temp =new ArrayList<>();
        track(root,targetSum,ans,temp);
        return ans;
    }
    public static void track(TreeNode root,int tar,List<List<Integer>> ans,List<Integer> temp){
        if (root==null){
            return;
        }
         temp.add(root.val);
        if(root.left==null && root.right==null && root.val==tar){
          
            ans.add(new ArrayList<>(temp));
        }
       
        
        track(root.left,tar-root.val,ans,temp);
        track(root.right,tar-root.val,ans,temp);
        temp.remove(temp.size()-1);
    }
}