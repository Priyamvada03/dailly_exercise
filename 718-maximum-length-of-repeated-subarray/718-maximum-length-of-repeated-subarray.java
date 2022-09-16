class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int [] ans={0};
        int[][] dp=new int[1000][1000];
        for(int i=0;i<1000;i++){
            for(int j=0;j<1000;j++){
                dp[i][j]=-1;
            }
        }
        trace(nums1,nums1.length-1,nums2,nums2.length-1,ans,dp);
        return ans[0];
    }
    public static int trace(int[] n1,int n,int[] m1,int m,int[] ans,int[][] dp){
        if(n<0 || m<0){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        trace(n1,n,m1,m-1,ans,dp);
        trace(n1,n-1,m1,m,ans,dp);
        int c=0;
        if(n1[n]==m1[m]){
            dp[n][m]= 1+trace(n1,n-1,m1,m-1,ans,dp);
            ans[0]=Math.max(dp[n][m],ans[0]);
            return dp[n][m];
        }
       
        
        return dp[n][m]=0;
        
    }
}