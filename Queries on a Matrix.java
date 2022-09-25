//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int q = Integer.parseInt(s[1]);
            int[][] Queries = new int[q][4];
            for (int i = 0; i < q; i++) {
                String[] s1 = br.readLine().trim().split(" ");
                for (int j = 0; j < 4; j++)
                    Queries[i][j] = Integer.parseInt(s1[j]);
            }
            Solution obj = new Solution();
            int[][] ans = obj.solveQueries(n, Queries);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++) {
                    out.print(ans[i][j] + " ");
                }
                out.println();
            }
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[][] solveQueries(int n, int[][] q) {
        // Code here
        int[][] arr=new int[n][n];
        
        for(int i=0;i<q.length;i++){
            int a=q[i][0],b=q[i][1],c=q[i][2],d=q[i][3];
            for(int j=a;j<=c;j++){
                arr[j][b]+=1;
                if(d+1<n){
                    arr[j][d+1]-=1;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                arr[i][j]+=arr[i][j-1];
            }
        }
        return arr;
    }
}
