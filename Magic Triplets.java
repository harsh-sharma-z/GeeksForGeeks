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
            String[] S = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int ans = ob.countTriplets(nums);
            System.out.println(ans);         
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public int countTriplets(int[] nums){
        // code here
        int ans=0;
        int n=nums.length;
        for(int j=1;j<n-1;j++){
            int smaller=0;
            for(int i=j-1;i>=0;i--){
                if(nums[i]<nums[j])smaller++;
            }
            int larger=0;
            for(int k=j+1;k<n;k++){
                if(nums[k]>nums[j])larger++;
            }
            ans+=smaller*larger;
        }
        return ans;
    }
}
