//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            String wild = in.readLine();
            String pattern = in.readLine();
            
            Solution ob = new Solution();
            boolean flag = ob.match(wild, pattern);
            if(flag)
            System.out.println("Yes");
            else
            System.out.println("No");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean match(String wild, String pattern)
    {
        // code here
        int wildIndex = 0;
        int patternIndex = 0;
        int wildStar = -1;
        int patternStar = -1;

        while (patternIndex < pattern.length()) {
            if (wildIndex < wild.length() && (wild.charAt(wildIndex) == pattern.charAt(patternIndex) || wild.charAt(wildIndex) == '?')) {
                wildIndex++;
                patternIndex++;
            } else if (wildIndex < wild.length() && wild.charAt(wildIndex) == '*') {
                wildStar = wildIndex;
                patternStar = patternIndex;
                wildIndex++;
            } else if (wildStar != -1) {
                wildIndex = wildStar + 1;
                patternIndex = patternStar + 1;
                patternStar++;
            } else {
                return false;
            }
        }

        while (wildIndex < wild.length() && wild.charAt(wildIndex) == '*') {
            wildIndex++;
        }

        return wildIndex == wild.length();
    }
}
