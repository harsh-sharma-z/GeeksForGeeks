//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String str) {
        // Write your code here
        str = str + ".";
        int c = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < str.length() ; i++) {
            char ch = str.charAt(i);
            if(ch != '.') {
                sb.append(ch);
            }
            else if(sb.length() > 0) {
                c++;
                int val = Integer.parseInt(sb.toString());
                
                if(val < 0 || val > 255) {
                    return false;
                }
                if(sb.length() > 1 && sb.charAt(0) == '0') {
                    return false;
                }
                sb.setLength(0);
            }
            else {
                return false;
            }
        }
        return c == 4 ? true : false;
    }
}
