//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


// } Driver Code Ends
/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
     static Node addTwoLists(Node num1, Node num2) {
        // code here
        num1 = reverse(num1);
        num2 = reverse(num2);
        
        Node res =  reverse(add(num1,num2,0));
        
        return removeLeadingZeros(res);
    }
    
    static Node add(Node num1,Node num2,int carry)
    {
        if(num1==null && num2==null && carry==0)
            return null;
        
        int val1 = (num1!=null)?num1.data:0;
        int val2 = (num2!=null)?num2.data:0;
        
        int sum = (val1+val2+carry);
        int nCarry = sum/10;
        
        Node newN = new Node(sum%10);
        newN.next = add((num1!=null)?num1.next:null,
                            (num2!=null)?num2.next:null,
                            nCarry
                        );
        
        return newN;
        
    }
    
    static Node reverse(Node head)
    {
        // 1 2 3 4
        
        if(head==null || head.next == null)
            return head;
        
        Node head1 = reverse(head.next);
        head.next.next = head;
        head.next = null;
        
        return head1;
    }
    
    static Node removeLeadingZeros(Node head) {
    
        while (head != null && head.data == 0) {
            head = head.next;
        }
   
        return head;
    }
}

//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends
