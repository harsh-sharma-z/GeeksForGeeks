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
            int N = Integer.parseInt(in.readLine().trim());
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.pattern(N);
            for(int i = 0;i < ans.size();i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public List<Integer> pattern(int N){
        // code here
        List<Integer> res = new ArrayList<>();
        res.add(N);
        if(N <= 0)
            return res;
        
        help(res , N - 5);
        res.add(N);
        return res;
    }
    private void help(List<Integer> res , int n){
        if(n <= 0){
            res.add(n);
            return;
        }
        res.add(n);
        help(res , n - 5);
        res.add(n);
    }
}
