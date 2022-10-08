class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                ans=Math.max(ans,findmax(i,j,grid));
            }
        }
        return ans;
    }
    public static int findmax(int i,int j,int[][] grid){
        if(i>=grid.length || j>=grid[0].length || i<0 || j<0 || grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;
        return 1+findmax(i,j+1,grid)+findmax(i+1,j,grid)+findmax(i-1,j,grid)+findmax(i,j-1,grid);
    }
}