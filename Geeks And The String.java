//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.removePair(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String removePair(String s) {
        // code here
        Stack<Character> uwu=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(uwu.isEmpty())
            uwu.push(c);
            else
            if(!uwu.isEmpty() && uwu.peek()==c)
                uwu.pop();
            else
            uwu.push(c);
        }
        
        if(uwu.isEmpty())
        return "-1";
        String ans="";
        while(!uwu.isEmpty())
        ans=uwu.pop()+ans;
        return ans;
    }
}
        
