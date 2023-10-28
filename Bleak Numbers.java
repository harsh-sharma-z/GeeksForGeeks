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
            Solution ob = new Solution();
            int ans = ob.is_bleak(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int is_bleak(int n)
    {
        // Code here
        for(int i = n - 30 ; i <= n ; i++){
            if(i + countSetBits(i) == n)
                return 0;
        }
        return 1;
    }
    private int countSetBits(int n){
        int c = 0;
        while(n > 0){
            c += (n & 1);
            n = n / 2;
        }
        return c;
    }
}
