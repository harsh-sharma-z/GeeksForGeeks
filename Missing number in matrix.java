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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            long ans = ob.MissingNo(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
   public long  MissingNo(int[][] mat)
    {
        // code here
        int n=mat.length;
        int x=-1;
        int y=-1;
        long rowSum[]=new long[n];
        long colSum[]=new long[n];
        long leftDia=0;
        long rightDia=0;

        for(int i=0;i<n;i++){
            leftDia+=mat[i][i];
            rightDia+=mat[i][n-i-1];
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    x=i;
                    y=j;
                }
                rowSum[i]+=mat[i][j];
                colSum[j]+=mat[i][j];
            }
        }

        long rowSumOriginal = x==0? rowSum[x+1] : rowSum[x-1];
        long colSumOriginal = y==0? colSum[y+1] : colSum[y-1];
        long diff = colSumOriginal - colSum[y];
        if(diff<=0 || diff!=rowSumOriginal-rowSum[x]){
            return -1;
        }

        if(x==y){
            leftDia+=diff;
        }

        if(x==n-y-1){
            rightDia+=diff;
        }

        if(leftDia!=rightDia)return -1;
        rowSum[x]+=diff;
        colSum[y]+=diff;
        for(int i=0;i<n;i++){
            if(rowSum[i]!=leftDia || colSum[i]!=rightDia){
                return -1;
            }
        }
        return diff;

    }
}
