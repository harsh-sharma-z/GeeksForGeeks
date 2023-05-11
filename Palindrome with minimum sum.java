//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            int res = obj.minimumSum(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minimumSum(String s) {
        // code here
        int l=s.length();
        StringBuffer sb=new StringBuffer(s);
        for(int i=0;i<l/2;i++)
        {
            if(s.charAt(i)=='?' && s.charAt(l-i-1)=='?')
            continue;
            else
            if(s.charAt(i)=='?' && s.charAt(l-i-1)!='?')
            sb.setCharAt(i,s.charAt(l-i-1));
            else
            if(s.charAt(i)!='?' && s.charAt(l-i-1)=='?')
            sb.setCharAt(l-i-1,s.charAt(i));
            else
            {
                if(s.charAt(i)!=s.charAt(l-i-1))
                return -1;
            }
        }
        
        int ans=0;
        char prev='.';
        for(int i=0;i<l/2;i++)
        {
            if(sb.charAt(i)!='?')
            {
                if(prev=='.')
                prev=sb.charAt(i);
                else
                if(sb.charAt(i)!=prev)
                ans+=Math.abs(sb.charAt(i)-prev);
                prev=sb.charAt(i);
            }
        }
        return ans*2;
    }
}
