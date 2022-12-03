//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int l=1;
        int h=stalls[n-1]-stalls[0];
        while(l<=h){//log (10^9)== 9*log(10) = 30
            int mid=(l+h)/2;
            if(isPossible(k,stalls,mid)){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return h;// (n)
    }
    static boolean isPossible(int k,int[]arr,int minDis){
        int cnt=1;
        int prevCow=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-prevCow>=minDis){
                prevCow=arr[i];
                cnt++;
            }
        }
        return cnt>=k;
    }
}
