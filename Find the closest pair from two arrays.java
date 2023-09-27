//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String[] element = br.readLine().split(" ");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [] = new int[N];
		    int brr [] = new int[M];
		    String[] elements = br.readLine().split(" ");
		    for(int i=0; i<N; i++)
		        arr[i] = Integer.parseInt(elements[i]);
		        
		    String[] ele = br.readLine().split(" ");
		    for(int i=0; i<M; i++)
		        brr[i] = Integer.parseInt(ele[i]);
		    
		    int X = Integer.parseInt(br.readLine());
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> ans;
		    ans = obj.printClosest(arr, brr, N, M, X);
		    System.out.println(Math.abs(ans.get(0) + ans.get(1) - X));
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    // Function for finding maximum and value pair
    public static ArrayList<Integer> printClosest (int arr[], int brr[], int n, int m, int x) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        int a1 = 0 , a2 = arr.length - 1 , b1 = 0 , b2 = brr.length - 1;
        int minDiff = Integer.MAX_VALUE;
        
        while(a1 <= a2 && b2 >= 0){
            int sum = arr[a1] + brr[b2];
            int diff = Math.abs(sum - x);
            
            if(diff < minDiff){
                minDiff = diff;
                ans.clear();
                ans.add(arr[a1]);
                ans.add(brr[b2]);
            }
            
            if(sum > x) b2 --;
            else a1 ++;
        }
        return ans;
    }
}
