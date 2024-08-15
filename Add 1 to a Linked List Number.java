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

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
Node a=null;
    Node b=null;
    int number=0;
    int sum=0;
    int count=0;
public  Node addOne(Node head) {

    if (count == 0) {
        a = head;
        b = head;
    }
    count++;
    if (head.next == null) {
        if (count == 1) {
            head.data = head.data + 1;
            return head;
        }
        sum = (sum * 10 + head.data) + 1;
        if (sum < 10) {
            count = 0;
            head.data = head.data + 1;
            return a;
        } else {
            number = sum % 10;
            head.data = number;
            sum = sum / 10;
            return head;
        }

    }
    addOne(head.next);
    if (count != 0) {
        count--;
        sum = sum + head.data;
        if (count == 1 && sum >= 10) {
            number = sum % 10;
            head.data = number;
            sum = sum / 10;
            Node c = new Node(sum);
            c.next = head;
            return c;
        }
        number = sum % 10;
        head.data = number;
        sum = sum / 10;
    }
    return a;

}
}
