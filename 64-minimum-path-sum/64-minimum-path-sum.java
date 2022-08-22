class Solution {
    public int minPathSum(int[][] grid) {
        Integer [][] memo=new Integer[grid.length][grid[0].length];
      return  findpath(grid,memo,0,0,grid.length,grid[0].length);
    }
    public static int findpath(int[][] grid,Integer[][] memo,int i,int j,int n,int m){
        if(i==n-1 && j==m-1){
            return grid[i][j];
        }
        if(i==n || j==m){
           return Integer.MAX_VALUE;
        }
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        int x=findpath(grid,memo,i+1,j,n,m);
        int y=findpath(grid,memo,i,j+1,n,m);
        return memo[i][j]=grid[i][j]+Math.min(x,y);
    }
}