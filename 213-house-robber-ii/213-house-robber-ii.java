class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[] a1=Arrays.copyOfRange(nums,1,nums.length);
        int[] a2=Arrays.copyOfRange(nums,0,nums.length-1);
        int[] dp1=new int[nums.length-1];
        int[] dp2=new int[nums.length-1];
        for(int i=0;i<dp1.length;i++){
            dp1[i]=-1;
            dp2[i]=-1;
        }
      return Math.max(robbery(a1,dp1,a1.length-1),robbery(a2,dp2,a2.length-1));
        
    }
    public static int robbery(int[] a,int[] dp,int n){
        if(n==0){
            return a[0];
        }
        if(n==1){
            return Math.max(a[0],a[1]);
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n]= Math.max(robbery(a,dp,n-2)+a[n],robbery(a,dp,n-1));
    }
}