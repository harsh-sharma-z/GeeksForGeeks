//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String s = sc.next();
            int k = sc.nextInt();
            int answer = new Solution().kSubstrConcat(n,s,k);
    		System.out.println(answer);
        }
        
    }
}

// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int kSubstrConcat(int n, String s, int k)
    {
        // Your Code Here   
        if(n%k!=0) return 0;
        String ss=s.substring(0,k);
        int cnt=n/k;
        int mod=0;
        for(int i=0,j=0;j<cnt;i=i+k,j++){
            if(!s.substring(i,i+k).equals(ss)){
                mod++;
            }
        }
        if(mod>1){
            mod=0;
            String sss=s.substring(n-k,n);
            for(int i=n-k,j=0;j<cnt;i=i-k,j++){
                if(!s.substring(i,i+k).equals(sss)){
                    mod++;
                    if(mod>1) return 0;
                }
            }
        }
        return 1;
    }
}
