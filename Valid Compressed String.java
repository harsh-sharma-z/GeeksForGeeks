//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String T = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.checkCompressed(S,T));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int checkCompressed(String S, String T) {
        // code here
        int j = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T.length(); i++) {
			// Checking whether the character is a numeric one?
			if (T.charAt(i) >= 48 && T.charAt(i) <= 57) {
				sb.append(T.charAt(i));
			} else {

				if (!sb.toString().isEmpty()) {
					j = j + Integer.parseInt(sb.toString());
					sb = new StringBuilder();
				}
				if (T.charAt(i) != S.charAt(j)) {
					return 0;
				} else
					j++;
			}

		}
		if (!sb.toString().isEmpty()) {
			j = j + Integer.parseInt(sb.toString());
			if (j > S.length())
				return 0;
		}
		return 1;
    }
}
