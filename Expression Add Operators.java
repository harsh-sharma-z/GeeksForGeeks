//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String S;
            S = br.readLine();

            int target;
            target = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<String> res = obj.addOperators(S, target);
            Collections.sort(res);
            for (String s : res) System.out.print(s + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<String> addOperators(String num, int target) {
        // code here
        ArrayList<String> ans=new ArrayList<>();
        if(num==null || num.length()==0)
        return ans;
        help(ans,"",num,target,0,0,0);
        return ans;
    }
    private static void help(ArrayList<String> ans, String path, String num, int target, int ind, long p_val, long prev)
    {
        if(ind == num.length())
        {
            if(target==p_val)
            ans.add(path);
            return;
        }
        for(int i=ind ;i<num.length();i++)
        {
            long cur=Long.parseLong(num.substring(ind,i+1));
            if(ind==0)
            help(ans,path+cur,num,target,i+1,cur,cur);
            else
            {
                help(ans,path+"+"+cur,num,target,i+1,p_val+cur,cur);
                help(ans,path+"-"+cur,num,target,i+1,p_val-cur,-cur);
                help(ans,path+"*"+cur,num,target,i+1,p_val-prev+prev*cur,prev*cur);
            }
            if(num.charAt(ind)=='0')
            break;
        }
    }
}
