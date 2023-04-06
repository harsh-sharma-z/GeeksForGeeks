//{ Driver Code Starts
//Initial Template for Java

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
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int closedIslands(int[][] grid, int m, int n)
    {
        // Code here
        int c=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    if(dfs(grid,i,j,m,n))
                        c++;
                }
            }
        }
        return c;
    }
    private boolean dfs(int[][] grid, int i, int j, int m, int n)
    {
        if(i>=m || i<0 || j>=n || j<0) 
        return false;
        if(grid[i][j]==0) 
        return true;
        grid[i][j]=0;
        boolean up=dfs(grid,i-1,j,m,n);
        boolean down=dfs(grid,i+1,j,m,n);
        boolean left=dfs(grid,i,j-1,m,n);
        boolean right=dfs(grid,i,j+1,m,n);
        return up && left  && right && down;
    }
}
