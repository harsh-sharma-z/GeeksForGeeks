//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String srgs[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s1[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            String s = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPossible(n, m, s));
        }
    }
}
// } Driver Code Ends


// User function Template for 

class Solution{
    static int isPossible(int n, int m, String s){
        // code here
        int tl=0,tr=0,tu=0,td=0;
        int clr=0,cud=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='L')
            clr++;
            else
            if(c=='R')
            clr--;
            else
            if(c=='U')
            cud++;
            else
            cud--;
            
            
            if(clr>=0)
            tl=Math.max(clr,tl);
            else
            tr=Math.min(clr,tr);
            
            if(cud>=0)
            tu=Math.max(cud,tu);
            else
            td=Math.min(cud,td);
        }
        
        if(tu-td<n && tl-tr<m)
        return 1;
        return 0;
    }
}
