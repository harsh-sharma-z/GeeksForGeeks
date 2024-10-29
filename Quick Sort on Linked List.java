//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class SortLL {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            addToTheLast(head);

            for (int i = 1; i < n; i++) {
                int a = Integer.parseInt(str[i]);
                addToTheLast(new Node(a));
            }

            GfG gfg = new GfG();
            Node node = gfg.quickSort(head);

            printList(node);
            System.out.println();
        
System.out.println("~");
}
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }

}*/
// you have to complete this function
class GfG {
    public static int partition(ArrayList<Integer> arr, int low, int high) {
    // Median-of-three pivot selection
        int mid = low + (high - low) / 2;
        int pivotIndex = low;
        
        if (arr.get(low) > arr.get(mid)) {
            pivotIndex = mid;
        }
        if (arr.get(low) > arr.get(high)) {
            pivotIndex = high;
        }
        if (arr.get(mid) > arr.get(high)) {
            pivotIndex = high;
        }
    
        // Move pivot to the start
        int pivot = arr.get(pivotIndex);
        Collections.swap(arr, low, pivotIndex);
    
        int left = low + 1;
        int right = high;
    
        while (true) {
            while (left <= high && arr.get(left) <= pivot) {
                left++;
            }
            while (right > low && arr.get(right) > pivot) {
                right--;
            }
            if (left >= right) {
                break;
            }
            Collections.swap(arr, left, right);
        }
        
        Collections.swap(arr, low, right);
        return right; // Return the index of the pivot
    }
    
    public static void quicksort(ArrayList<Integer> arr, int low, int high) {
        if (low < high) {
            int pidx = partition(arr, low, high);
            quicksort(arr, low, pidx - 1);
            quicksort(arr, pidx + 1, high);
        }
    }

    public static ArrayList<Integer> qs(ArrayList<Integer> arr) {
        if (arr.size() <= 1) return arr;
        quicksort(arr, 0, arr.size() - 1);
        return arr;
    }

    public static Node quickSort(Node node) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        Node temp = node;
        while (temp != null) {
            arr.add(temp.data);
            temp = temp.next;
        }
        
        ArrayList<Integer> sortedArr = qs(arr);
        
        Node dummy = new Node(-1);
        Node current = dummy;
        
        for (Integer value : sortedArr) {
            current.next = new Node(value);
            current = current.next;
        }
        
        return dummy.next;
    }
}
