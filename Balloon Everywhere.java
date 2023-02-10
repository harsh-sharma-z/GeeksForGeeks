//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.maxInstance(s);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxInstance(String s) {
        // Code here
        int b = 0;
        int a = 0;
        int l = 0;
        int o = 0;
        int n = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'b') {
                b++;
            }
            else if (ch == 'a') {
                a++;
            }
            else if (ch == 'l') {
                l++;
            }
            else if (ch == 'o') {
                o++;
            }
            else if (ch == 'n') {
                n++;
            }
        }
        if (b == 0 || a == 0 || l == 0 || n == 0 || o == 0) {
            return 0;
        }
        int minSingleChar = Math.min(b, Math.min(a, n));
        int minDoubleChar = Math.min(l, o);
        minDoubleChar /= 2;
        return Math.min(minSingleChar, minDoubleChar);
    }
}
