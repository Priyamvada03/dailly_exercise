






class Solution {
    public int largestRectangleArea(int[] a) {
        int n = a.length;
        int[] r = new int[n];
    int[] l = new int[n];
    r = right(a,r);
    l=left(a,l);
    int max =0;
    for(int i=0;i<n;i++){
        max = (int)Math.max(max,(r[i]-l[i]+1)*a[i]);
    }
        return max;
  }
  static int[] right(int[] a,int[] r) {
    Stack<Integer> st = new Stack<>();
    int n = a.length;
    r[n-1]=n-1;
    st.push(n-1);
    int i=n-2;
      while(i>=0){
        while(st.size()>0 && a[st.peek()]>=a[i]){
            st.pop();
        }
        if(st.size()==0){
            r[i]=n-1;
        }
        else
           r[i]=st.peek()-1;
        st.push(i);
          i--;
    }
    return r;
  }
  static int[] left(int[] a,int[] l) {
      Stack<Integer> st = new Stack<>();
      int n = a.length;
      l[0]=0;
      st.push(0);
      for(int i=1;i<n;i++){
          while(!st.isEmpty() && a[st.peek()]>=a[i])
            st.pop();
          if(st.isEmpty())
             l[i]=0;
          else
             l[i]=st.peek()+1;
          st.push(i);
      }
      return l;
  }
}