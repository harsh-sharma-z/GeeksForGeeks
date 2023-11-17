//{ Driver Code Starts
//Initial Template for Java

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

class GfG {
    
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
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    static void displayCList(Node head)
    {
        Node itr = head;
        do
        {
            System.out.print(itr.data + " ");
            itr = itr.right;
        } while (head!=itr);
        System.out.println();
    	itr=itr.left;
    	head = itr;
    	do{
    		System.out.print(itr.data + " ");
    		itr=itr.left;
    	}while(head!=itr);
    	System.out.println();
    }
    
	public static void main (String[] args) throws IOException {
	        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t-- > 0){
	            String s= br.readLine();
	            Node root = buildTree(s);
	            
	            Solution boj = new Solution();
	            Node head = boj.bTreeToClist(root);
	            displayCList(head);
	            
	        }
	    
	}
}



// } Driver Code Ends


//User function Template for Java



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
class Solution
{ 
    //Function to convert binary tree into circular doubly linked list.
    static Node prev ;
    static Node ans ;
    Solution(){
        this.prev = null;
        this.ans = null;
    }
    Node bTreeToClist(Node root)
    {
        ans = null;
        Binary_TreeTO_DLL(root);
        DLL_to_CDLL(ans);
        return ans;
    }
    //Convert Dll to to circular linked-List.
    public static void DLL_to_CDLL(Node root){
        Node last = ans;
        while(last.right != null){
            last = last.right;
        }
        last.right = ans;
        ans.left = last;
    }
    //Convert to Dubly-Linked_list.
    public static void Binary_TreeTO_DLL(Node root){
        if(root == null){
            return;
        }
        Binary_TreeTO_DLL(root.left);
        
        
        if(prev == null){
            ans = root;
        }else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        
        
        Binary_TreeTO_DLL(root.right);
    }
    
}
    
