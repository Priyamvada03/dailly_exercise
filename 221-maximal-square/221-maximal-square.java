class Solution {
    public int maximalSquare(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int ans=0;
        int [][] mat=new int[n][m];
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j]=matrix[i][j]-'0';
                if(mat[i][j]==1){
                    ans=1;
                }
            }
            }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0){
                   
                dp[i][j]=mat[i][j];
            }
            else if(mat[i][j]==1){
                dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                ans=Math.max(dp[i][j],ans);
            }
                else{
                    dp[i][j]=0;
                }
            }
        }
        
        return ans*ans;
    }
}