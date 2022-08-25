class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solution(nums,k)-solution(nums,k-1);
    }
    public int solution(int[] arr,int k){
        int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int j=0;
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            while(map.size()>k){
                if(map.get(arr[j])>1){
                    map.put(arr[j], map.get(arr[j]) - 1);
                }
                else{
                    map.remove(arr[j]);
                }
                j++;
            }
            ans+=(i-j)+1;
            
        }
        return ans;
    }
}