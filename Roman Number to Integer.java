//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        // code here
        int n = str.length();
        int ans = 0 ;
        
        for(int i = 0 ; i < n - 1 ; i++){
            int x = roman(str.charAt(i));
            int y = roman(str.charAt(i + 1));
            
            if(x < y)
                x = -1 * x;
            
            ans += x;
        }
        
        int x = roman(str.charAt(n - 1));
        ans += x;
        return ans;
    }
    
    private static int roman(Character ch){
        int x = 0 ;
        if(ch == 'I')
            x = 1;
        else if(ch == 'V')
            x = 5;
        else if(ch == 'X')
            x = 10;
        else if(ch == 'L')
            x = 50;
        else if(ch == 'C')
            x = 100;
        else if(ch == 'D')
            x = 500;
        else if(ch == 'M')
            x = 1000;
            
        return x;
    }
}
