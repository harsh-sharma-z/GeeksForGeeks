//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int x;
    int y;
    public Pair(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
}
// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        Queue<Pair> uwu=new LinkedList<>();
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0 || i==n-1 || j==0 || j==m-1)
                {
                    if(grid[i][j]==1)
                    {
                        uwu.add(new Pair(i,j));
                        vis[i][j]=1;
                    }
                }
            }
        }
        
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        
        
        while(!uwu.isEmpty())
        {
            
            int row=uwu.peek().x;
            int col=uwu.peek().y;
            uwu.remove();
            
            for(int i=0;i<4;i++)
            {
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1)
                {
                    uwu.add(new Pair(nrow,ncol));
                    vis[nrow][ncol]=1;
                }
            }
        }
        
        int ans=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && grid[i][j]==1)
                ans++;
            }
        }
        return ans;
    }
}
