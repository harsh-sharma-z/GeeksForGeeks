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
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.sequence(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long mod = (long) 1e9 + 7;
    static long sequence(int n){
        // code here
        return fun(n);
    }
    static long fun(int n){
        if(n == 1) return 1;
        return (fun(n - 1) + mul(n, (n * (n + 1)/2))) % mod;
    }
    static long mul(int n, int end){
        long ans = 1;
        for(; n > 0; end--, n--) ans = (ans * end)%mod;
        return ans;
    }
}
