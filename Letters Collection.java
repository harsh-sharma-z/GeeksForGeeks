//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            int mat[][] = new int[n][m];
            for(int i = 0;i < n;i++){
                String a[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < m;j++)
                    mat[i][j] = Integer.parseInt(a[j]);
            }
            int q = Integer.parseInt(in.readLine());
            int queries[][] = new int[q][3];
            for(int i = 0;i < q;i++){
                String a1[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < 3;j++)
                    queries[i][j] = Integer.parseInt(a1[j]);
            }
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.matrixSum(n, m, mat, q, queries);
            for(int i = 0;i < q;i++)
                System.out.println(ans.get(i));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
      static List<Integer> matrixSum(int n, int m, int mat[][], int q, int queries[][])
    {
        // code here
        List<Integer> list = new ArrayList(q);
        for(int i=0; i < q; ++i) {
            list.add(answerQ(n, m, mat, queries[i][0], queries[i][1], queries[i][2]));
        }
        return list;        
    }
    
    static int answerQ(int n, int m, int[][] mat, int hop, int i, int j) {        
        int sum = 0;
        if(i-hop >= 0) sum += mat[i-hop][j];
        if(i+hop < n)  sum += mat[i+hop][j];
        if(j-hop >= 0) sum += mat[i][j-hop];
        if(j+hop < m)  sum += mat[i][j+hop];
        for(int x=1; x <= hop; ++x) {
            if(i-hop >= 0) {
                if(j-x >= 0) sum+=mat[i-hop][j-x];
                if(j+x < m)  sum+=mat[i-hop][j+x];
            }
            if(i+hop < n) {
                if(j-x >= 0) sum+=mat[i+hop][j-x];
                if(j+x < m)  sum+=mat[i+hop][j+x];
            }
            if(j-hop >= 0) {
                if(i-x >= 0 && i-x != i-hop) sum+=mat[i-x][j-hop];
                if(i+x < n && i+x != i+hop) sum+=mat[i+x][j-hop];
            }
            if(j+hop < m) {
                if(i-x >= 0 && i-x != i-hop) sum+=mat[i-x][j+hop];
                if(i+x < n && i+x != i+hop) sum+=mat[i+x][j+hop];
            }
        }
        return sum;        
    }
}
