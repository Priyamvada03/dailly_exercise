/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans=new ArrayList<>();
        if(root==null){  return ans;     }
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        findparent(map,root);
        HashSet<TreeNode> set=new HashSet<>();
          Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        while(q.size()>0){
            int s=q.size();
            for(int i=0;i<s;i++){
                TreeNode temp=q.poll();
                set.add(temp);
                if(k==0){
                    ans.add(temp.val);
                }  
                if(temp.left!=null && !set.contains(temp.left)){
                    q.add(temp.left);
                }
                if(temp.right!=null && !set.contains(temp.right)){
                    q.add(temp.right);
                }
                if(map.containsKey(temp) && !set.contains(map.get(temp))){
                    q.add(map.get(temp));
                }
            }
            k--;
            
        }
        return ans;
    }
    
    public static void findparent(HashMap<TreeNode,TreeNode> map,TreeNode root){
        if(root==null){
            return;
        }
        if(root.left!=null){
            map.put(root.left,root);
        }
        if(root.right!=null){
            map.put(root.right,root);
        }
        findparent(map,root.left);
        findparent(map,root.right);
    }
}

