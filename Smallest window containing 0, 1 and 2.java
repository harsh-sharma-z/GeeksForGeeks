//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String s) {
        // Code here
        int mini = Integer.MAX_VALUE , x = -1 , y = -1 , z = -1 , n = s.length();
        
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '0')
                x = i;
            else if(s.charAt(i) == '1')
                y = i;
            else if(s.charAt(i) == '2')
                z = i;
            if(x == -1 || y == -1 || z == -1)
                continue;
            int maxL = Math.max(x , Math.max(y , z));
            int minL = Math.min(x , Math.min(y , z));
            mini = Math.min(mini , maxL - minL + 1);
        }
        return mini == Integer.MAX_VALUE ? -1 : mini;
    }
};
