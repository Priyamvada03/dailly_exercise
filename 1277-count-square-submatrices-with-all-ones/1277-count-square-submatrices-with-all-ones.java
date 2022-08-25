class Solution {
    public int countSquares(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        int res=0;
        int[][] dp = new int[R][C];
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                 dp[i][j] = matrix[i][j];
                 if(i>0 && j>0 && matrix[i][j]==1){
                     dp[i][j]=Math.min(dp[i - 1][j - 1],Math.min(dp[i - 1][j], dp[i][j - 1]))+1;
                 }
            
            res+=dp[i][j];
            
            }
            }
        return res;
    }
}