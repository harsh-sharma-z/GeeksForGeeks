//{ Driver Code Starts
import java.util.*;
class GenIP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution sln = new Solution();
            ArrayList<String> str = sln.genIp(s);
            Collections.sort(str);
            if(str.size() == 0)
                System.out.println(-1);
            else{
                for (String u : str) {
                    System.out.println(u);
                }
            }
        }
    }
}
// } Driver Code Ends


/*complete the Function*/

class Solution {
    public static boolean isValid(String s)
    {
        int n=s.length();
        if(n==0||n>3||(s.charAt(0)=='0'&&n>1)||Integer.parseInt(s)>255)
        return false;
        return true;
    }
    public ArrayList<String> genIp(String s) {
        // code here
        ArrayList<String> ans=new ArrayList<>();
        if(s.length()>12)
        {
            ans.add("-1");
            return ans;
        }
        
        int n=s.length();
        
        for(int i=1;i<n-2;i++)
        {
            for(int j=i+1;j<n-1;j++)
            
            {
                for(int k=j+1;k<n;k++)
                {
                    String a=s.substring(0,i);
                    String b=s.substring(i,j);
                    String c=s.substring(j,k);
                    String d=s.substring(k,n);
                    if(isValid(a)&&isValid(b)&&isValid(c)&&isValid(d))
                    ans.add(a+"."+b+"."+c+"."+d);
                }
            }
        }
        return ans;
        
        
    }
}
