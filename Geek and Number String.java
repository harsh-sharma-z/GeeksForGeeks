//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            Solution ob = new Solution();
            System.out.println(ob.minLength(s, n));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution { 
    public int minLength(String s, int N) { 
        HashSet<String> hs = new HashSet<>();
        String[] arr = new String[]{"12", "21", "34", "43", "56", "65", "78", "87", "09", "90"};
        for(String str : arr)   hs.add(str);
    	
    	Stack<Character> st = new Stack<>();
    	for(int i=0;i<s.length();i++){
    	    if(!st.isEmpty() && (hs.contains(s.charAt(i)+st.peek()+"") || hs.contains(""+st.peek()+s.charAt(i)))){
    	        st.pop();
    	    }else{
    	        st.push(s.charAt(i));
    	    }
    	}
    	
    	return st.size();
    }
}
