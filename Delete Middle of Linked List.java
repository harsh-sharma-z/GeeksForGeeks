//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            Solution g = new Solution();
            head = g.deleteMid(head);
            printList(head); 
            t--;
        }
    } 
} 
   

// } Driver Code Ends


/*
class Node {
    int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    public Node deleteMid(Node start) {
        if(start.next == null){//if only 1 node.
            return null;
        }
        if(start.next.next == null){//if only 2 node.
            start.next = null;
            return start;
        }
        Node slow = start, first = start;
        int size = even_odd(start);
        Node temp = null;
        while(first.next!=null && first.next.next!=null){
            temp = slow;
            slow = slow.next;
            first = first.next.next;
        }
        if(size%2==0){
            temp = temp.next;
            temp.next = temp.next.next;
        }else{
            temp.next = temp.next.next;
        }
        return start;
    }
    public static int even_odd(Node start){
        int count = 0;
        Node p = start;
        while(p!=null){
            p = p.next;
            count++;
        }
        return count;
    }
}
