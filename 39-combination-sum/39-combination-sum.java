class Solution {
    public List<List<Integer>> combinationSum(int[] a, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        trace(ans,temp,target,0,a);
        return ans;
    }
    
    public static void trace(List<List<Integer>> ans,List<Integer> temp,int tar,int i,int[] a){
        if(tar==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(i==a.length){
            return;
        }
        if(tar-a[i]>=0){
            temp.add(a[i]);
            trace(ans,temp,tar-a[i],i,a);
            temp.remove(temp.size()-1);
        }
         trace(ans,temp,tar,i+1,a);
    }
}