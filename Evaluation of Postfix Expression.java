//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    public int evaluate(String[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        for(String s : arr){
            if(Character.isDigit(s.charAt(0)) || 
            (s.length() > 1 && s.charAt(0) == '-' && 
            Character.isDigit(s.charAt(1)))){
                st.push(Integer.parseInt(s));
            }else{
                int b = st.pop();
                int a = st.pop();
                int c = 0;
                
                switch(s){
                    case "+":
                        c = a + b;
                        break;
                    case "-":
                        c = a - b;
                        break;
                    case "*":
                        c = a * b;
                        break;
                    case "/":
                        c = a / b;
                        break;
                }
                
                st.push(c);
            }
        }
        return st.pop();
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int t = Integer.parseInt(line);
        while (t-- > 0) {
            line = reader.readLine();
            String[] arr = line.split(" ");
            Solution solution = new Solution();
            System.out.println(solution.evaluate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends
