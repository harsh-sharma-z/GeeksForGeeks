//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public static int minChar(String s) {
        int n = s.length();
        String rev_s = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev_s;

        // Compute the LPS array for the combined string
        int[] lps = computeLPS(combined);

        // Minimum characters to add = n - length of the longest palindromic suffix
        return n - lps[combined.length() - 1];
    }

    private static int[] computeLPS(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0; // Length of the previous longest prefix suffix
        int i = 1;

        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        var sc = new FastReader();
        int test = sc.nextInt();
        while (test-- > 0) {
            String s = sc.nextString();
            System.out.println(Solution.minChar(s));

            System.out.println("~");
        }
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        private void read() throws IOException {
            st = new StringTokenizer(br.readLine());
        }

        public String nextString() throws IOException {
            while (!st.hasMoreTokens()) read();
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(nextString());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(nextString());
        }
    }
}
// } Driver Code Ends
