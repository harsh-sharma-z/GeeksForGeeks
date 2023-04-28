//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
	public static void main (String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
                
        int t=Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n=Integer.parseInt(in.readLine().trim());
            String s=in.readLine().trim();
            int q=Integer.parseInt(in.readLine().trim());
            query a[]=new query[q];
            for(int i=0;i<q;i++){
                String str=in.readLine().trim();
                String st[]=str.split(" ");
                if(st[0].trim().equals("1")){
                    a[i]=new query("1",st[1],st[2],"");
                }else{
                    a[i]=new query("2",st[1],st[2],st[3]);
                }
            }
            Solution ob=new Solution();
            ArrayList<Character> ans=ob.easyTask(n,s,q,a);
            for(char ch:ans){
                out.print(ch+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static ArrayList<Character> easyTask(int n,String s,int q,query queries[])
    {
        char a[]=s.toCharArray();
        ArrayList<Character> ans=new ArrayList<>();
        
        for(query i: queries)
        {
            if(i.type=="1")
            {
                a[Integer.parseInt(i.a)]=i.b.charAt(0);
            }
            else
            {
                
                int k=Integer.parseInt(i.c);
                
                int freq[]=new int[26];
                
                for(int ind=Integer.parseInt(i.a);ind<=Integer.parseInt(i.b);ind++)
                freq[a[ind]-'a']++;
                
                for(int h=25;h>=0;h--)
                {
                    k-=freq[h];
                    if(k<=0)
                    {
                        ans.add((char)(h+'a'));
                        break;
                    }
                }
                
            }
        }
        
        return ans;
    }
}
/*In case the query is of type 1.
type=1
c=null
*/

/*In case the query is of type 2.
type=2
c=k
*/

class query
{
    String type;
    String a;
    String b;
    String c;
    public query(String type,String a,String b,String c)
    {
        this.type=type;
        this.a=a;
        this.b=b;
        this.c=c;
    }
}
