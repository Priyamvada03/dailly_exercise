class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<List<String>>();
        List<String> temp=new ArrayList<String>();
        track(s,ans,temp);
        return ans;
    }
  public static boolean isPalindrome(String str) {
    	int i = 0;
    	int j = str.length() - 1;
    	while(i < j) {
    		if(str.charAt(i++) != str.charAt(j--))
    			return false;
    	}
    	return true;
    }
    public static void track(String s,List<List<String>> ans, List<String> temp){
        if(s.length()==0){
            ans.add(new ArrayList<>(temp));
           return;
        }
        for(int k=0;k<s.length();k++){
            String st=s.substring(0,k+1);
            if(isPalindrome(st)){
                temp.add(st);
                track(s.substring(k+1),ans,temp);
                 temp.remove(temp.size() - 1);
            }
        }
    }
}