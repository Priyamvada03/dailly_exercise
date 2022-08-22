class FreqStack {
    HashMap<Integer,Integer> map;
    HashMap<Integer,Stack<Integer>> fmap;
     int freq;
    public FreqStack() {
        map=new HashMap<>();
        fmap=new HashMap<>();
       freq=0;
    }
    
    public void push(int val) {
        int g=map.getOrDefault(val,0);
        g++;
        map.put(val,g);
        if(!fmap.containsKey(g)){
            fmap.put(g,new Stack<Integer>());
        }
        fmap.get(g).push(val);
        freq=Math.max(freq,g);
    }
    
    public int pop() {
      int ans=fmap.get(freq).pop();
        int cfeq=map.get(ans);
        cfeq--;
        map.put(ans,cfeq);
        if(fmap.get(freq).size()==0){
            freq--;
        }
        return ans;
    }
}

// class FreqStack {
//     HashMap<Integer,Stack<Integer>>st;
//     HashMap<Integer,Integer>fmap;
//     int maxFreq;
//     public FreqStack() {
//         st=new HashMap<>();
//         fmap=new HashMap<>();
//         maxFreq=0;
//     }
    
//     public void push(int val) {
//         int cfreq=fmap.getOrDefault(val,0);
//         cfreq++;
//         fmap.put(val,cfreq);
//         if(!st.containsKey(cfreq)){
//             st.put(cfreq,new Stack<Integer>());
//         }
//         st.get(cfreq).push(val);
//         maxFreq=Math.max(maxFreq,cfreq);
//     }
    
//     public int pop() {
//         int ans=st.get(maxFreq).pop();
//         int cfreq=fmap.get(ans);
//         cfreq--;
//         fmap.put(ans,cfreq);
//         if(st.get(maxFreq).size()==0){
//             maxFreq--;
//         }
//         return ans;
//     }
// }