class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        
        perm(list,nums,0,nums.length-1,new ArrayList<>());
        
        return list;
    }
    public static void perm(List<List<Integer>> list,int[] nums,int i,int n,List<Integer> permutation){
        if(i==n){
            List<Integer> ds=new ArrayList<>();
            for (int ii = 0; ii < nums.length; ii++) {
                ds.add(nums[ii]);
            }
            list.add(new ArrayList<>(ds));
            return;
        }
        HashSet<Integer> set=new HashSet<>();
        for(int j=i;j<=n;j++){
            if(set.contains(nums[j])){
                continue;
            }
            set.add(nums[j]);
            nums=swap(nums,j,i);
            perm(list,nums,i+1,n,permutation);
            nums=swap(nums,j,i);
            
        }
    }
     public static int[] swap(int[] nums,int i,int j){
       int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        return nums;
    }
}


