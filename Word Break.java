//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> dictionary = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            dictionary.add(p);
                        }
                    String s = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(n, s, dictionary));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int wordBreak(int n, String s, ArrayList<String> dictionary )
    {
        //code here
        if(s.length() == 0)return 0;
        
        int N = s.length();
        boolean[] dp = new boolean[N+1];
        dp[0] = true;
        
        for(int i=0; i<=N; i++){
            for(int j=0; j<=i; j++){
                if(dp[j]&&dictionary.contains(s.substring(j,i))){
                    dp[i]=true;
                }
            }
        }

        return dp[N]?1:0;
    }
}
