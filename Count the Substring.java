//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    } 

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();        
        PrintWriter out = new PrintWriter(System.out);
        int testcases = sc.nextInt();

        while (testcases-- > 0) {
            String S = sc.next();
            Solution ob = new Solution();
            long ans = ob.countSubstring(S);
            out.println(ans);
        }
        out.flush();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    long countSubstring(String S){
        int n=S.length();
        long[]dp=new long[2*n+1];// no. of substring with >= zeroes
        int cnt=n;
        int minus=0;
        for(int i=0;i<n;i++){
            if(S.charAt(i)=='0'){
                cnt--;
            }else{
                cnt++;
            }
            if(cnt<=n){
                minus++;
            }
            dp[cnt]++;
        }


        long ans=0L;
        int idx=n;
        for(int i=0;i<n;i++){
           ans+=(n-i - minus)*1l;
           if(S.charAt(i)=='1'){
               idx++;
               dp[idx]--;
               minus+=dp[idx];
           }else{
               minus--;
               minus-=dp[idx];
               idx--;
               dp[idx]--;
           }
        }
        return ans;
    }
}
