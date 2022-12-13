//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] arr , int N, int K) {
        // code here
        int l=0;
        int h=0;
        int ans=0;
        for(int i:arr){
            l=Math.max(l,i);
            h+=i;
        }

        while(l<=h){
            int mid=l+(h-l)/2;
            if(isPossible(mid,arr,K)){
                ans=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    static boolean isPossible(int maxSum,int[]arr,int k){
        int cnt=0;
        int currSum=0;
        for(int i:arr){
            if(currSum+i>maxSum){
                cnt++;
                currSum=i;
            }else{
                currSum+=i;
            }
        }

        if(currSum<=maxSum)cnt++;
        return cnt<=k;
    }
};
