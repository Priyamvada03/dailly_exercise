class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<s.length();i++) {
            if(Character.isAlphabetic(s.charAt(i))){
                continue;}
            if(s.charAt(i)=='('){
                st.push(i);
            }
             
            else{
                if(st.size()>0 && s.charAt(st.peek())=='('){
                     st.pop();
                }
                else{
                st.push(i);
            }
                
            }
        }
        StringBuilder result = new StringBuilder();
        HashSet<Integer> set = new HashSet<>(st);
        for(int i=0;i<s.length();i++){
            if(!set.contains(i)){
               result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}