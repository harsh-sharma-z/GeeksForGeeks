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
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
         int n=nums.length;
        int[]inc=new int[n];
        for(int i=0;i<n;i++){
            inc[i]=1;
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i] && inc[j]+1>inc[i]){
                    inc[i]=inc[j]+1;
                }
            }
        }
        int[]dec=new int[n];
        for(int i=n-1;i>=0;i--){
            dec[i]=1;
            for(int j=i+1;j<n;j++){
                if(nums[j]<nums[i] && dec[j]+1>dec[i]){
                    dec[i]=dec[j]+1;
                }
            }
        }

        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,inc[i]+dec[i]-1);
        }
        return ans;
    }
}
