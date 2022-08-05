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
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            Solution obj = new Solution();
            int ans = obj.xShape(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the number of 'X' total shapes.
    public int xShape(char[][] grid)
    {
        // code here
        int m = grid.length;
        int n = grid[0].length;
        
        int res = 0;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 'X'){
                    solve(i, j, m, n, grid);
                    res++;
                }
            }
        }
        return res;
    }
    
    public void solve(int i, int j, int m, int n, char[][] grid){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]=='O')
            return;
        
        grid[i][j] = 'O';
        
        solve(i+1, j, m, n, grid);
        solve(i-1, j, m, n, grid);
        solve(i, j+1, m, n, grid);
        solve(i, j-1, m, n, grid);
    }
    }
}
