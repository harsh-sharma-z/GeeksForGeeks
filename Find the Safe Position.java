//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int k = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.safePos(n,k));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int safePos(int n, int k) {
        // code here
   List<Integer> list=new ArrayList<>();

        for(int i=1;i<=n;i++){

            list.add(i);

        }

            return pos(list,0,k-1);

        

        

}

        static int pos(List<Integer> list, int s, int k )

        {

            if(list.size()==1)

                return list.get(0);

            

                s=(s+k)%list.size();

                list.remove(s);

                return pos(list,s,k);

        }   

    

};

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int k = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.safePos(n,k));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int safePos(int n, int k) {
        // code here
   List<Integer> list=new ArrayList<>();

        for(int i=1;i<=n;i++){

            list.add(i);

        }

            return pos(list,0,k-1);

        

        

}

        static int pos(List<Integer> list, int s, int k )

        {

            if(list.size()==1)

                return list.get(0);

            

                s=(s+k)%list.size();

                list.remove(s);

                return pos(list,s,k);

        }   

    

};

