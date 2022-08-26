//{ Driver Code Starts
import java.util.*;
class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			//System.out.println(str.length());
			Solution ob  = new Solution();
			System.out.println(ob.countPS(str));
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete below method */

class Solution
{   
    
     long mod=1000000007;
    long[][] dp;
   
    long countPS(String str)
    {
        // Your code here
         int n=str.length();
        dp=new long[n+1][n+1];
        
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        long ans=countPs(str,0,n-1);
        return ans<0?ans+mod:ans;
    }
    
    long countPs(String p,int i,int j){
        if(i>j) return dp[i][j]=0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(i==j) return dp[i][j]=1;

        if(p.charAt(i)==p.charAt(j)){
            return dp[i][j]=(1+countPs(p,i,j-1)%mod+countPs(p,i+1,j)%mod)%mod;
        }else{
            return dp[i][j]=(countPs(p,i,j-1)%mod+countPs(p,i+1,j)%mod-countPs(p,i+1,j-1)%mod)%mod;
        }
        
    }
}
