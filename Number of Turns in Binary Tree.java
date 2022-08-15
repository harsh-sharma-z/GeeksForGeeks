//{ Driver Code Starts
//Initial template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            
            String line = br.readLine();
            String[] splitLine = line.split(" ");
            int nd1 = Integer.parseInt(splitLine[0]);
            int nd2 = Integer.parseInt(splitLine[1]);
            int turn;

            Solution ob = new Solution();
            if((turn = ob.NumberOfTurns(root, nd1, nd2)) != 0)
              System.out.println(turn);
            else
              System.out.println("-1");
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java
/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/




//Easy to understand code without repetition of similar cases

class Solution
{
    static int ans;
    static int NumberOfTurns(Node root, int first, int second)
    {
        ans=0;
        Node lca=lca(root,first,second);
        if(lca.data==first){
            solve(lca,second,null);
            return ans;
        }else if(lca.data==second){
            solve(lca,first,null);
            return ans;
        }
        solve(lca,first,null);
        solve(lca,second,null);
        return ans+1;
    }

    static boolean solve(Node root,int x,Boolean left){
        if(root==null)  return false;
        if(root.data==x)     return true;
        
        if(left==null){
            solve(root.left,x,true);
            solve(root.right,x,false);
            return true;
        }else if(left){
            if(solve(root.left,x,true)){
                return true;
            }
            if(solve(root.right,x,false)){
                ans++;
                return true;
            }
        }else{
            if(solve(root.right,x,false)){
                return true;
            }if( solve(root.left,x,true) ){
                ans++;
                return true;
            }
        }
        
        return false;
    }
    static Node lca(Node root, int n1,int n2)
	{
	    if(root==null)  return root;
	    if(root.data==n1 || root.data==n2)    return root;
	    
	    Node left=lca(root.left,n1,n2);
	    Node right=lca(root.right,n1,n2);
	    
	    if(left!=null && right!=null){
	        return root;
	    }
	    
	    return left==null?right:left;
	}
}




