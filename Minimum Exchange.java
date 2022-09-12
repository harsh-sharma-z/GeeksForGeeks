//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] matrix = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    matrix[i][j] = S.charAt(j);
                }
            }
            Solution obj = new Solution();
            int ans = obj.MinimumExchange(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int MinimumExchange(char[][] matrix)
    {
        // Code here
        int a=0;

        int b=0;

        for(int i = 0; i<matrix.length; i++ ) {

            for (int j = 0; j<matrix[0].length; j++ ) {

                if(matrix[i][j]=='A') {

                    if((i+j)%2==1 ) {

                        a++;

                    } else {

                        b++;

                    }

                } else {

                    if((i+j)%2 == 1 ) {

                        b++;

                    }else {

                        a++;

                    }

                }

            }

        }

        if((matrix.length*matrix[0].length)%2==1 ){

             return a/2;

           }

        return Math.min(a, b)/2;
    }
}
