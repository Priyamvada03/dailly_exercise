class Solution {
    public int find(int[] prices,int idx,int buy,int fee,int[][] dp){
        if(idx>=prices.length) return 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        int pick=0;
        if(buy==0){
            pick = Math.max(-prices[idx]+find(prices,idx+1,1,fee,dp),find(prices,idx+1,0,fee,dp));
        }else{
            pick = Math.max(prices[idx]-fee+find(prices,idx+1,0,fee,dp),find(prices,idx+1,1,fee,dp));
        }
        return dp[idx][buy]=pick;
    }
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for(int[] i:dp) Arrays.fill(i,-1);
        return find(prices,0,0,fee,dp);
    }
}