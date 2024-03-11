//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            
            int mat1[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat1[i][j] = Integer.parseInt(input[j]);
                }
            }
            
            int mat2[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat2[i][j] = Integer.parseInt(input[j]);
                }
            }
            
        
            
            Solution ob = new Solution();
            System.out.println(ob.countPairs(mat1,mat2,n,x));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    static int binarySearch(int mat1[][], int targetValue,int n)
    {
        int start=0;
        int end=n-1;
        while(start<n && end>=0)
        {
            if(mat1[start][end]==targetValue)
                return 1;
            else if(mat1[start][end]<targetValue)
                start++;
            else
                end--;
        }
        return 0;
        
    }
    
    int countPairs(int mat1[][], int mat2[][], int n, int x) 
    {
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int targetValue=x-mat2[i][j];
                if(binarySearch(mat1,targetValue,n)==1)
                    count++;
            }
        }
        return count;
    }
}
