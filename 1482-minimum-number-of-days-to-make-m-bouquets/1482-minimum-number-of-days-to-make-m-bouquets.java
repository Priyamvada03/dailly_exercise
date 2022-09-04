class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(k * m > bloomDay.length)
            return -1;
        int low = 1,high=0;
        int len = bloomDay.length;
        for(int i=0;i<len;i++)
            high = Math.max(high,bloomDay[i]);
        while(low <= high)
        {
            int mid = (low+high)/2;
            if(isPossible(bloomDay,m,k,mid))   
                high = mid-1;
            else    low = mid+1;
        }
        return low;
    }
    boolean isPossible(int[] bloomDay,int m,int k,int mid)
    {
        int count = 0;
        int flowers = 0;
        int len = bloomDay.length;
        for(int i=0;i<len;i++)
        {
            if(bloomDay[i] <= mid)
                flowers++;
            else    flowers = 0;
            
            if(flowers == k)
            {
                count++;
                flowers=0;
            }
        }
        if(count < m)
            return false;
        else    return true;
    }
}