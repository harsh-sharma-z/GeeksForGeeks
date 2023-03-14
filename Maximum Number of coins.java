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
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>(N);
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(str[i]));
			}
			Solution obj = new Solution();
			System.out.println(obj.maxCoins(N, arr));
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    int maxCoins(int N, ArrayList<Integer> arr) {
		  int [][]dp = new int[arr.size()][arr.size()] ;
        for(int g = 0  ;g<dp.length ;g++)
        {
            for(int i = 0,j = g ;j<dp.length; j++,i++)
            {
                int mx = Integer.MIN_VALUE ;
                for(int k = i ;k<=j;k++)
                {
                    int l = k==i?0:dp[i][k-1] ;
                    int r = k==j?0:dp[k+1][j] ;
                    int val = (i==0?1:arr.get(i-1) )* arr.get(k) *( j== arr.size()-1 ? 1: arr.get(j+1)) ;
                    int sum = l+r+val ;
                    if(sum>mx)
                    mx= sum ;
                }
                dp[i][j]= mx ;
            }
            
        }
        return dp[0][arr.size()-1] ;
	}
}
