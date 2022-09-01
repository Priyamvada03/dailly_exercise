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
    public TreeNode buildTree(int[] pre, int[] in) {
        int n=in.length-1;
        int [] ps=new int[1];
        ps[0]=0;
        return create(pre,in,0,n,ps); }
    public static TreeNode create(int[] pre ,int[] in,int s,int e,int[] ps){
        if(s>e || ps[0]>in.length-1){
            return null; }
        TreeNode tnode=new TreeNode(pre[ps[0]++]);
        int idx=search(in,s,e,tnode.val);
        tnode.left=create(pre,in,s,idx-1,ps);
        tnode.right=create(pre,in,idx+1,e,ps);
        return tnode;
        
    }
  public static int search(int arr[], int strt, int end, int value)
    {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return i;
    }
}