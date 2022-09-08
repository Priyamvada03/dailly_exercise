class Solution {
    public int maxProfit(int[] prices) {
     int n=prices.length;
        int[] left=new int[n];
        int ans=0;
        int[] right=new int[n];
        int mini=prices[0];
        for(int i=1;i<n;i++){
            left[i]=Math.max(left[i-1],prices[i]-mini);
            mini=Math.min(mini,prices[i]);
        }
        int maxi=prices[n-1];
        for(int i=n-2;i>=0;i--){
            right[i]=Math.max(right[i+1],maxi-prices[i]);
            maxi=Math.max(maxi,prices[i]);
            ans=Math.max(left[i]+right[i],ans);
        }
        return ans;
    }
}