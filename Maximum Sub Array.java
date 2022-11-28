//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            ArrayList<Integer> ans = new Solution().findSubarray(a, n);
            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    ArrayList<Integer> findSubarray(int a[], int n) {
        // code here
         int maxSum=0;
        int maxStart=0;
        int maxEnd=0;
        int currSum=0;
        int currStart=0;
        for(int i=0;i<n;i++){
            if(a[i]<0){
                currSum=0;
                currStart=i+1;
            }else{
                currSum+=a[i];
            }

            if(currSum>maxSum){
                maxSum=currSum;
                maxStart=currStart;
                maxEnd=i+1;
            }else if(currSum==maxSum){
                int currDis=i+1-currStart;
                int maxDis=maxEnd-maxStart;
                if(currDis>maxDis){
                    maxStart=currStart;
                    maxEnd=i+1;
                }
            }

        }

        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=maxStart;i<maxEnd;i++){
            ans.add(a[i]);
        }
        if(ans.size()==0)ans.add(-1);
        return ans;
    }
}
