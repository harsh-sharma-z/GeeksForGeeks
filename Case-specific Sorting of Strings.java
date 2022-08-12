//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
class Solution
{
    //Function to perform case-specific sorting of strings.
    public static String caseSort(String str)
    {
        // Your code here
        PriorityQueue<Character> lower = new PriorityQueue<>();
        PriorityQueue<Character> upper = new PriorityQueue<>();
        for(char c : str.toCharArray()){
            if(Character.isLowerCase(c)){
                lower.add(c);
            } else {
                upper.add(c);
            }
        }
        char[] chs = new char[str.length()];
        int idx = 0;
        for(char c : str.toCharArray()){
            if(Character.isLowerCase(c)){
                chs[idx++] = lower.poll();
            } else {
                chs[idx++] = upper.poll();
            }
        }
        return new String(chs);
    }
}

//{ Driver Code Starts.

class GFG {
    
	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = new Solution().caseSort(str);
    	        System.out.println(sortedStr);
    	    }
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
}

// } Driver Code Ends
