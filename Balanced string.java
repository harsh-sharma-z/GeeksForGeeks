//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Position this line where user code will be pasted.
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.BalancedString(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private static final String ALPHABETS = "abcdefghijklmnopqrstuvwxyz";
    
    static String BalancedString(int N) {
        StringBuilder res = new StringBuilder(N);
        res.append(ALPHABETS.repeat(N / 26));
        
        int sod = sumOfDigits(N);
        N %= 26;
        
        if(N == 0) {
            return res.toString();
        }
        
        int count = ((N >> 1) + (N & 1) * (1 - (sod & 1))); 
        
        res.append(ALPHABETS, 0, count);
        res.append(ALPHABETS, 26 - N + count, 26);
        
        return res.toString();
    }
    
    private static int sumOfDigits(int n) {
        int sum = 0;
        while(n != 0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
}
