class Solution {
    public int minCut(String s) {
    Integer[][] dp = new Integer[s.length()][s.length()];
    return solve(s, 0, s.length()-1,dp);
}
boolean isPalindrome(String str, int start, int end){
    while(start<end){
        if(str.charAt(start)!=str.charAt(end)){
            return false;
        }
        start++;
        end--;
    }
    return true;
}
    int solve(String str, int i, int j,Integer[][] dp){
      if(i>=j){
        return 0;
    }
    if(dp[i][j]!=null){
        return dp[i][j];
    }
        if(isPalindrome(str, i, j)){
        dp[i][j]=0;
        return 0;
    }
          int min = Integer.MAX_VALUE;
        for(int k = i; k<=j;k++){
            
            if(isPalindrome(str, i, k)){
                int partitions = 1+solve(str, k+1, j,dp);
                  min = Math.min(min, partitions);           
            }
        }
         dp[i][j]=min;
    return dp[i][j];
        
    }
    
}