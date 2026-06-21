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

    void delete(int ix){

        if(tail==null) {
            System.out.println("The Linked List is Empty there is nothing to delete");
            return;
        }
        if(ix<0 || ix>size) {
            System.out.println("Invalid index there is no element at this index");
            return;
        }
        if(ix==0) deleteAtHead();
        else{
            Node temp = head;
            for(int i=1; i<=ix-1; i++){
                temp=temp.next;
            }
            temp.next = temp.next.next; 
            if(ix==size-1) tail=temp;
            size --;
   
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
    public void insert(int val, int ix) {
        if(ix < 0 || ix > size) return;
        if(ix==0) addAtHead(val);
        else if(ix==size) addAtTail(val);
        else{ 
            Node temp = head;
            for(int i=1; i<=ix-1;i++){
                temp=temp.next;
            }
            Node newVal =new Node(val);
            newVal.next=temp.next;
            temp.next=newVal;
            size++;
        }
 
    }

}

public class LinkedListDataStructure {
    public static void main(String[] args) {
        LinkedList ll =new LinkedList();
        ll.displayLinkedList();
        ll.addAtHead(65); ll.displayLinkedList();
        ll.addAtTail(343);
        ll.addAtHead(5);
        ll.addAtTail(54);
        ll.addAtTail(67);
        ll.displayLinkedList();
        ll.deleteAtHead();
        ll.deleteAtHead();
        ll.displayLinkedList();
        ll.insert(40,1);
        ll.displayLinkedList();
        ll.delete(3);
        ll.displayLinkedList();
    

      
    }
}
