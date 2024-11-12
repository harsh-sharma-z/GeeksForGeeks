//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                String temp[] = br.readLine().trim().split(" ");
                arr[i][0] = Integer.parseInt(temp[0]);
                String x = temp[1];
                arr[i][1] = Integer.parseInt(x);
            }
            Solution obj = new Solution();
            boolean ans = obj.canAttend(arr);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


class Solution {
    static boolean canAttend(int[][] arr)  

{

        // Your code here

        Map<Integer,Integer>map=new TreeMap<>();

        for(int i=0;i<arr.length;i++) map.put(arr[i][0],arr[i][1]);

        int arrs[]=new int[arr.length];

        int inc=0;

        for(int ele:map.keySet()){

         arrs[inc]=ele;

         inc++;

        }

        for(int i=0;i<arrs.length-1;i++){

            if((map.get(arrs[i])<=arrs[i+1])) ;

            else return false;

        }

        return true;

    }
}
