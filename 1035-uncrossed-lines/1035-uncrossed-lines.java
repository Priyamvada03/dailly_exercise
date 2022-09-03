class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
       return traverse(nums1,nums2,n-1,m-1,dp);
    }
    public static int traverse(int[] n1,int[] n2,int n,int m,int[][] dp){
        if(n<0 || m<0){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(n1[n]==n2[m]){
        return dp[n][m]= traverse(n1,n2,n-1,m-1,dp)+1;
        }
        return dp[n][m]=Math.max(traverse(n1,n2,n-1,m,dp),traverse(n1,n2,n,m-1,dp));
    }
}