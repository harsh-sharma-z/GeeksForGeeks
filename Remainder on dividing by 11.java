//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
  
            String x = br.readLine(); 
            
            Solution ob = new Solution();
		
            System.out.println(ob.xmod11(x)); 

            t--;
        }
    } 
} 



// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int xmod11(String s)
	{    
	    // code here
	    int num,rem=0;
	    for(int i=0;i<s.length();i++)
	    {
	        num=rem*10+(s.charAt(i)-'0');
	        rem=num%11;
	    }
	    return rem;
	}
} 

