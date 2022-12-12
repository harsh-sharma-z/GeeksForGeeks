//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
        for(int i=0;i<nums.length;i++)

        {

            nums[i]=nums[i]%k;

        }

        int count0=0;

        int index=-1;

        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++)

        {

            if(nums[i]==0)

            count0++;

            else

            {

                index=i;

                break;

            }

        }

        if(count0%2!=0) return false;

        if(index==-1 && count0%2==0) return true;

        int left=index;

        int right=nums.length-1;

        while(left<right)

        {

            if((nums[left]+nums[right])!=k)

            return false;

            left++;

            right--;

        }

        return true;
    }
}
