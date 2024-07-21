//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(sc.nextInt());

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public long findMaxProduct(List<Integer> al) 
    {
        int MOD = 1000000007;
        if (al.size() == 1) 
            return al.get(0) % MOD;
        

        boolean posExists = false;
        int negativeCount = 0;
        int maxNegNumber = Integer.MIN_VALUE;
        int zeros = 0;
        long product = 1;
        int minNegNumber = Integer.MIN_VALUE;

        for (Integer e : al) 
        {
            if (e > 0) 
            {
                posExists = true;
                product = (product * e) % MOD;
            } 
            else if (e < 0) 
            {
                negativeCount++;
                maxNegNumber = Math.max(e, maxNegNumber);
                if (minNegNumber == Integer.MIN_VALUE || e > minNegNumber) 
                    minNegNumber = e;
                
                product = (product * e) % MOD;
            } 
            else 
                zeros++;
            
        }

        if (zeros == al.size()) 
            return 0;
        

        if (negativeCount % 2 != 0) 
        {
            if (negativeCount == 1 && zeros > 0 && !posExists) 
            {
                return 0;
            }
            product = product / minNegNumber;
        }

        return product  % MOD;
    }
}
