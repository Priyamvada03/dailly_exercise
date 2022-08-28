class Solution {
    public String stoneGameIII(int[] stoneValue) {
      int[]  dp = new int[stoneValue.length];
        Arrays.fill(dp,-1);
        int alice = stoneGameIII(stoneValue,0,dp);
        if(alice>0){
            return "Alice";
        }
        if(alice<0){
            return "Bob";
        }
        return "Tie";
    }
    private int stoneGameIII(int[] stoneValue, int start,int[] dp){
        
        if(start >= stoneValue.length){
            return 0;
        }
        if(dp[start]!=-1){
            return dp[start];
        }
        int ans = Integer.MIN_VALUE;
        ans = Math.max(ans, stoneValue[start] - stoneGameIII(stoneValue, start + 1,dp));
        if(start + 1 < stoneValue.length){
            ans = Math.max(ans, stoneValue[start] + stoneValue[start + 1] - stoneGameIII(stoneValue, start  + 2,dp));
        }
        if(start + 2 < stoneValue.length){
            ans = Math.max(ans, stoneValue[start] + stoneValue[start + 1] + stoneValue[start + 2] - stoneGameIII(stoneValue, start + 3,dp));
        }
        return dp[start]= ans;
    }
}