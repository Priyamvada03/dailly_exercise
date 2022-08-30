class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int r = findMin(dungeon, 0, 0, new Integer[dungeon.length][dungeon[0].length]);
        return r <= 0 ? -r+1 : 1;
    }
    
    int findMin(int[][] dn, int i, int j, Integer[][] memo){
        if(i == dn.length-1 && j == dn[0].length-1) return dn[i][j];
        if(i>=dn.length || j>=dn[0].length) return Integer.MIN_VALUE;
        
        if(memo[i][j] != null) return memo[i][j];
        
        int r1 = findMin(dn, i, j+1, memo);
        int r2 = findMin(dn, i+1, j, memo);
        int r = Math.max(r1, r2);
        r = Math.min(dn[i][j], r+dn[i][j]);
        memo[i][j] = r;
        return memo[i][j];
    }
}