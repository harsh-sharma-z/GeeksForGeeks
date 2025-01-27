//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    private static List<String> inputLine(Scanner sc) {
        return Arrays.asList(sc.nextLine().split(" "));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int capacity = Integer.parseInt(sc.nextLine());
            LRUCache cache = new LRUCache(capacity);

            int queries = Integer.parseInt(sc.nextLine());
            while (queries-- > 0) {
                List<String> vec = inputLine(sc);
                if (vec.get(0).equals("PUT")) {
                    int key = Integer.parseInt(vec.get(1));
                    int value = Integer.parseInt(vec.get(2));
                    cache.put(key, value);
                } else {
                    int key = Integer.parseInt(vec.get(1));
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way

class Node{
    int data;
    Node prev,next;
    Node(int x){
        data=x;
        prev=null;
        next=null;
    }
}
class LRUCache {
    // Constructor for initializing the cache capacity with the given value.
   static HashMap<Integer,Node> map;
   static HashMap<Node,Integer> map2;
   static Node head,tail;
    static int size,capacity;
    LRUCache(int cap) {
        // code here
        map=new HashMap<>();
        map2=new HashMap<>();
        head=null;
        tail=null;
        size=0;
        capacity=cap;
    }

    // Function to return value corresponding to the key.
    public static int get(int key) {
        // your code here
        if(map.get(key)==null) return -1;
           if(head==null || head.next==null) return head.data;
         Node temp=map.get(key);
      
         if(temp.prev==null) {
             head=head.next;
             head.prev=null;
             
         }
         else if(temp.next==null){
             tail=temp.prev;
             tail.next=null;
         }
         else{
             Node prev=temp.prev;
             prev.next=temp.next;
             prev.next.prev=prev;
         }
         tail.next=temp;
         temp.next=null;
         temp.prev=tail;
         tail=temp;
         return temp.data;
            
    }

    // Function for storing key-value pair.
    public static void put(int key, int value) {
        // your code here
        if(map.get(key)==null) size++;
        if(size>capacity){
            size--;
             map.remove(map2.get(head));
             map2.remove(head);
            head=head.next;
          if(head!=null)  head.prev=null;
          if(head==null) tail=head;
           
        }
        
        if(map.get(key)!=null){
             Node temp=map.get(key);
               temp.data=value;
            if(head.next==null) {
                return;
            }
              
         if(temp.prev==null) {
             head=head.next;
             head.prev=null;
             
         }
         else if(temp.next==null){
             tail=temp.prev;
             tail.next=null;
         }
         else{
             Node prev=temp.prev;
             prev.next=temp.next;
             prev.next.prev=prev;
         }
         tail.next=temp;
         temp.next=null;
         temp.prev=tail;
         tail=temp;
        }
        else{
            if(head!=null){
            Node newnode=new Node(value);
            tail.next=newnode;
            newnode.prev=tail;
            tail=newnode;
                map.put(key,tail);
                map2.put(tail,key);
            }
            else{
                 Node newnode=new Node(value);
                 head=newnode;
                 tail=newnode;
                 map.put(key,head);
                 map2.put(head,key);
            }
            
        }
        // System.out.println(map);
    }
}
