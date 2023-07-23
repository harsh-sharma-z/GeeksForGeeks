//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(s[i]));
                tail = tail.next;
            }

            head = new Solution().segregate(head);
            printList(head, out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node head,PrintWriter out)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
        Node temp = head;
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
         while(temp != null){
             if(temp.data == 0){
                 c0++;
             }
             else if(temp.data == 1){
                 c1++;
             }else{
                 c2++;
             }
             
             temp = temp.next;
         }
         
         Node ans;
         if(c0 != 0){
              ans = new Node(0);
         }else if(c1 != 0){
              ans = new Node(1);
         }else{
             ans = new Node(2);
         }
         
         Node finans = ans;
         Node n;
         for(int i = 1; i < c1+c2+c0; i++){
             
             if(i<c0){
                n = new Node(0);
                ans.next = n;
                ans = ans.next;
             }else if(i < c0+c1){
                n = new Node(1);
                ans.next = n;
                ans = ans.next;
             }else{
                n = new Node(2);
                ans.next = n;
                ans = ans.next;
             }
             
         }
         
         return finans;
        
    }
}


