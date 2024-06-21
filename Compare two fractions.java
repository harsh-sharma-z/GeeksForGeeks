//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    String compareFrac(String str) {
        str = str.replaceAll("\\s", "");
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(str.split(",")));
        ArrayList<String> value1 = new ArrayList<>(Arrays.asList(strings.get(0).split("/")));
        ArrayList<String> value2 = new ArrayList<>(Arrays.asList(strings.get(1).split("/")));
        if((Float.parseFloat(value1.get(0))/Float.parseFloat(value1.get(1))) > (Float.parseFloat(value2.get(0))/Float.parseFloat(value2.get(1)))){
            return(strings.get(0));
        }else if ((Float.parseFloat(value1.get(0))/Float.parseFloat(value1.get(1))) == (Float.parseFloat(value2.get(0))/Float.parseFloat(value2.get(1)))){
            return("equal");
        }else{
            return(strings.get(1));
        }
    }
}
