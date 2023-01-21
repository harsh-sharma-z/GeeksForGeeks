//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            out.println(ob.minVal(a, b));
        }
        out.flush();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int minVal(int a, int b) {
        // code here
        int bitsA=Integer.bitCount(a);
        int bitsB=Integer.bitCount(b);
        int diff=Math.abs(bitsA-bitsB);
        
        if(diff==0)return a;
        else if(bitsA>bitsB){
            while(diff>0){
                a = a&(a-1);
                diff--;
            }
        }else{
            while(diff>0){
                a = a|(a+1);
                diff--;
            }
        }
        return a;
    }
}
