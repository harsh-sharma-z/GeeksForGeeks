//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            out.println(ob.decodedString(s));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String decodedString(String s){
        // code here
        Stack<Character> st = new Stack<>();

        int n = s.length();

        StringBuilder res = new StringBuilder("");

        for(int i = 0; i < n; i++){

            char c = s.charAt(i);

            if(c!=']'){

                st.push(c);

            }else{

                while(st.peek()!='['){

                    res.append(st.pop());

                }

                res.reverse();

                st.pop();

                StringBuilder rnum = new StringBuilder("");

                

                while(!st.empty() && st.peek() >= '0' && st.peek() <= '9'){

                    rnum.append(st.pop());

                }

                

                rnum.reverse();

                String sr = res.toString();

                for(int k = 0; k < Integer.parseInt(rnum.toString())-1; k++){

                    

                    res.append(sr);

                }

                for(int k = 0; k < res.length(); k++){

                    

                    st.push(res.charAt(k));

                }

                

                res = new StringBuilder("");

            }

        }

        

        res = new StringBuilder("");

        

        while(!st.empty()){

            

            res.append(st.pop());

        }

        

        return res.reverse().toString();
    }
}
