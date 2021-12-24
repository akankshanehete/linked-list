/* Assignment 7 (100 marks in total; 5% of the final score of this course)
 *
 * Question 2 (60 marks)
    Use java to implement a data structure named LinkedList, and implement several methods of the LinkedList.

 */

class Node {
    // initalizing variable types for node class
    int data; // 'data' stores the value of a node.
    Node next; // 'next' refers/points to the next node

    // the construction method of class Node.
    Node(int d) {
        data = d;
        next = null;
    }
}

class Q2_LinkedList {
    Node head; // head node points to the first element of the list

    // Insert 'new_data' at the beginning of the LinkedList
    // (5 marks)
    public void insertAtBeginning(int new_data) {
        /* place your code here */
        Node node = new Node(new_data);
        node.next = head;
        head = node;
    }

    // Insert 'new_data' at the end of the LinkedList
    // (5 marks)
    public void insertAtEnd(int new_data) {
        /* place your code here */
        Node node = new Node(new_data);
        node.next = null;
        if (head == null){
            head = node;
        }
        else {
            Node n = head;
            while(n.next != null){
                n=n.next;
            }
            n.next = node;
        }

    }

    // Insert 'new_data' after a node referred to as 'prev_node'
    // (10 marks)
    public void insertAfter(Node prev_node, int new_data) {
        /* place your code here */
        Node node = new Node(new_data);
        Node n = head;
        int index = 0;

        while(n != null){
            if(n == prev_node){
                break;
            }
            n = n.next;
            index++;
        }

        for(int i=0;i<index-1;i++){
            n = n.next;
        }
        node.next = n.next;
        n.next = node;
    }

    // Delete a node located in 'position' of the Linked List. The first element of the LinkedList has a position=0.
    // (10 marks)
    void deleteNode(int position) {
        /* place your code here */
        Node temp = null;
        if (position == 0){
            head = head.next;
        }
        else {
            Node n = head;
            for(int i=0; i< position-1;i++){
                n=n.next;
            }
            temp = n.next;
            n.next = temp.next;
            temp = null;
        }
    }

    // Search for a node containing the value of 'key' in the LinkedList.
    // If there is a node in the LinkedList whose value is equal to 'key', then return 'true'.
    // If there is no node in the LinkedList whose value is equal to 'key', then return 'false'.
    // (15 marks)
    boolean search(Node head, int key) {
        /* place your code here */
        Node n = head;
        while (n.next != null){
            if ( key == n.data){
                return true;
            }
            n = n.next;
        }
        return false;
    }

    // Sort the nodes in the LinkedList in ascending orders of their values.
    // Requirement: please use bubble sort.
    // Example: for a LinkedList: head->3->5->1->4->2, the sorted LinkedList should be head->1->2->3->4->5.
    // (15 marks)
    void sortLinkedList(Node head) {
        /* place your code here */
        Node n = head;
        Node index = null;
        int temp;
        while(n != null) {
            //Node index will point to node next to current
            index = n.next;

            while(index != null) {
                //If current node's data is greater than index's node data, swap the data between them
                if(n.data > index.data) {
                    temp = n.data;
                    n.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            n = n.next;
        }
    }

    // Print the linked list
    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

    }

    public static void main(String[] args) {
        /* TA may test different functions of the LinkedList here */
        /* The following is just an example of how to do the test. */

        Q2_LinkedList llist = new Q2_LinkedList();

        llist.insertAtEnd(1);
        llist.insertAtBeginning(2);
        llist.insertAtBeginning(3);
        llist.insertAtEnd(4);

        llist.insertAfter(llist.head.next, 5);

        System.out.println("Linked list: ");
        llist.printList();

        System.out.println("\nAfter deleting an element: ");
        llist.deleteNode(3);
        llist.printList();

        System.out.println();
        int item_to_find = 3;
        if (llist.search(llist.head, item_to_find))
            System.out.println(item_to_find + " is found");
        else
            System.out.println(item_to_find + " is not found");

        llist.sortLinkedList(llist.head);
        System.out.println("\nSorted List: ");
        llist.printList();
    }
}