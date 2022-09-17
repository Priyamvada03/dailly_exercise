class Solution {
    public int minFlipsMonoIncr(String s) {
     int n=s.length();
        int ones=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                ones++;
            }
        }
        int ans=Math.min(ones,n-ones);
        int now=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                now++;
            }
            int curr=now+((n-i-1)-(ones-now));
            ans=Math.min(ans,curr);
        }
        return ans;
    }
}