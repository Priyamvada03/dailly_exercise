class Solution {
    public int maxSizeSlices(int[] slices) {
        int k=slices.length/3;
        int[] a1=Arrays.copyOfRange(slices,1,slices.length);
        int[] a2=Arrays.copyOfRange(slices,0,slices.length-1);
        int[][] dp1=new int[501][170];
        int[][] dp2=new int[501][170];
        for(int i=0;i<501;i++){
            for(int j=0;j<170;j++){
            dp1[i][j]=-1;
            dp2[i][j]=-1;
            }
        }
      return Math.max(robbery(a1,dp1,0,k),robbery(a2,dp2,0,k));
    }
    public static int robbery(int[] a,int[][] dp,int i,int k){
        if(i>=a.length || k==0){
            return 0;
        }
        if(dp[i][k]!=-1){
            return dp[i][k];
        }
        return dp[i][k]= Math.max(robbery(a,dp,i+2,k-1)+a[i],robbery(a,dp,i+1,k));
    }
}