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
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            System.out.println(obj.maxSumWithK(a, n, k));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public long maxSumWithK(long arr[], long n, long k)
    {
        long ans = Long.MIN_VALUE;
        
        long [] maxSum = new long[arr.length];
        
        //kaden's
        long csum = arr[0];
        maxSum[0] = arr[0];
        
        for(int i=1; i<n; i++){
            if(csum>0){
                csum += arr[i];
            }
            else{
                csum  = arr[i];
            }
            
            maxSum[i] = csum;
        }
        
        long atLeastK = 0;
        
        for(int i=0; i<(int)k; i++){
            atLeastK += arr[i];   
        }
        
        ans = Math.max(atLeastK, ans);
        
        for(int i=(int)k; i<arr.length; i++){
            

            atLeastK = atLeastK + arr[i] - arr[i-(int)k];
            ans = Math.max(ans, atLeastK);
            
            long moreThanK = atLeastK + maxSum[i-(int)k];
            ans = Math.max(ans, moreThanK);
        }
        
        return ans;
    }
}
