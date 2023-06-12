//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int[] np=new int[price.length+1];
        for(int i=0;i<price.length;i++){
            np[i+1]=price[i];
        }
        int[] dp=new int[np.length];
        dp[0]=0;
        dp[1]=np[1];
        for(int i=2;i<dp.length;i++){
            //left right strategy
            dp[i]=np[i];
            int li=1;
            int ri=i-1;
            while(li<=ri){
                if(dp[li]+dp[ri] > dp[i]){
                    dp[i]=dp[li]+dp[ri];
                }
                li++;
                ri--;
            }
        }
        return dp[dp.length-1];
    }
}
