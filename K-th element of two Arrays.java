//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] arr1 = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                arr1[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] arr2 = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                arr2[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(k, arr1, arr2));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long kthElement(int k, int arr1[], int arr2[]) {
        
        // Merge 2 sorted arrays
        
        int m = arr1.length;
        int p = arr2.length;
        
        int n = m + p;
        
        int[] A = new int[n];
        long element = -1;
        
        int i = 0;
        int j = 0;
        
        int x = 0;
        
        while(i < m && j < p){
            
            if(arr1[i] < arr2[j]){
                A[x] = arr1[i];
                i++;
                x++;
            }else{
                A[x] = arr2[j];
                j++;
                x++;
            }
        }
        
        while(i < m){
            A[x] = arr1[i];
            i++;
            x++;
        }
        
        while(j < p){
            A[x] = arr2[j];
            j++;
            x++;
        }
        
        for(int index = 0; index < n; index++){
            if(index == (k-1)){
                element = A[index];
                break;
            }
        }
        return element;
    }
}
