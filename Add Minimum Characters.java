//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
	public static int addMinChar(String str){
		//code here
		int l=0, r=str.length()-1, cut=r;
		int ans=0;
		while(l<r)
		{
		    if(str.charAt(l)==str.charAt(r))
		    {
		        l++;
		        r--;
		    }
		    else
		    {
		        ans++;
		        l=0;
		        r=--cut;
		    }
		}
		return ans;
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String str = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.addMinChar(str));
        }
        
    }
}

// } Driver Code Ends
