package core.CoreAdvance.collectionframework.hierarchy.list.linkedlist.doublelinkedlist;

public class DoubleLinkedListOverview {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        System.out.println("*********** before link ***********");
        printNode(n1,"first");
        printNode(n2,"second");
        printNode(n4,"fourth");
        printNode(n5,"fifth");
        printNode(n6,"sixth");

        // linkage
        n1.next = n2;

        n2.previous = n1;
        n2.next = n4;

        n4.previous = n2;
        n4.next = n5;

        n5.previous = n4;
        n5.next = n6;

        n6.previous = n5;

        System.out.println("*********** After link ***********");
        printNode(n1,"first");
        printNode(n2,"second");
        printNode(n4,"fourth");
        printNode(n5,"fifth");
        printNode(n6,"sixth");

        //insertion and link
        Node n3 = new Node(3);
        n3.previous = n2;
        n3.next = n4;
        n4.previous = n3;
        n2.next = n3;

        System.out.println("*********** After insertion ***********");
        printNode(n1,"first");
        printNode(n2,"second");
        printNode(n3,"third");
        printNode(n4,"fourth");
        printNode(n5,"fifth");
        printNode(n6,"sixth");

        //display data using head only
        System.out.println("*********** Bakwas printer ***********");
        displayDataUsingHeadBakwas(n1);

        System.out.println("*********** better printer ***********");
        displayDataUsingHeadAndLoop(n1);

        //display recursively
        System.out.println("*********** recursively printer ***********");
        displayRecursively(n1);
        System.out.println();
        System.out.println("*********** recursively reverse printer ***********");
        displayRecursivelyReverse(n1);
        System.out.println();

        //getting size of list
        int size = size(n1);
        System.out.println("Size of my Linked List: "+ size);


    }



    static class Node {
        int data;
        Node next;
        Node previous;

        Node(int data) {
            this.data = data;
        }
    }

    public static void printNode(Node node,String flag) {
        System.out.println("---------------------------------------------");
        System.out.println(flag+ " Node Data: " +node.data);
        System.out.println(flag+ " Node Next: " +node.next);
        System.out.println(flag+ " Node Previous: " +node.previous);
        System.out.println("---------------------------------------------");
    }

    public static void displayDataUsingHeadBakwas(Node head){
        System.out.println("First: "+head.data);
        System.out.println("second: "+head.next.data);
        System.out.println("third: "+head.next.next.data);
        System.out.println("fourth: "+head.next.next.next.data);
        System.out.println("fifth: "+head.next.next.next.next.data);
        System.out.println("sixth: "+head.next.next.next.next.next.data);
    }

    public static void displayDataUsingHeadAndLoop(Node head){
        Node current = head;
        while(current != null){
            System.out.print(current.data+" -> ");
            current = current.next;
        }
        System.out.println();
    }

    public static void displayRecursively(Node head){

        if(head == null){

            return;
        }
        System.out.print(head.data+" -> ");// before recursive call
        displayRecursively(head.next);

    }

    public static void displayRecursivelyReverse(Node head){

        if(head == null){
            return;
        }
        displayRecursivelyReverse(head.next);
        System.out.print(head.data+" -> ");// after recursive call

    }

    // size of list
    public static int size(Node head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
}
