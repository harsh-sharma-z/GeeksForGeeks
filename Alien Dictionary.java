//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<K;i++)
        adj.add(new ArrayList<>());
        for(int i=0;i<N-1;i++)
        {
            String a=dict[i];
            String b=dict[i+1];
            
            for(int j=0;j<Math.min(a.length(),b.length());j++)
            {
                if(a.charAt(j)!=b.charAt(j))
                {
                    adj.get(a.charAt(j)-'a').add(b.charAt(j)-'a');
                    break;
                }
                
            }
        }
        
        ArrayList<Integer> ans= topo(adj,K);
        String res="";
        for(int i: ans)
        {
            res=res+ ((char)(i+(int)('a')));
        }
        return res;
    }
    
    private ArrayList<Integer> topo (ArrayList<ArrayList<Integer>> adj, int K)
    {
        int in[]=new int[K];
        
        for(int i=0;i<K;i++)
        {
            for(int a:adj.get(i))
            in[a]++;
        }
        
        Queue<Integer> uwu=new LinkedList<>();
        for(int i=0;i<K;i++)
        {
            if(in[i]==0)
            uwu.add(i);
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        while(!uwu.isEmpty())
        {
            int node=uwu.peek();
            uwu.remove();
            
            ans.add(node);
            
            for(int a:adj.get(node))
            {
                in[a]--;
                if(in[a]==0)
                uwu.add(a);
            }
        }
        
        return ans;
    }
}
