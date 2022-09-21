//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.ReFormatString(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static String ReFormatString(String S, int K){
        // code here
        int c=0;
        StringBuilder sb=new StringBuilder();
        for(int i=S.length()-1;i>=0;i--)
        {
            char ch=S.charAt(i);
            if(ch=='-')
            continue;
            
            if(Character.isLowerCase(ch))
            sb.append(Character.toUpperCase(ch));
            else
            sb.append(ch);
            c++;
            if(c==K)
            {
                sb.append('-');
                c=0;
                
            }
        }
        sb.reverse();
        if(sb.length()>0 && sb.charAt(0)=='-')
        sb.deleteCharAt(0);
        return sb.toString();
    }
}
