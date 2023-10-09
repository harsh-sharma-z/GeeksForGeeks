//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
     static boolean flag = false;
    
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k) {
        flag = false;
        ArrayList<Node> path = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        rootToTargetNode(root, target, path);
        Node block = null;
        
        Collections.reverse(path);
        
        for(int i=0; i<path.size(); i++) {
            addTargetNodes(path.get(i), block, k-i, ans);
            block = path.get(i);
        }
        Collections.sort(ans);
        return ans;
    }
    
    
    public static void rootToTargetNode(Node node, int target, ArrayList<Node> path) {
        if(node == null || flag) return;
        
        if(node.data == target) {
            flag = true;
        }
        
        path.add(node);
        rootToTargetNode(node.left, target, path);
        rootToTargetNode(node.right, target, path);
        if(!flag) path.remove(path.size()-1);
    }
    
    public static void addTargetNodes(Node node, Node block, int k, ArrayList<Integer> ans) {
        if(node == block || node == null || k < 0) return;
        
        if(k == 0) ans.add(node.data);
        
        addTargetNodes(node.left, block, k-1, ans);
        addTargetNodes(node.right, block, k-1, ans);
    }
};
