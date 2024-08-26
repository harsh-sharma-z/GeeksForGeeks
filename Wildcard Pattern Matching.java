//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int wildCard(String pattern, String str) {
        int[][] dp = new int[pattern.length()][str.length()];
     for(int i = 0;i<dp.length;i++){
         for(int j= 0;j<dp[0].length;j++){
             dp[i][j] = -1;
         }
     }
       int ans = solve(pattern,str,0,0,dp);
       return ans;
    }
    public static int solve(String pattern,String str,int l,int m,int[][] dp){
         if(l == pattern.length()-1 && pattern.charAt(l) == '*'){
            return 1;
        }
        else if(l >= pattern.length()  && m < str.length()){
            return 0;
        }else if(l<pattern.length() && m >= str.length()){
            boolean flag = true;
            for(int i=l;i<pattern.length();i++){
                if(pattern.charAt(i) != '*'){
                    flag = false;
                }
            }
            if(flag){
                return 1;
            }
            return 0;
        }else if(l >= pattern.length() && m >= str.length()){
            return 1;
        }
        if(dp[l][m] != -1){
            return dp[l][m];
        } 
        char chp = pattern.charAt(l);
        char chs = str.charAt(m);
        int val = 0;
        if(chp == chs){
             val = solve(pattern,str,l+1,m+1,dp);
        }
        if(chp == '*'){
            int i = l;
            while(pattern.charAt(i) == '*' && i<pattern.length()-1){
                i++;
            }
            if(pattern.charAt(i) == '*'){
                return 1;
            }
            if(pattern.charAt(i) == '?'){
                 val = solve(pattern,str,i+1,m+1,dp);
            }
            
           for(int j = m;j<str.length();j++){
               if(pattern.charAt(i) == str.charAt(j)){
                 int v =  solve(pattern,str,i+1,j+1,dp);
                 if(v == 1){
                     val = 1;
                 }
               }
           }
            
        }
        if(chp == '?'){
            val = solve(pattern,str,l+1,m+1,dp);
        }
       // System.out.println(val);
        
       return dp[l][m] = val;
    }
}
