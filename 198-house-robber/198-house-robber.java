class Solution {
    public int rob(int[] nums) {
       int n=nums.length;
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        dp[0]=nums[0];
        return find(nums,n-1,dp);
    }
    public static int find(int[] nums,int i,int[] dp){
        if(i==0 ){
            return dp[0];
        }
        if(i==1){
            return Math.max(nums[0],nums[1]);
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        return dp[i]=Math.max(nums[i]+find(nums,i-2,dp),find(nums,i-1,dp));
    }
}