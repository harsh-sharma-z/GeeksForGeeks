//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            int k = Integer.parseInt(br.readLine());
            ArrayList<Integer> res = new Solution().maxOfSubarrays(arr, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        // code here
         ArrayList<Integer> list = new ArrayList<Integer>();
        
        int tempMax= findMax(0,k-1,arr);
        list.add(tempMax);
        
        for(int i=1; i<=arr.length-k; i++){
            if(tempMax == arr[i-1] ){
                tempMax = findMax(i, i+k-1,arr);
                list.add(tempMax);
            }
            else{
                    tempMax = Math.max(tempMax, arr[i+k-1]);
                    list.add(tempMax);
            }
        }
        return list;
        
    }
    
    public int findMax(int start, int end, int arr[]){
        int max=0;
        while(start <= end){
            max = Math.max(max, arr[start]);
            start++;
        }
        return max;
    }
}
