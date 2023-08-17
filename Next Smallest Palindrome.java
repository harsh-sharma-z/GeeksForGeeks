//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int num[] = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(str[i]);
            }

            Vector<Integer> ans = new Solution().generateNextPalindrome(num, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    Vector<Integer> generateNextPalindrome(int num[], int n) {
        // code here
        Vector<Integer> ans = new Vector<>();
        if(areAll9(num)){
            ans.add(1);
            for(int i = 1 ; i < n ; i++){
                ans.add(0);
            }
            ans.add(1);
        }
        else{
            generate(num , n);
            for(int i : num)
                ans.add(i);
        }
        return ans;
        
    }
    void generate(int[] num , int n){
        int mid = n / 2;
        boolean leftSmaller = false;
        int i = mid - 1;
        int j = (n % 2) == 0 ? mid : mid + 1;
        while(i >= 0 && num[i] == num[j]){
            i--;
            j++;
        }
        if(i < 0 || num[i] < num[j])
            leftSmaller = true;
        while(i >= 0){
            num[j] = num[i];
            j++;
            i--;
        }
        if(leftSmaller){
            int carry = 1;
            i = mid - 1;
            if(n % 2 == 1){
                num[mid] += carry;
                carry = num[mid] / 10;
                num[mid] %= 10;
                j = mid + 1;
            }
            else{
                j = mid;
            }
            while(i >= 0){
                num[i] += carry;
                carry = num[i] / 10;
                num[i] %= 10;
                num[j++] = num[i--];
            }
        }
    }
    boolean areAll9(int[] num){
        for(int i : num){
            if(i != 9)
                return false;
        }
        return true;
    }
}
