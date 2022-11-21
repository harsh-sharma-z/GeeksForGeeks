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
            ArrayList<ArrayList<Integer>> ans = ob.UniquePartitions(n);
            for(ArrayList<Integer>i: ans)
                for(int j: i)
                    System.out.print(j + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public ArrayList<ArrayList<Integer>> UniquePartitions(int n)
    {
        // Code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> curr=new ArrayList<>();
        int idx=n-1;
        int []arr=new int[n ];
        for(int i=0;i<n;i++)
        {
            arr[i]=i+1;
            
        }
        dfs(ans,curr,idx,n,arr);
        return ans;
    }
    void dfs(ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> curr,int idx,int n,int[] arr)
    {
        if(idx<0||n<0)
        return ;
        curr.add(arr[idx]);
        if(n-arr[idx]==0)
        ans.add(new ArrayList<>(curr));
        
        dfs(ans,curr,idx,n-arr[idx],arr);
        curr.remove(curr.size()-1);
        dfs(ans,curr,idx-1,n,arr);
        
    }
}
