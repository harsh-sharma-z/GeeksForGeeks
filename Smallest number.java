//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends



class Solution {
    public String smallestNumber(int s, int d) {
        int m = (int) Math.pow(10, (d-1));
        for(int i=m;i<m*10;i++){
            int sum=0,m2=i;
            while(m2!=0){
                sum+=(m2%10);
                m2=m2/10;
            }
            if(sum==s){
                return String.valueOf(i);
            }
        }
        return "-1";
    }
}
