//{ Driver Code Starts
// Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
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
} class pair {
    int first;
    int second;
    pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
} class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
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
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static boolean isBST(Node n, int lower, int upper) {
        if (n == null) return true;
        if (n.data <= lower || n.data >= upper) return false;
        return (isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper));
    }

    public static boolean compare(Node a, Node b, ArrayList<pair> mismatch) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        if (a.data != b.data) {
            pair temp = new pair(a.data, b.data);
            mismatch.add(temp);
        }

        return (compare(a.left, b.left, mismatch) &&
                compare(a.right, b.right, mismatch));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Node duplicate = buildTree(s);

            Solution g = new Solution();

            root = g.correctBST(root);

            // check 1: is tree now a BST
            if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) == false) {
                out.println(0);
                continue;
            }

            // check 2: comparing with duplicate tree

            ArrayList<pair> mismatch = new ArrayList<pair>();
            // an arraylist to store data of mismatching nodes

            if (compare(root, duplicate, mismatch) == false) {
                // false output from this function indicates change in structure
                // of tree
                out.println(0);
                continue;
            }

            // finally, analysing the mismatching nodes
            if (mismatch.size() != 2 ||
                mismatch.get(0).first != mismatch.get(1).second ||
                mismatch.get(0).second != mismatch.get(1).first)
                out.println(0);
            else
                out.println(1);
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java


/*
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
*/

class Solution  {
    public Node correctBST(Node root)  {
        List<Node> list = new ArrayList<>();
        inOrder(root, list);
        
        int idx1 = -1, idx2 = -1;
        
        for(int i=0; i<list.size()-1; i++)  {
            if(list.get(i).data > list.get(i+1).data)  {   
                if(idx1 == -1) idx1 = i;
                else idx2 = i+1;
            }
        }
        
        if(idx2 == -1) swap(list, idx1, idx1+1);
        else swap(list, idx1, idx2);
        
        return root;
    }
    
    private void swap(List<Node> list, int i, int j)
    {
        Node node1 = list.get(i);
        Node node2 = list.get(j);
        
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }
    
    private void inOrder(Node root, List<Node> list)
    {
        if(root == null) return;
        
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }
}
