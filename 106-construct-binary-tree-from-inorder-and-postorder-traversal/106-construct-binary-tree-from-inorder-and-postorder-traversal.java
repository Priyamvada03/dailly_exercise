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
    public TreeNode buildTree(int[] in, int[] post) {
        int n=in.length;
        int m=post.length;
       return build(in,post,0,n-1,0,m-1);
    }
    public static TreeNode build(int[] in ,int[] post, int ins,int ine,int ps,int pe){
        if(ins>ine || ps>pe){
            return null;
        }
        TreeNode root=new TreeNode(post[pe]);
        int t= search(root.val,in,ins,ine);
        root.left=build(in,post,ins,t-1,ps,ps+t-ins-1);
        root.right=build(in,post,t+1,ine,ps+t-ins,pe-1);
        return root;
    }
    public static int search(int valu,int[] in,int ins,int ine){
        for(int i=ins;i<=ine;i++){
            if(in[i]==valu){
                return i;
                
            }
        }
        return -1;
    }
}