class Solution {
    public boolean checkValidString(String s) {
        
         Stack<Integer> leftID = new Stack<>();
        Stack<Integer> starID = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') leftID.push(i);
            else if (s.charAt(i) == '*')
                starID.push(i);
            else{
                if (leftID.isEmpty() && starID.isEmpty())   return false;
                if (!leftID.isEmpty())
                    leftID.pop();
                else 
                    starID.pop();
            }
        }
        
        while( !leftID.isEmpty() && !starID.isEmpty()) {
            if(leftID.peek()>starID.peek()){
                return false;
            }leftID.pop();
            starID.pop();
        }
       return leftID.isEmpty();
    }
}