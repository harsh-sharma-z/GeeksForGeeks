//{ Driver Code Starts
//Initial Template for Java

import java.util.*;


class Node
{
    int data;
    Node left, right;
    
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}


class ConstructTree
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int pre[] = new int[n];
            int preM[] = new int[n];
            
            for(int i = 0; i < n; i++)
              pre[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preM[i] = sc.nextInt();
            
            Solution gfg = new Solution();  
           
            
            inorder(gfg.constructBTree(pre, preM, n));
            System.out.println();
            
        }
    }
    
    public static void inorder(Node root)
    {
        if(root == null)
         return;
         
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int i = 0;
    Set<Integer> set = new HashSet<>();
    
    public Node construct(int pre[], int preM[], int last)
    {
        Node node = new Node(pre[i]);
        set.add(pre[i]);
        for(int j=0; j<pre.length-1; j++)
        {
            if(pre[i] == preM[j])
            {
                if(set.contains(preM[j+1]) || j<last)
                {
                    return node;
                }else
                {
                    i++;
                    if(i==pre.length)
                    {
                        return node;
                    }
                    node.left = construct(pre, preM, j);
                    i++;
                    if(i==pre.length)
                    {
                        return node;
                    }
                    node.right = construct(pre, preM, j);
                    return node;
                }
            }
        }
        return node;
    }
    
    public Node constructBTree(int pre[], int preM[], int size)
    {
        // your code here
        return construct(pre, preM, 0);
    }
    
}
