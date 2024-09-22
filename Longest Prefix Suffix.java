//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int lps(String str) {
        // code here
        int i=1, j=0, n=str.length();
        int storeLength[]=new int[n];
        while(i<n){
            if(str.charAt(i)==str.charAt(j))storeLength[i++]=++j;
            else if(j>0) j=storeLength[j-1];
            else i++;
        }
        return storeLength[n-1];
        
        
    }
}
