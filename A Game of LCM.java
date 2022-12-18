//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.maxGcd(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long maxGcd(int N) {
        // code here
        return Math.max(help(N),help(N-1));
    }
    long help(int n)
    {
        long ans=n;
        int c=0;
        
        for(int i=n-1;i>=1;i--)
        {
            if(gcd(ans,i)==1L){
                ans*=i;
                c++;
            }
            if(c==3)
            return ans;
        }
        return ans;
    }
    
    long gcd(long a,long b)
    {
        if(a==0)
        return b;
        return gcd(b%a,a);
    }
}
