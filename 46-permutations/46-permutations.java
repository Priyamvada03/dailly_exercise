class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        perm(nums,ans,0,nums.length-1,new ArrayList<>());
        return ans;
    }
    public static void perm(int[] nums,List<List<Integer>> ans,int i,int j, List<Integer> permutation){
        if(i==j){
            List < Integer > ds = new ArrayList < > ();
            for (int ii = 0; ii < nums.length; ii++) {
                ds.add(nums[ii]);
            }
            ans.add(new ArrayList < > (ds));
            return;
        }
        else{
            for(int k=i;k<=j;k++){
                nums=swap(nums,i,k);
                perm(nums,ans,i+1,j,permutation);
                nums=swap(nums,i,k);
            }
        }
    }
    
    public static int[] swap(int[] nums,int i,int j){
       int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        return nums;
    }
}