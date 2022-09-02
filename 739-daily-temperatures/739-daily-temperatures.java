class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
      Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            
             while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                 int popped = stack.pop();
                  result[popped] = i-popped;
        }
            stack.push(i);
    }
        return result;}
}