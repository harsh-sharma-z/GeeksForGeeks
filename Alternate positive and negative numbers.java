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
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int arr[], int n) {
        // code here
        int pos=0,neg=0;
        for(int i=0;i<n;i++){
            if(arr[i]>=0){
                pos++;
            }
            else{
                neg++;
            }
        }
        int[] posArr=new int[pos];
        int[] negArr=new int[neg];
        int index1=0,index2=0;
        for(int i=0;i<n;i++){
            if(arr[i]>=0){
                posArr[index1++]=arr[i];
            }
            else{
                negArr[index2++]=arr[i];
            }
        }
        int i=0,i1=0,i2=0;
        while(i1<index1 && i2<index2){
            arr[i++]=posArr[i1++];
            arr[i++]=negArr[i2++];
        }
        while(i1<index1){
            arr[i++]=posArr[i1++];
        }
        while(i2<index2){
            arr[i++]=negArr[i2++];
        }
        
    }
}
