
class Solution {
    public int maxProfit(int[] prices) {
          int[][] dp = new int[prices.length][2];
        for(int[] i:dp) Arrays.fill(i,-1);
        return find(prices,dp,0,0);
    }
    public static int find(int[] prices,int[][]dp,int i,int buy){
        if(i>=prices.length){
            return 0;
        }
        if(dp[i][buy]!=-1){
            return dp[i][buy];
        }
        int pick=0;
        if(buy==0){
            pick=Math.max(-prices[i]+find(prices,dp,i+1,1),find(prices,dp,i+1,0));
                
        }
        else{
            pick=Math.max(prices[i]+find(prices,dp,i+2,0),find(prices,dp,i+1,1));
        }
        return dp[i][buy]=pick;
    }
}