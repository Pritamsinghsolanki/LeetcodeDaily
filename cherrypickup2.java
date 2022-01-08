class Solution {
    //static int ans;
    public int cherryPickup(int[][] grid) {
//         int[][] visited=new int[grid.length][grid[0].length];
//         visited[0][0]=1;
//         visited[0][grid[0].length-1]=2;
//         ans=0;
//         solve(grid,0,0,visited,0,grid[0].length-1,grid[0][0],grid[0][grid[0].length-1]);
//         return ans;
//     }
    
//     private void solve(int[][] grid,int row1,int col1,int[][] visited,int row2,int col2,int ans1,int ans2){
//         if(row1==grid.length-1 && row1==row2){
//            // ans1-=grid[row1][col1];
//            // ans2-=grid[row1][col2];
//             ans=Math.max(ans,ans1+ans2);
//            System.out.println("Robot1("+ row1+" , "+col1+") ,Robot2 ("+row2+" , "+col2+") % "+ "final ans->"+ans);
//             return;
//         }
//         // System.out.println("Robot1("+row1+" , "+col1+"),Robot2("+row2+" , "+col2+") ,Rbor1ans-> ("+ans1+"  ),Robor2ans-->2 (" +ans2+") final,--> "+ans)
//         if(isvalid(visited,row1+1,col1,2)){
//             visited[row1+1][col1]=1;
//             solve(grid,row1+1,col1,visited,row2,col2,ans1+grid[row1+1][col1],ans2);
//             visited[row1+1][col1]=0;
//         }
//         if(isvalid(visited,row1+1,col1+1,2)){
//             visited[row1+1][col1+1]=1;
//             solve(grid,row1+1,col1+1,visited,row2,col2,ans1+grid[row1+1][col1+1],ans2);
//             visited[row1+1][col1+1]=0;
//         }
//         if(isvalid(visited,row1+1,col1-1,2)){
//             visited[row1+1][col1-1]=1;
//             solve(grid,row1+1,col1-1,visited,row2,col2,ans1+grid[row1+1][col1-1],ans2);
//             visited[row1+1][col1-1]=0;
//         }
        
        
//         if(isvalid(visited,row2+1,col2,1)){
//             visited[row2+1][col2]=2;
//             solve(grid,row1,col1,visited,row2+1,col2,ans1,grid[row2+1][col2]+ans2);
//             visited[row2+1][col2]=0;
//         }
//         if(isvalid(visited,row2+1,col2+1,1)){
//             visited[row2+1][col2+1]=2;
//             solve(grid,row1,col1,visited,row2+1,col2+1,ans1,grid[row2+1][col2+1]+ans2);
//             visited[row2+1][col2+1]=0;
//         }
//         if(isvalid(visited,row2+1,col2-1,1)){
//             visited[row2+1][col2-1]=1;
//             solve(grid,row1,col1,visited,row2+1,col2-1,ans1,grid[row2+1][col2-1]+ans2);
//             visited[row2+1][col2-1]=0;
//         }
//         return ;
//     }
//            private static boolean isvalid(int[][] visited,int row,int col,int flag){
//                int n=visited.length;
//                int m=visited[0].length;
//                if(row>=0 && row<n && col>=0 && col<m && visited[row][col]!=flag) return true;
//                return false;
//            }
     
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dpCache = new int[m][n][n];
        // initial all elements to -1 to mark unseen
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dpCache[i][j][k] = -1;
                }
            }
        }
        return dp(0, 0, n - 1, grid, dpCache);
    }

    private int dp(int row, int col1, int col2, int[][] grid, int[][][] dpCache) {
        if (col1 < 0 || col1 >= grid[0].length || col2 < 0 || col2 >= grid[0].length) {
            return 0;
        }
        // check cache
        if (dpCache[row][col1][col2] != -1) {
            return dpCache[row][col1][col2];
        }
        // current cell
        int result = 0;
        result += grid[row][col1];
        if (col1 != col2) {
            result += grid[row][col2];
        }
        // transition
        if (row != grid.length - 1) {
            int max = 0;
            for (int newCol1 = col1 - 1; newCol1 <= col1 + 1; newCol1++) {
                for (int newCol2 = col2 - 1; newCol2 <= col2 + 1; newCol2++) {
                    max = Math.max(max, dp(row + 1, newCol1, newCol2, grid, dpCache));
                }
            }
            result += max;
        }

        dpCache[row][col1][col2] = result;
        return result;
    }
    
    //second soln
        int m = grid.length;
        int n = grid[0].length;
        int dp[][][] = new int[m][n][n];

        for (int row = m - 1; row >= 0; row--) {
            for (int col1 = 0; col1 < n; col1++) {
                for (int col2 = 0; col2 < n; col2++) {
                    int result = 0;
                    // current cell
                    result += grid[row][col1];
                    if (col1 != col2) {
                        result += grid[row][col2];
                    }
                    // transition
                    if (row != m - 1) {
                        int max = 0;
                        for (int newCol1 = col1 - 1; newCol1 <= col1 + 1; newCol1++) {
                            for (int newCol2 = col2 - 1; newCol2 <= col2 + 1; newCol2++) {
                                if (newCol1 >= 0 && newCol1 < n && newCol2 >= 0 && newCol2 < n) {
                                    max = Math.max(max, dp[row + 1][newCol1][newCol2]);
                                }
                            }
                        }
                        result += max;
                    }
                    dp[row][col1][col2] = result;
                }
            }
        }
        return dp[0][0][n - 1];
    }
}
              