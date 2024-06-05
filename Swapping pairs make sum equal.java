//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    long findSwapValues(long a[], int n, long b[], int m) {
        // Your code goes here
        long sumA = 0, sumB = 0;
        
        for (long num : a) {
            sumA += num;
        }
        for (long num : b) {
            sumB += num;
        }
        
        long diff = sumA - sumB;
        
        // If diff is odd, return -1 since we can't split the difference evenly
        if (diff % 2 != 0) {
            return -1;
        }
        
        // We are looking for x - y = diff / 2
        long targetDiff = diff / 2;
        
        HashSet<Long> setB = new HashSet<>();
        for (long num : b) {
            setB.add(num);
        }
        
        for (long x : a) {
            long y = x - targetDiff;
            if (setB.contains(y)) {
                return 1;
            }
        }
        
        return -1;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n = Integer.parseInt(q[0]);
            int m = Integer.parseInt(q[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            long b[] = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(a2[i]);
            }
            Solution ob = new Solution();
            long ans = ob.findSwapValues(a, n, b, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends
