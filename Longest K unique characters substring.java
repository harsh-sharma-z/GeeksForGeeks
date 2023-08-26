//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        if(s == null || s.length() == 0)
            return -1;
            
        int l = 0 , r = 0;
        int max = -1;
        Map<Character , Integer> map = new HashMap<>();
        while(r < s.length()){
            map.put(s.charAt(r) , map.getOrDefault(s.charAt(r) , 0) + 1);
            
            while(map.size() > k && l < r){
                map.put(s.charAt(l) , map.get(s.charAt(l)) - 1);
                if(map.get(s.charAt(l)) == 0)
                    map.remove(s.charAt(l));
                l++;
            }
            
            if(map.size() == k){
                max = Math.max(max , (r - l + 1));
            }
            r++;
        }
        // while(l < r){
        //     map.put(s.charAt(l) , map.get(s.charAt(l)) - 1);
        //     if(map.get(s.charAt(l)) == 0){
        //         map.remove(s.charAt(l));
        //     }
        //     l++;
        //     if(map.size() == k){
        //         max = Math.max(max , r - l + 1);
        //     }
            
        // }
        return max;
    }
}
