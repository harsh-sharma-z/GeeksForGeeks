//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class LinkedList {
    // Function to print nodes in a given circular linked list
    static void printList(Node head) {
        if (head == null) {
            System.out.println("empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int key = Integer.parseInt(br.readLine());
            Node head = new Node(arr.get(0));
            Node tail = head;
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            tail.next = head; // Make the list circular
            Solution ob = new Solution();
            Node current = ob.deleteNode(head, key);
            Node rev = ob.reverse(current);
            printList(rev);
        }
    }
}

// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data=d;next=null;
    }
}*/

class Solution {
    Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node frw = head.next;
        while(frw != head){
            curr.next = prev;
            prev = curr;
            curr = frw;
            frw = frw.next;
        }
        curr.next = prev;
        frw.next = curr;
        return curr;
    }
    Node deleteNode(Node head, int key) {
        Node temp = head;
        if(head.data == key){
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            return head.next;
        }
        while(temp.next.data!=key && temp.next != head){
            temp = temp.next;
        }
        if(temp.next.data == key) temp.next = temp.next.next;
        return head;
    }
}
