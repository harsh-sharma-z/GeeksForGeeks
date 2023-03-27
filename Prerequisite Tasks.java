//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int N, int[][] pre)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<N;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        
        for(int a[]:pre)
        {
            adj.get(a[0]).add(a[1]);
        }
        
        
        int in[]=new int[N];
        
        for(int i=0;i<N;i++)
        {
            for(int j:adj.get(i))
            in[j]++;
        }
        
        Queue<Integer> uwu=new LinkedList<>();
        for(int i=0;i<N;i++)
        {
            if(in[i]==0)
            uwu.add(i);
        }
        
        int c=0;
        while(!uwu.isEmpty())
        {
            int node=uwu.poll();
            c++;
            for(int i:adj.get(node))
            {
                in[i]--;
                if(in[i]==0)
                uwu.add(i);
            }
        }
        
        return c==N;
    }
    
}
