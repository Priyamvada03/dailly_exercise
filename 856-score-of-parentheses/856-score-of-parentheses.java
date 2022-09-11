class Solution {
    public static int scoreOfParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        int ans=0;
        for(int i=0;i<s.length();i++){
            Character c=s.charAt(i);
            if(c=='('){
                st.push(-1);
            }
            else {
                if(st.peek()==-1){
                    st.pop();
                    st.push(1);
                }
                else{
                    int count=0;
                    while(st.peek()!=-1){
                      count+=st.pop();  
                    }
                    st.pop();
                    st.push(2*count);
                }
            }
        }
        int temp=0;
            while(st.size()>0){
                temp+=st.pop();
            }
        return temp;
    }
}