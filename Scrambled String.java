//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            String s[]=in.readLine().trim().split(" ");
            String a = s[0];
            String b = s[1];
            Solution g = new Solution();
            if(g.isScramble(a,b)){
                out.println("Yes");
            }
            else{
                out.println("No");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static HashMap<String,Boolean> map;
    static boolean isScramble(String S1,String S2)
    {
        //code here
        map=new HashMap<>();
        return help(S1,S2);
    }
    
    static boolean help(String s1,String s2)
    {
        int n=s1.length();
        if(s1.equals(s2))
        {
            map.put(s1+s2,true);
            return true;
        }
        
        if(map.containsKey(s1+s2))
        {
            return map.get(s1+s2);
        }
        
        for(int i=1;i<n;i++)
        {
            String a =s1.substring(0,i);
            String b =s2.substring(0,i);
            String c =s1.substring(i,n);
            String d =s2.substring(i,n);
            if(help(a,b) && help(c,d))
            {
                map.put(s1+s2,true);
                return true;
            }
            String e =s1.substring(0,i);
            String f =s2.substring(n-i,n);
            String g =s1.substring(i,n);
            String h =s2.substring(0,n-i);
            
            if(help(e,f) && help(g,h))
            {
                map.put(s1+s2,true);
                return true;
            }
        }
        map.put(s1+s2,false);
        return false;
        
    }
}
