//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String x = read.readLine();
            String y = read.readLine();
            Solution ob = new Solution();
            String result = ob.findSum(x, y);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String findSum(String X, String Y) {
        // code here
        
        StringBuilder ans = new StringBuilder();
        int lastIndexX = X.length() - 1;
        int lastIndexY = Y.length() - 1;
        int carry = 0;
        
        while(lastIndexX >= 0 || lastIndexY >= 0) {
            
            if(lastIndexX < 0) {
                ans.append((char)((((Y.charAt(lastIndexY) - 48) + carry) % 10) + 48));
                carry = ((Y.charAt(lastIndexY) - 48) + carry) / 10;
                lastIndexY --;
            }
            
            else if(lastIndexY < 0) {
                ans.append((char)((((X.charAt(lastIndexX) - 48) + carry) % 10) + 48));
                carry = ((X.charAt(lastIndexX) - 48) + carry) / 10;
                lastIndexX --;
            }
            
            else {
                ans.append((char)((((Y.charAt(lastIndexY) - 48) + (X.charAt(lastIndexX) - 48) + carry) % 10) + 48));
                carry = ((Y.charAt(lastIndexY) - 48) + (X.charAt(lastIndexX) - 48) + carry) / 10;
                lastIndexX --;
                lastIndexY --;
            }
        }
        
        if(carry > 0 ) {
            ans.append((char)(carry + 48));
        }
        
        int j = ans.length() - 1;
        while(ans.charAt(j) == '0' && j > 0) {
            ans.deleteCharAt(j);
            j--;
        }
        
        return ans.reverse().toString();
    }
}
