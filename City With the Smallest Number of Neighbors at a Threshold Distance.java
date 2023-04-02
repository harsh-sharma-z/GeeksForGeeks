//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] adj = new int[m][3];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < 3; j++) {
                    adj[i][j] = sc.nextInt();
                }
            }

            int dist = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.findCity(n, m, adj, dist);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
      int findCity(int n, int m, int[][] edges,int distanceThreshold)
      {
          //code here
          int[][] dist= new int[n][n];
          for(int[] i: dist)
          Arrays.fill(i,Integer.MAX_VALUE);
      
      
      for(int i[]:edges)
      {
          int u=i[0];
          int v=i[1];
          int d=i[2];
          dist[u][v]=d;
          dist[v][u]=d;;
      }
      
      for(int i=0;i<n;i++)
      dist[i][i]=0;
      
      for(int k=0;k<n;k++)
      {
          for(int i=0;i<n;i++)
          {
              for(int j=0;j<n;j++)
              {
                  if(dist[i][k]==Integer.MAX_VALUE || dist[k][j]==Integer.MAX_VALUE)
                      continue;
                  
                  dist[i][j]=Math.min(dist[i][j],(dist[i][k]+dist[k][j]));
              }
          }
      }
      
      int cntCity=n;
      int cityNo=-1;
      
      for(int city=0;city<n;city++)
      {
          int c=0;
          for(int adjcity =0;adjcity<n;adjcity++)
          {
            if(dist[city][adjcity]<=distanceThreshold)
            c++;
          }
          
          if(c<=cntCity)
          {
              cntCity=c;
              cityNo=city;
          }
      }
      
      return cityNo;
}
}
