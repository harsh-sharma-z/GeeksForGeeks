//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            
            Solution ob = new Solution();
            if(ob.sameFreq(a)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    boolean sameFreq(String s) {
        // code here
        int cnt[] = new int[26];
        for(int i = 0;i<s.length();i++){
            cnt[s.charAt(i)-'a']++;
        }
        Arrays.sort(cnt);
        //Minimum and maximum frequency one
        int min = 0,max = cnt[25];
        // find the minimum frequency
        for(int i = 0;i<26;i++){
            if(cnt[i]==0) continue;
            else{
                min = cnt[i];
                break;
            }
        }
        int mincnt= 0,maxcnt=0;
        
        for(int i = 0;i<26;i++){
            if(cnt[i]==0)continue;
            if(min!=cnt[i]) mincnt++;
            if(max!=cnt[i]) maxcnt++;
        }
        if(mincnt==0||maxcnt==0) return true;
        if(mincnt==1){
            if(max==min+1) return true;
        }
        if(maxcnt==1){
            if(min==1) return true;
        }
        return false;
    }
}
