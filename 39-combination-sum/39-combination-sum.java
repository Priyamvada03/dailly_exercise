class Solution {
    public List<List<Integer>> combinationSum(int[] a, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();  
        combSum(0,ans,a,target,ls); 
        return ans;
    }
    public static void combSum(int idx,List<List<Integer>> ans,int[]a,int tar,List<Integer> ls){
      
        if(idx==a.length){
            if(tar==0){
            ans.add(new ArrayList<>(ls));
            
        }
            return;
        }
        if(tar-a[idx]>=0){
            ls.add(a[idx]);
            combSum(idx,ans,a,tar-a[idx],ls);
            ls.remove(ls.size()-1);
        }
        
        combSum(idx+1,ans,a,tar,ls);
    }
}