class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int n=stones.length;
        int i=0;
        while(i<n){
            pq.add(stones[i]);
            i++;
        }
        while(pq.size()!=1){
            int x=pq.poll();
            int y=pq.poll();
            int z=Math.abs(x-y);
            pq.add(z);
        }
        return pq.poll();
    }
}