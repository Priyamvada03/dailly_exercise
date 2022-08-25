class Solution {
    public boolean searchMatrix(int[][] mat, int tar) {
        int m=mat.length-1;
        int n=mat[0].length-1;
        int i=0;
        int j=n;
        while(i<=m && j<=n && i>=0 && j>=0){
            if(mat[i][j]<tar){
                i++;
            }
            else if(mat[i][j]>tar){
                j--;
            }
           else if(mat[i][j]==tar){
                return true;
            }
        }
        return false;
    }
}