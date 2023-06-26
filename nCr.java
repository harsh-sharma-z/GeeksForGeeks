//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static long mod = (long)1e9+7;

    static int nCr(int n, int r)
    {
        if(n == r || r == 0) return 1;
        if(r == 1) return n;
        if(r>n) return 0;
        if(r > n/2) r = n-r;
        
        return (int)solve(n, r);
    }
    static long solve(int n, int r)
    {
        if(n == r || r == 0) return 1;
        Queue<Long> q = new LinkedList<>();
        q.add(1l);
        q.add(2l);
        
        for(int i = 2;i<n;i++){
            int size = q.size();
            long prev = 0;
            while(size > 1){
                q.add((q.peek()+prev)%mod);
                prev = q.poll();
                size--;
            }
                long temp = (q.poll()+prev)%mod;
                q.add(temp);
                if(i%2 == 0) q.add(temp); 
             }
        while(r>0){
            r--;
            q.poll();
        }
        return q.peek();
        
    }
}
