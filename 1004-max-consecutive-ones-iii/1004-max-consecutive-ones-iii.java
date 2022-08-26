class Solution {
    public int longestOnes(int[] nums, int k) {
        int fans=0;
        int j=0;
        int c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                c++;
            }
            while(c>k){
                if(nums[j]==0){
                    c--;
                }
                j++;
            }
            int ans=i-j+1;
            fans=Math.max(fans,ans);
        }
        return fans;
    }
}