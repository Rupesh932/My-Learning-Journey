package core.CoreAdvance.collectionframework.hierarchy.list.linkedlist.singlyinkedist;

public class SinglyLinkedList {
    public static void main(String[] args) {
        Node n1 = createNode(33);
        printNode(n1,"head");
        System.out.println("-------------------------------------");

        Node n2 = createNode(44);
        printNode(n2,"second ");
        System.out.println("-------------------------------------");

        Node n3 = createNode(55);
        printNode(n3,"third");
        System.out.println("-------------------------------------");

        Node n4 = createNode(66);
        printNode(n4,"fourth");
        System.out.println("-------------------------------------");

        Node n5 = createNode(77);
        printNode(n5,"tail");
        System.out.println("-------------------------------------");

        //Linking Node to each other
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println("***** After linked all 5 nodes *****");

        printNode(n1,"head");
        System.out.println("-------------------------------------");

        printNode(n2,"second ");
        System.out.println("-------------------------------------");

        printNode(n3,"third");
        System.out.println("-------------------------------------");

        printNode(n4,"fourth");
        System.out.println("-------------------------------------");

        printNode(n5,"tail");
        System.out.println("-------------------------------------");
        System.out.println("Linkage proof -> n1.next == n2 :"+(n1.next == n2));

        //print next node using previous node
        System.out.println("Data inside node n2 using n1: "+ n1.next.data);
        //print all data of list.
        printLinkedList(n1);

        //insert Node at first : O(1)
        Node first = createNode(11);
        first.next = n1;
        printLinkedList(first);
        // at random positon
        Node second = createNode(22);
        first.next = second;
        second.next = n1;
        printLinkedList(first);
        //at last
        n5.next= createNode(99);
        printLinkedList(first);

        //accessing O(n)



    }

    public static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    public static Node createNode(int value) {
        return new Node(value);
    }

    public static void printNode(Node n,String flag) {
        System.out.println(flag+" Node data: " + n.data);
        System.out.println(flag+" Node next: " + n.next);
    }
    public static void printLinkedList(Node head){
        System.out.println("*** Loop printing list with the help of head node ***");
        while(head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }


}
