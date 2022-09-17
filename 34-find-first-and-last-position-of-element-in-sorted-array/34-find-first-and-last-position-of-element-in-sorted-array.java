class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[2];
        res[0]=findSidx(nums,target);
        res[1]=findEidx(nums,target);
        return res;
    }
    public static int findSidx(int[] nums,int target){
        int i=0;
        int j=nums.length-1;
        int ans=-1;
        while(i<=j){
          int m= i+(j-i)/2;
            if(nums[m]==target){
                ans=m;
            }
          if(nums[m]<target){
            
              i=m+1;
          }
            else{
                j=m-1;
            }
        }
        return ans;
    }
       public static int findEidx(int[] nums,int target){
        int i=0;
        int j=nums.length-1;
        int ans=-1;
        while(i<=j){
          int m= i+(j-i)/2;
            if(nums[m]==target){
                ans=m;
            }
          if(nums[m]<=target){
            i=m+1;
              
          }
            else{
                 
               j=m-1;
            }
        }
        return ans;
    }
}