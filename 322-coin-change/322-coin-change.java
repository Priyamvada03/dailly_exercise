class Solution {
    public int coinChange(int[] coins, int amount) {
	int n = coins.length;
	int[][] dp = new int[n][amount+1];
	for(int[] ar: dp)
		Arrays.fill(ar, -1);
	int ans = f(n-1, amount, coins, dp);
	if(ans >= (int)1e7) return -1;
	return ans;
}
    public int f(int i, int target, int[] coins, int[][] dp) {
        
        if(i< 0) {
		// if(target % coins[i] == 0)
		// 	return target / coins[i];
		return (int)1e7;
	}
        if(target==0){
            return 0;
        }
        if(dp[i][target] != -1)
		return dp[i][target];
        int notpick = f(i-1, target, coins, dp);
	     int pick = Integer.MAX_VALUE;
	if(coins[i] <= target) 
		pick = 1 + f(i, target-coins[i], coins, dp);

	return dp[i][target] = Math.min(notpick, pick);
    }
}