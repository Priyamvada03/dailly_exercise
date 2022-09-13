class Solution {
    public int maxEnvelopes(int[][] env) {
        Arrays.sort(env,(a,b)->a[0]!=b[0]?a[0]-b[0]:b[1]-a[1]);
        int[] dp=new int[env.length];
        int len=0;
        for(int[] envelope : env){
          int idx=  Arrays.binarySearch(dp,0,len, envelope[1]);
            if(idx<0){
                idx=-idx-1;
            }
          dp[idx]=envelope[1];
          if(idx==len){
              len++;
          }
        }
        return len;
    }
}