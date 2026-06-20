import java.util.*;

class Node{
    int val;
    Node next; //null
    Node(int val){
        this.val=val;
    }
}

class LinkedList{
    Node head;
    Node tail;
    int size;
    void addAtHead(int val){
        Node temp = new Node(val);
        if(head==null) head = tail = temp;
        else{
            temp.next =head;
            head=temp;
        }
        size++;

    }
    void addAtTail(int val){
        Node temp = new Node(val);
        if(tail==null) head = tail = temp; // if tail is null then head will also be null and vice versa it is well understood which means there is no linked list in existence
        else{
            tail.next =temp;
            tail=temp;  
            size++;
        }
    }    

    void deleteAtHead(){
        if(head==null) {
            System.out.println("The Linked List is Empty there is nothing to delete");
            return;
        }
        else{
            head = head.next;
            if(head==null)tail=null; // This case handles when there is oply a single Node in the Linked List which means that head.next will be equal to null and same for tail
            size--;
        }

    }

    void deleteAtTail(){
        if(tail==null) {
            System.out.println("The Linked List is Empty there is nothing to delete");
            return;
        }
        if(head.next==null) { // case when there is only a single node
            head = tail = null;
            size--;
        }
        else{
            Node temp = head;
            while (temp.next.next != null) { // The node previous to tail as tail.next=null
                temp = temp.next; // increments the temp
            }
            temp.next=null;
            tail=temp;
            size--;  
   
        }

    }
    
    void displayLinkedList(){
        if(head==null) return ;
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println();
    }

}

public class LinkedListDataStructure {
    public static void main(String[] args) {
        LinkedList ll =new LinkedList();
        ll.displayLinkedList();
        ll.addAtHead(65);
        ll.addAtTail(343);
        ll.addAtHead(5);
        ll.addAtTail(54);
        ll.addAtTail(67);
        ll.displayLinkedList();
        ll.deleteAtTail();
        ll.deleteAtHead();
        ll.deleteAtHead();
        ll.displayLinkedList();

      
    }
}
