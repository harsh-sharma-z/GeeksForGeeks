//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
        int count = 0;
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == target){
                count++;
                int l = left+1;
                while(l < right && arr[l] == arr[left]){
                    count++;
                    l++;
                }
                int r = right-1;
                while(left < r && arr[r] == arr[right]){
                    count++;
                    r--;
                }
                left++;
                right--;
            }
            else if(sum < target){
                left++;
            }
            else{
                right--;
            }
        }
        return count;
    }
}


//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends
