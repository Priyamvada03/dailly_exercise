class Solution {
    public int[][] intervalIntersection(int[][] fl, int[][] sl) {
          if(fl.length==0 || sl.length==0) return new int[0][0];
        ArrayList<int[]> list=new ArrayList<>();
        int smaxi=0;
        int emini=0;
        int i=0;
        int j=0;
        while(i<fl.length && j<sl.length){
            smaxi=Math.max(fl[i][0],sl[j][0]);
            emini=Math.min(fl[i][1],sl[j][1]);
            if(smaxi<=emini){
                list.add(new int[]{smaxi,emini});
            }
            if(emini==fl[i][1]){
                i++;
            }
             if(emini==sl[j][1]){
                j++;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}