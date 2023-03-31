//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			Solution obj = new Solution();
			int [] b = obj.lexicographicallyLargest(arr, n);
			for(int x: b) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    void swap(int[] arr , int a , int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    void reverse(int arr[] , int i, int j)
    {
        while(i<j)
        {
            j--;
            swap(arr,i,j);
            i++;
        }
    }
	int [] lexicographicallyLargest(int [] arr, int n) {
		//Write your code here
		int i=0;
		while(i<n)
		{
		    int j=i+1;
		    
		    while(j<n && (arr[j]+arr[j-1])%2==0)
		    {
		        j++;
		    }
		    
		    Arrays.sort(arr,i,j);
		    reverse(arr,i,j);
		    i=j;
		}
		
		return arr;
		    
	}
}
