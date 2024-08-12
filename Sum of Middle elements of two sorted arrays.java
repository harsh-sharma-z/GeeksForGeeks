//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int SumofMiddleElements(int[] a1, int[] a2) {
        // code here
        int m=a1.length;
        int n=a2.length;
        int[] a=new int[m+n];
        int i,j,k;
        i=j=k=0;
        while(i<m && j<n){
            if(a1[i]<=a2[j]){
                a[k]=a1[i];
                i++;
                k++;
            }
            else{
                a[k]=a2[j];
                j++;
                k++;
            }
        }
        while(i<m){
            a[k]=a1[i];
            i++;
            k++;
        }
        while(j<n){
            a[k]=a2[j];
            j++;
            k++;
        }
        int p=(n+m)/2;
        return a[p-1]+a[p];
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends
