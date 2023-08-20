//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int idx = bs(arr , n , x);
        if(idx == -1) return 0;
        int c = 1;
        int p = idx - 1;
        while(p >= 0 && arr[p] == x){
            c++;
            p--;
        }
        p = idx + 1;
        while(p < n && arr[p] == x){
            c++;
            p++;
        }
        return c;
    }
    
    int bs(int[] arr , int n , int x){
        int l = 0 , r = n - 1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(arr[mid] == x){
                return mid;
            }
            if(arr[mid] < x){
                l = mid + 1;
            }
            if(arr[mid] > x){
                r = mid - 1;
            }
        }
        return -1;
    }
}
