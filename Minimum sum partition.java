//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    Map<String,Integer> map=new HashMap<>();
	    return dfs(arr,n-1,0,0,map);
	} 
	public int dfs(int[]arr,int n,int s1,int s2,Map<String,Integer> map){
	    if(n<0){
	        return Math.abs(s1-s2);
	    }
	    String key=n+","+s1;
	    if(!map.containsKey(key)){
	        int first=dfs(arr,n-1,s1+arr[n],s2,map);
	        int sec=dfs(arr,n-1,s1,s2+arr[n],map);
	        map.put(key,Math.min(first,sec));
	    }
	    return map.get(key);
	}
}
