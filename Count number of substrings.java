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
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    long substrCount (String s, int k) {
        // your code here
        return solve(s , k) - solve(s , k - 1);
    }
    long solve(String s , int k){
        int[] arr = new int[26];
        int d = 0 , i = 0;
        long ans = 0 ;
        
        for(int j = 0 ; j < s.length() ; j++){
            arr[s.charAt(j) - 'a']++;
            if(arr[s.charAt(j) - 'a'] == 1)
                d++;
                
            while(d > k){
                arr[s.charAt(i) - 'a']--;
                if(arr[s.charAt(i) - 'a'] == 0)
                    d-- ;
                i++;
            }
            
            ans += (j - i + 1);
        }
        return ans;
    }
}
