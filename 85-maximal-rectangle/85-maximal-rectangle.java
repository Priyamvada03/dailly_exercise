class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int ans=0;
         int[] dp=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0){
                    dp[j]=matrix[i][j]-'0';
                }
                else if(matrix[i][j]=='1'){
                    dp[j]=dp[j]+1;
                }
                else{
                    dp[j]=0;
                }
            }
         
            int temp=findMaxAreaInHistogram(dp);
            ans=Math.max(temp,ans);
        }
        return ans;
    }
  public int findMaxAreaInHistogram(int[] dp){
        int len = dp.length;
        int maxArea = 0;
        int[] left = new int[len];
        int[] right = new int[len];
        Stack<Integer> stack = new Stack<>();
        //traversing left to right, finding left limit
        for(int i=0;i<len;i++){
            if(stack.isEmpty()){
                stack.push(i);
                left[i] = 0;
            }else{
                while(!stack.isEmpty() && dp[stack.peek()] >= dp[i])
                    stack.pop();
                left[i] = stack.isEmpty() ? 0 : stack.peek()+1;
                stack.push(i);
            }
        }
        while(!stack.isEmpty())
            stack.pop();
        for(int i=len-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(len-1);
                right[i] = len - 1;
            }else{
                while(!stack.isEmpty() && dp[stack.peek()] >= dp[i])
                    stack.pop();
                right[i] = stack.isEmpty() ? len-1 : stack.peek()-1;
                stack.push(i);
            }
        }
        int[] area = new int[len];
        for(int i=0;i<len;i++){
            area[i] = (right[i] - left[i] + 1) * dp[i];
            maxArea = Math.max(maxArea, area[i]);
        }
        return maxArea;
    }
}