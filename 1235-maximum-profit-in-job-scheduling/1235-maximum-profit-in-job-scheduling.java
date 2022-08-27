class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=endTime.length;
        int[][] array=new int[n][3];
        for(int i=0;i<n;i++){
            array[i][0]=startTime[i];
            array[i][1]=endTime[i];
            array[i][2]=profit[i];
        }
        Arrays.sort(array,(a,b)->{
            return a[0]-b[0];
        });
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
      return maxiProfit(array,0,0,n,dp);
    }
    public static int maxiProfit(int[][] array,int i,int e,int n,int[] dp){
        if(i==array.length){
            return 0;
        }
        else if(array[i][0]<e){
            return maxiProfit(array,i+1,e,n,dp);
        }
        else if(dp[i]!=-1){
            return dp[i];
        }
    
           int res= dp[i]=Math.max(array[i][2]+maxiProfit(array,i+1,array[i][1],n,dp),maxiProfit(array,i+1,e,n,dp));
        return dp[i]=res;
    }
}