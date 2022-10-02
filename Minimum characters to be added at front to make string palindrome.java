//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    public static int solve(String s, String r) {
        int i,j,n=s.length();
        if(n==0)return 0;
        int []lps=new int[n+1];
        for(i=0,j=0;i<n;){
            if(s.charAt(i)==r.charAt(j)){
                lps[++i]=++j;
            }
            else if(j>0){
                j=lps[j-1];
            }
            else {
                lps[++i]=0;
            }
        }
        return n-lps[n];
    }
    public static int minChar(String str) {
       //Write your code here
       return solve(new StringBuilder(str).reverse().toString(),str);
    }
}

//{ Driver Code Starts.

class GFG {
	public static void main(String[] args) throws IOException
	{
	    var sc = new FastReader();
	    int test = sc.nextInt();
	    while(test-->0){
    		String s = sc.nextString();
    		System.out.println(Solution.minChar(s));
	    }
	}
    
    public static class FastReader
	{
		BufferedReader br;
		StringTokenizer st;

		public FastReader()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		private void read() throws IOException
		{
			st = new StringTokenizer(br.readLine());
		}

		public String nextString() throws IOException
		{
			while(!st.hasMoreTokens())
				read();
			return st.nextToken();
		}

		public int nextInt() throws IOException
		{
			return Integer.parseInt(nextString());
		}

		public long nextLong() throws IOException
		{
			return Long.parseLong(nextString());
		}
	}
}
// } Driver Code Ends
