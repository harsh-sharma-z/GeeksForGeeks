//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans=new ArrayList<>();
        int[][] vis=new int[n][n];
        if(m[0][0]==1)
        help(0,0,ans,m,n,"",vis);
        if(ans.size()<=0)
        {
            ans.add("-1");
        }
        return ans;
    }
    public static void help(int i,int j,ArrayList<String> ans,int[][] m,int n,String ds,int[][] vis)
    {
        if(i==n-1 && j==n-1)
        {
            ans.add(ds);
            return;
        }
        if(i+1<n && vis[i+1][j]==0 && m[i+1][j]==1)
        {
            vis[i][j]=1;
            help(i+1,j,ans,m,n,ds+"D",vis);
            vis[i][j]=0;
        }
        if(i-1>=0 && vis[i-1][j]==0 && m[i-1][j]==1)
        {
            vis[i][j]=1;
            help(i-1,j,ans,m,n,ds+"U",vis);
            vis[i][j]=0;
        }
        if(j-1>=0 && vis[i][j-1]==0 && m[i][j-1]==1)
        {
            vis[i][j]=1;
            help(i,j-1,ans,m,n,ds+"L",vis);
            vis[i][j]=0;
        }
        if(j+1<n && vis[i][j+1]==0 && m[i][j+1]==1)
        {
            vis[i][j]=1;
            help(i,j+1,ans,m,n,ds+"R",vis);
            vis[i][j]=0;
        }
    }
}
