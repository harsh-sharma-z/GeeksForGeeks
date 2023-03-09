//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    Node(char x) {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node((s[0].charAt(0))), tail = head;
        for (int i = 1; i < s.length; i++)
            tail = tail.next = new Node((s[i].charAt(0)));

        return head;
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
        out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node head = Node.inputList(br);

            String S = br.readLine().trim();

            Solution obj = new Solution();
            ArrayList<Node> res = obj.findAnagrams(head, S);

            for (Node node : res) {
                Node temp = node;
                Node.printList(temp, out);
            }
            if (res.size() == 0) {
                out.println("-1");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*

Definition for singly Link List Node
class Node
{
    char data;
    Node next;

    Node(char x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<Node> findAnagrams(Node head, String s) {
        // code here
        int n=s.length();
        int arr[]=new int[26];
        for(int i=0;i<n;i++)
        {
            arr[s.charAt(i)-'a']++;
        }
        Node p1=head,p2=head,prev=null;
        int freq[]=new int[26];
        for(int i=0;i<n && p2!=null;i++)
        {
            freq[p2.data-'a']++;
            prev=p2;
            p2=p2.next;
        }
        p2=prev;
        ArrayList<Node> uwu=new ArrayList<>();
        while(p2.next!=null)
        {
            if(isEqual(arr,freq))
            {
                uwu.add(p1);
                Node t1=p2;
                p2=p2.next;
                t1.next=null;
                p1=p2;
                Node prev1=null;
                Arrays.fill(freq,0);
                for(int i=0;i<n && p2!=null;i++)
        {
            freq[p2.data-'a']++;
            prev1=p2;
            p2=p2.next;
        }
        p2=prev1;
                
            }
            else
            {
                freq[p1.data-'a']--;
                p1=p1.next;
                p2=p2.next;
                freq[p2.data-'a']++;
            }
            
        }
        if(isEqual(arr,freq))
        uwu.add(p1);
        
        return uwu;
    }
    
    private static boolean isEqual(int arr[],int freq[])
    {
        for(int i=0;i<arr.length;i++)
            if(arr[i]!=freq[i]) return false;
        return true;
    }
}
