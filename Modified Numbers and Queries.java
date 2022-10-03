//{ Driver Code Starts
//Initial Template for Java
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
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int l = Integer.parseInt(input[0]); 
            int r = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.sumOfAll(l,r));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution

{

    public int sumOfAll(int l, int r)

    {

        int sum=0;

        for(int i=l; i<=r; i++)

        {

            if(i==1)

                sum += 1;

            else

            {

                boolean p = isPrime(i);

                if(p==true)

                {

                    sum += i;

                }

                else

                {

                    int noprime = noPrime(i);

                    sum += noprime;

                }

            }

                

        }

        return sum;

    }

    public boolean isPrime(int n)

    {

        boolean flag = false;

        for (int i = 2; i <= n / 2; ++i)

        {

      

            if (n % i == 0)

            {

                flag = true;

                break;

            }

        }

 

        if (!flag)

            return true;

        else

            return false;

    }

    

    public int noPrime(int n)

    {

        int sum =0;

        for(int i=2; i<=n/2; i++)

        {

            if(n % i == 0)

            {

                boolean p = isPrime(i);

                if(p==true)

                    sum+=i;

            }

        }

        return sum;

    }

}
