class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return m+n-(2*find(word1,word2,dp,n,m,0,0));
    }
    public static int find(String w1,String w2,int[][]dp,int n,int m,int i,int j){
        if(i==n || j==m){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(w1.charAt(i)==w2.charAt(j)){
            return dp[i][j]=1+find(w1,w2,dp,n,m,i+1,j+1);
        }
        else{
            return dp[i][j]=Math.max(find(w1,w2,dp,n,m,i+1,j),find(w1,w2,dp,n,m,i,j+1));
        }
        
    }
}