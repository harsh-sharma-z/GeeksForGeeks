//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    private ArrayList<String> ans;
    public ArrayList<String> permutation(String S)
    {
        //Your code here
        ans = new ArrayList<>();
        if(S.length() == 0 || S.length() == 1){
            ans.add(S);
            return ans;
        }
        solve(S.toCharArray() , new char[S.length()] , 0 , S.length());
        Collections.sort(ans);
        return ans;
    }
    
	private void solve(char[] s , char[] temp , int idx , int n){
	    if(idx >= n){
	        ans.add(new String(temp));
	        return;
	    }
	    
	    for(int i = 0 ; i < n ; i++){
	        if(s[i] != '#'){
	            temp[idx] = s[i];
	            char prev = s[i];
	            s[i] = '#';
	            solve(s , temp , idx + 1 , n);
	            s[i] = prev;
	        }
	    }
	}
}
