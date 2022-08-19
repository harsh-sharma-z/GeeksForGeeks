//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    public int findMaxArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(grid[i][j] == 1){
                    int[] count = {0};
                    dfs(grid, i, j, count);
                    ans = Math.max(ans, count[0]);
                }
            }
        }
        return ans;
    }
    private void dfs(int[][] grid, int x, int y, int[] count) {
        if(grid[x][y] == 0) return;
        int m = grid.length, n = grid[0].length;
        grid[x][y] = 0;
        count[0] += 1;
        for(int[] dir : dirs){
            int nx = x + dir[0];
            int ny = y + dir[1];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1){
                dfs(grid, nx, ny, count);
            }
        }
    }
}
