//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String s, int k) {
        // code here
        if(s.length() == k) 
        return "0";
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            while(st.size() > 0 && k > 0 && ch < st.peek()){
                st.pop();
                k --;
            }
            if(st.isEmpty() && ch == '0')
                continue;
            else
                st.push(ch);
        }
        while(!st.isEmpty() && k > 0){
            st.pop();
            k--;
        }
        if(st.size() == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            char ch = st.pop();
            sb.append(ch);
        }
        return sb.reverse().toString();
    }
}
