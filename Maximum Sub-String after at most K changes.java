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
            String s = br.readLine().trim();
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.characterReplacement(s, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int characterReplacement(String s, int k)
    {
        // code here
        int[] arr=new int[26];
        int prev=0;
        int uwu=0;
        for(int i=0;i<s.length();i++)
        {
            arr[s.charAt(i)-'A']++;
            int curr=find(arr,k);
            if(curr==-1)
            arr[s.charAt(prev++)-'A']--;
            else
            {
               uwu=Math.max(uwu,curr);
            }
            
        }
        return uwu;
    }
    
    public int find(int arr[],int k){
        int same=0;
        int diff=0;
        for(int i:arr)
        {
            if(i>same)
            {
                diff+=same;
                same=i;
                
            }
            else{
                diff+=i;
            }
        }
        return diff<=k?same+diff:-1;
        }
}
