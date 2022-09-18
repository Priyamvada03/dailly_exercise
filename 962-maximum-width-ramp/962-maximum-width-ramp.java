class Solution {
    public int maxWidthRamp(int[] nums) {
        int n=nums.length-1;
        Stack<Integer> st=new Stack<>();
        for(int i=n;i>=0;i--){
            if(st.size()==0){st.push(i);}
           else if(nums[st.peek()]<nums[i]){
                st.push(i);
            }
        }
        int ans=0;
        for(int i=0;i<=n;i++){
            while(st.size()>0 && nums[i]<=nums[st.peek()]){
                ans=Math.max(ans,st.pop()-i);
            }
        }
        return ans;
    }
}