//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            String A = obj.minSum(a);
            System.out.println(A);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String minSum(int[] arr) {
        // code here
        
        StringBuilder s = new StringBuilder();

        Arrays.sort(arr);
        int carry = 0;
        int sum;


        for (int i = arr.length-1 ;i>=0;i = i-2) {
            sum = arr[i] + (i - 1 >= 0 ? arr[i - 1] : 0) + carry;
            s.append(sum % 10);       // Append only the current digit
            carry = sum / 10; 
        }
        
        if(carry > 0) s.append(carry);

        while (s.charAt(s.length()-1) == '0'){
            s.delete(s.length()-1,s.length());
        }
        
        return s.reverse().toString();
    }
}
