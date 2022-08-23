class Solution {
    public List<List<Integer>> subsets(int[] nums) {
   List<List<Integer>> ans=new ArrayList<>();
        findans(ans,nums,0,new ArrayList<Integer>());
        return ans;
    }
    public static void findans(List<List<Integer>> ans,int[] nums,int ind,ArrayList<Integer> l){
        if(ind==nums.length){
            ans.add(new ArrayList<>(l));
            return;
        }
        l.add(nums[ind]);
        findans(ans,nums,ind+1,l);
        l.remove(l.size()-1);
        findans(ans,nums,ind+1,l);
    }
}





