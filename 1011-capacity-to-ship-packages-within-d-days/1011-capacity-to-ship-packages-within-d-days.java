class Solution {
    public int shipWithinDays(int[] w, int d) {
        int maxi=w[0];
        int ans=0;
        for(int i=1;i<w.length;i++){
            maxi=Math.max(maxi,w[i]);
        }
        int sum=0;
         for(int i=0;i<w.length;i++){
            sum+=w[i];
        }
        while(maxi<=sum){
            int mid=maxi+(sum-maxi)/2;
            if(isvalid(w,d,mid)){
                ans=mid;
                sum=mid-1;
                
            }
            else{
                maxi=mid+1;
            }
        }
        return ans;
    }
    public static boolean isvalid(int[] w,int d,int mid){
        int num=1;
        int sum=0;
          for(int i=0;i<w.length;i++){
            sum+=w[i];
              if(sum>mid){
                  num++;
                  sum=w[i];
              }
              
        }
        return num<=d;
    }
}