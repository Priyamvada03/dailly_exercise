class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        
        for(int i : nums) sum+=i;
        
        if(sum%2!=0) return false;
        
        sum /= 2;
        Boolean[][] mem = new Boolean[n+1][sum+1];
        
        return subsetSum(nums,0,sum,mem);
    }
    public static boolean subsetSum(int[] nums,int i,int sum,Boolean[][] mem){
        if(i==nums.length-1){
            if(sum == 0){
            return true;
        }
        else{
            return false;
        }
        }
        if( sum<0){
            return false;
        }
        if(mem[i][sum]!=null) return mem[i][sum];
        if(sum-nums[i]<0){
            return mem[i][sum]=subsetSum(nums,i+1,sum,mem);
        }
        else{
            return mem[i][sum]=subsetSum(nums,i+1,sum-nums[i],mem) || subsetSum(nums,i+1,sum,mem);
        }
        
    }
    
}