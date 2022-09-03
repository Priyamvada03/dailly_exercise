class Solution {
   public int numberOfSubstrings(String s) {
        int l = 0;
        int r = 0;
        int count = 0;
       Map<Character, Integer> m = new HashMap<>();
        while(r<s.length()){   if(s.charAt(r) == 'a' || s.charAt(r) == 'b' ||s.charAt(r) == 'c'){
                int pos = m.getOrDefault(s.charAt(r), r);
                m.put(s.charAt(r), r);
            }if(m.size() == 3){
                count = count +1;
                int rest = s.length() -r -1;
                count = count + rest;
            }  while(m.size() == 3){
                if(m.containsKey(s.charAt(l)) && l == m.get(s.charAt(l))){
                    m.remove(s.charAt(l));
                    l++;
                }else{
                    count ++;
                    int rest = s.length() -r -1;
                    count = count + rest;
                    l++;
                }
            }
            r++;
        }
        return count;
    }
}