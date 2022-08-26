class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Boolean[] arr=new Boolean[366];
        int[] memo=new int[366];
         for(int i=0;i<=365;i++){
            memo[i]=-1;
        }
        for(int i=0;i<=365;i++){
            arr[i]=false;
        }
        for(int i:days){
            arr[i]=true;
        }
        int x = calculate(days, costs, 0, arr,memo);
        return x;
    }
    public static int calculate(int[] days,int[] costs,int i,Boolean[] arr,int[] memo){
        if(i>365){
            return 0;
        }
        if(arr[i]==false){
            return calculate(days,costs,i+1,arr,memo);
        }
        if(memo[i]!=-1){
            return memo[i];
        }
        return memo[i]= Math.min(
            costs[0]+calculate(days,costs,i+1,arr,memo),
            Math.min(costs[1]+calculate(days,costs,i+7,arr,memo),
                costs[2]+calculate(days,costs,i+30,arr,memo)) );
    }
}