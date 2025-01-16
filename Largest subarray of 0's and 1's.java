//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Create BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of test cases
        int T = Integer.parseInt(br.readLine());

        // Process each test case
        while (T-- > 0) {
            // Read the entire line containing the array elements
            String line = br.readLine();

            // Split the line into an array of strings, then parse them as integers
            String[] tokens = line.split("\\s+");
            int[] a = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                a[i] = Integer.parseInt(tokens[i]);
            }

            // Create the Solution object
            Solution obj = new Solution();

            // Call maxLen function and print the result
            System.out.println(obj.maxLen(a));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxLen(int[] arr) {
        
        /*Replacing 0 with -1 will make this problem same as 
        finding the length of the longest subarray whose sum is 0*/
        
        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(0,0);
        
        int res=0;
        int currSum=0;
        
        for(int i=0;i<arr.length;i++){
            
            currSum+=(arr[i]==0)?-1:1;
            
            if(currSum==0){
                res=i+1;
            }
            else if(mp.containsKey(currSum)){
                 res=Math.max(res,i-mp.get(currSum));
            }
            
            if(!mp.containsKey(currSum)){
                mp.put(currSum,i);
            }
            
        }
        
        return res;
    }
}
