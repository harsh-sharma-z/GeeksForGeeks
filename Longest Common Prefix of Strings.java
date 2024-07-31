//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        if (arr == null || arr.length == 0) {
            return "";
        }
        if(arr.length==1) return arr[0];
        StringBuilder str=new StringBuilder();
        int idx=0;
        while(true){
            
           for(int i=0;i<arr.length-1;i++){
               if(idx>=arr[i].length()||idx>=arr[i+1].length()||arr[i].charAt(idx)!=arr[i+1].charAt(idx)){
                   if(str.length()==0){
                       return "-1";
                   }
                   return str.toString();
               }
           }
           str.append(arr[0].charAt(idx));
           idx++;
        }
    }
}
