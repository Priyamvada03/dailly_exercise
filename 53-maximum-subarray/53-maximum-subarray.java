class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int sum=0;
        int ans= Integer.MIN_VALUE;
        int i=0;
        while(i<nums.length){
            sum+=nums[i];
             ans=Math.max(ans,sum);
            if(sum<0){
                sum=0;
                
            }
           
            i++;
        }
        return ans;
    }
}