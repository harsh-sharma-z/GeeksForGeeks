//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        
        //while testcases exist
        while(t-->0){
            
            String inputLine1[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine1[0]);
            int k = Integer.parseInt(inputLine1[1]);
            
            ArrayList<Integer> arr = new ArrayList<>();            
            String inputLine2[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr.add(Integer.parseInt(inputLine2[i]));
            }
            
            Solution obj = new Solution();
            obj.reverseInGroups(arr, n, k);
            
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr.get(i) + " ");
            }
            System.out.println(str);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    //Function to reverse every sub-array group of size k.
    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        // code here
        if(k>n)
            k = n;
        int kCopy = k;
        int s = k-1;
        int i = 0;
        int temp;
        while(i<n) {
            if((k&1)==1)
                while(i!=s) {
                    temp = arr.get(i);
                    arr.set(i, arr.get(s));
                    arr.set(s, temp);
                    ++i;
                    --s;
                }
            else
                while(i<s) {
                    temp = arr.get(i);
                    arr.set(i, arr.get(s));
                    arr.set(s, temp);
                    ++i;
                    --s;
                }
            i = kCopy;
            kCopy += k;
            if(kCopy>n)
                break;
            s = kCopy-1;
        }
        // set of elements to be reversed::[i, n-1]
        s = n-1;
        if(((n-i)&1)==0)
            while(i<s) {
                temp = arr.get(i);
                arr.set(i, arr.get(s));
                arr.set(s, temp);
                ++i;
                --s;
            }
        else
            while(i!=s) {
                temp = arr.get(i);
                arr.set(i, arr.get(s));
                arr.set(s, temp);
                ++i;
                --s;
            }
    }
}
