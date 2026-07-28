package core.CoreAdvance.collectionframework.hierarchy.list.linkedlist;

public class LinkedListVersionOne {
    static Node head = null;
   static  Node tail = null;

     static class Node{
            int data;
            Node previous;
            Node next;

            Node(int data){
                this.data = data;
            }
    }
    public static void insertLast(int value){
         Node newNode = new Node(value);
         if(head == null ){
             head = newNode;
         }else{
             tail.next = newNode;
         }
        tail = newNode;

    }
}
