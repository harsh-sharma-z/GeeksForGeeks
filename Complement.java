//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String str = br.readLine().trim();

            Vector<Integer> ans = new Solve().findRange(str, n);
            if (ans.size() == 1) {
                System.out.println(ans.get(0));
            } else {
                System.out.println(ans.get(0) + " " + ans.get(1));
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solve {

    Vector<Integer> findRange(String str, int n) {
        // code 
        int cnt = 0;

        Vector<Integer> v = new Vector<>();

        for(int i = 0 ; i < n; i++){

            if(str.charAt(i) == '1'){

                cnt++;

            }

        }

        if(cnt == n){

            v.add(-1);

            return v;

        }else{

            int maxSum = 0;

            int currentSum = 0;

            int end = 0;

            int start = 0;

            int p = 0;

            for(int i = 0 ; i < str.length(); i++){

                int num = str.charAt(i) - '0';

                num = num == 1 ? -1 : 1;

                currentSum = currentSum + num;

                if(maxSum < currentSum){

                    maxSum = currentSum;

                    end = i;

                    start = p;

                }

                if(currentSum  < 0){

                    currentSum = 0;

                    p = i+1;

                }

            }

            v.add(start+1);

            v.add(end+1);

        }

       

        return v;
    }
}
