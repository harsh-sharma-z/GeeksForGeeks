//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int d = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minSteps(d));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minSteps(int d) {
        
        // for reaching d we need to add 1 + 2 + 3.. but due to addition
        // we cannot reach for every value of d so we need to go in negative directions 
        // and then take larger step
        // so d = sum of all positives(X) - sum of all negatives(Y) X, Y = [1,2,3...]
        // X - Y = d
        // X + Y = (n * (n + 1)) / 2 (n = no of steps)
        // 2*X = (n * (n + 1)) / 2 + d
        // 2*Y = (n * (n + 1)) / 2 - d
        // we get 2 conditions:
        //      1. ((n * (n + 1)) / 2 + d) % 2 == 0 i.e. (n * (n + 1)) / 2 + d should be even
        //      2. Y >= 0 => (n * (n + 1)) / 2 >= d
        
        for(int i = 1; i < 2 * d; i++){
            
            int ap = (i * (i + 1)) / 2;
            
            if((ap + d) % 2 == 0 && ap >= d) return i;
            
        }
        
        // to reach d steps we need atmost 2 * d steps as taking i negative step and (i + 1)positive step
        // makes only one step e.g. -i + (i + 1) = 1 
        // so for moving 1 step we need 2 steps one negative, and next one positive hence 2 * d steps
        return 2 * d;
    }
}
