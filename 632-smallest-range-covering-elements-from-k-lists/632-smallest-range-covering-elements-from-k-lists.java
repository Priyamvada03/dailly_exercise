class Solution {
    class pair{
        public int l, r;
        public pair(int l, int r){
            this.l = l;
            this.r = r;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int n=0, m = nums.size();;
    for(int i=0;i<nums.size();i++){
        n+=nums.get(i).size();
    }
        pair[] ii = new pair[n];
       int last = 0;
        for(int i=0;i<nums.size();i++){
            for(int j=0;j<nums.get(i).size();j++){
                ii[last++]=new pair(nums.get(i).get(j),i);
            }
        }
       Arrays.sort(ii,(a,b)->a.l-b.l);
            
       int lb = 0, rb = 0, k = 0, ansl = 0, ansr = 1000000000;
        int[] freq = new int[m];
        for (; rb<n; ++rb){
            
            if(freq[ii[rb].r]==0)++k;
            freq[ii[rb].r]+=1;
            while (freq[ii[lb].r]>1) --freq[ii[lb++].r];
            if(k==m){
                if(ii[rb].l-ii[lb].l<ansr-ansl){
                    ansr=ii[rb].l;
                    ansl=ii[lb].l;
                }
            }
        }
        return new int[]{ansl,ansr};
    }
}

