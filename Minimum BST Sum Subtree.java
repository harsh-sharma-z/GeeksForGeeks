//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.charAt(0) == 'N') return null;

        // Creating array of Strings from input
        // String after spliting by space
        String ip[] = str.split(" ");

        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));

        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Starting from the second element
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static Node inputTree(BufferedReader br) throws IOException {
        return buildTree(br.readLine().trim());
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int target;
            target = Integer.parseInt(br.readLine());

            Node root = Node.inputTree(br);

            Solution obj = new Solution();
            int res = obj.minSubtreeSumBST(target, root);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    private static int min=Integer.MAX_VALUE;
    public static int minSubtreeSumBST(int target, Node root) {
        // code here
        min=Integer.MAX_VALUE;
        find(target, root);
        
        return min==Integer.MAX_VALUE ? -1:min;
    }
    
    private static void find(int target,Node root)
    {
        if(root==null)
        return;
        
        
        int sum=sum(root);
        
        if(sum==target && isBST(root))
        min=Math.min(min,size(root));
        
        find(target, root.left);
        
        find(target,root.right);
    }
    
    
    private static int sum(Node root)
    {
        if(root== null)
        return 0;
        return root.data+sum(root.left)+sum(root.right);
    }
    
    private static boolean isBST(Node root)
    {
        return isBSTUtil(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private static boolean isBSTUtil(Node root,int minimum,int maximum)
    {
        if(root==null)
        return true;
        
        
        if(root.data<minimum || root.data> maximum)
        return false;
        
        return isBSTUtil(root.left,minimum,root.data-1) && isBSTUtil(root.right,root.data+1,maximum);
    }
    
    private static int size(Node root)
    {
        if(root==null)
        return 0;
        return 1+size(root.left)+size(root.right);
    }
}
