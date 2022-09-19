//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a1[] = in.readLine().trim().split("\\s+");
            int a[] = new int[n];
            for(int i = 0;i < n;i++)
                a[i] = Integer.parseInt(a1[i]);
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.leftSmaller(n, a);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static List<Integer> leftSmaller(int n, int a[])
    {
        //code here
        ArrayList<Integer> list = new ArrayList<>();

        Stack<Integer> st = new Stack<>();

        st.push(a[0]);

        list.add(-1);

        for(int i=1;i<n;i++){

            

            while(st.size()>0 && a[i]<=st.peek()){

                st.pop();

            }

            if(st.size()==0){

           
                list.add(-1);

                st.push(a[i]);

            }

            else{

            

                list.add(st.peek());

                st.push(a[i]);

            }       

        }

        return list;
    }
}
