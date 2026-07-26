import java.util.*;

class ListNoe{
    int val;
    ListNoe next;
    ListNoe prev;
    ListNoe(int val){
        this.val=val;
    }
}
class DLL{
    ListNoe head;
    ListNoe tail;
    int size;
    void insertAthead(int val){
        ListNoe temp = new ListNoe(val);
        if(head==null) head=tail=temp;
        else{
            temp.next=head;
            head.prev=temp;
            head= temp;
        }
        size++;


    }


    void insertAtTail(int val){
        ListNoe temp = new ListNoe(val);
        if(head==null) head=tail=temp;
        else{
            tail.next=temp;
            temp.prev=tail;
            tail= temp;

        }

    }


    void deleteAthead(){
        
    }
}
   
public class DoublyLinkeListClass {
    public static void main(String[] args) {
        
    }
    
}
