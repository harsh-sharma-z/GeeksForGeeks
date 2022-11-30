//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.numoffbt(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public static int numoffbt(int arr[], int n)
    {
         // Your code goes here
         int mn = Integer.MAX_VALUE ;

         int mx = Integer.MIN_VALUE ;

         for(int i = 0 ;i<n;i++)

         {

             mx = Math.max(mx,arr[i]) ;

             mn = Math.min(mn,arr[i]);

         }

         int []mrk = new int[mx+1] ;

         int []val = new int[mx+1] ;

         for(int i = 0 ;i<n;i++)

         {

             mrk[arr[i]]=1 ;

             val[arr[i]]=1 ;

         }

         int res =0; int mod = 1000000007  ;

         for(int i = mn ;i<=mx;i++)

         {

             if(mrk[i]!=0)

             {

                 for(int j = i+i ;j<=mx&&j/i<=i ;j=j+i)

                 {

                     if(mrk[j]!=0){

                     if(i == j/i)

                     val[j]=(val[j]+(val[i]*val[j/i] )%mod)%mod;

                     if(i != j/i)

                     val[j]=(val[j]+2*(val[i]*val[j/i])%mod)%mod ;

                 }}

             }

             res=(res+val[i])%mod ;

         }

         return res;
    }
}
