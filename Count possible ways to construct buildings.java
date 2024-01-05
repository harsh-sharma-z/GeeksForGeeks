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
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalWays(int N)
    {
        // Code here
        if (N == 1)
            return 4;  
        int countB=1, countS=1, prev_countB, prev_countS;
        for (int i=2; i<=N; i++)
        {
            prev_countB = countB;
            prev_countS = countS;
      
            countS = prev_countB + prev_countS;
            countB = prev_countS;
        }
        int result = countS + countB;
        return (result*result);
    }
}
