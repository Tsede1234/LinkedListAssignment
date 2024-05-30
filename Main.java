package LinkedListAssignment2;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        this.head = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    int listLength() {
        int length = 0;
        Node current_node = head;
        while (current_node != null) {
            current_node = current_node.next;
            length++;
        }
        return length;
    }

    void printList() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node current_node = head;
        while (current_node != null) {
            System.out.println(current_node.data);
            current_node = current_node.next;
        }
    }

    void insertEnd(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node current_node = head;
            while (current_node.next != null) {
                current_node = current_node.next;
            }
            current_node.next = node;
        }
    }

    void insertHead(Node node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    void insertAtPos(Node node, int position) {
        if (position < 1 || position > listLength() + 1) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 1) {
            insertHead(node);
            return;
        }
        Node current_node = head;
        int current_position = 1;
        while (current_position < position - 1) {
            current_node = current_node.next;
            current_position++;
        }
        node.next = current_node.next;
        current_node.next = node;
    }

    void deleteHead() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node previous_head = head;
        head = head.next;
        previous_head.next = null;
    }

    void deleteEnd() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node current_node = head;
        while (current_node.next.next != null) {
            current_node = current_node.next;
        }
        Node previous_node = current_node;
        previous_node.next = null;
    }

    void deleteAtPosition(int position) {
        if (position < 1 || position > listLength()) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 1) {
            deleteHead();
            return;
        }
        Node current_node = head;
        int current_position = 1;
        while (current_position < position - 1) {
            current_node = current_node.next;
            current_position++;
        }
        Node previous_node = current_node;
        Node node_to_delete = current_node.next;
        previous_node.next = node_to_delete.next;
        node_to_delete.next = null;
    }

    void deleteAfterNode(Node previousNode) {
        if (previousNode == null || previousNode.next == null) {
            System.out.println("Invalid node");
            return;
        }
        Node node_to_delete = previousNode.next;
        previousNode.next = node_to_delete.next;
        node_to_delete.next = null;
    }

    void searchNode(int value) {
        if (head == null) {
            System.out.println("List empty");
            return;
        }
        Node current_node = head;
        int current_position = 1;
        while (current_node != null) {
            if (current_node.data == value) {
                System.out.println("Node found at position " + current_position);
                return;
            }
            current_node = current_node.next;
            current_position++;
        }
        System.out.println("No Node with provided value");
    }
}

class Stack {
    int capacity;
    LinkedList stack;

    Stack(int capacity) {
        this.capacity = capacity;
        this.stack = new LinkedList();
    }

    boolean isFull() {
        return capacity == stack.listLength();
    }

    boolean isEmpty() {
        return stack.head == null;
    }

    void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        Node node = new Node(value);
        stack.insertHead(node);
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        stack.deleteHead();
    }

    int peek() {
        if(isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack.head.data;
    }
}

// Testing the LinkedList operations and Stack implementation
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Inserting nodes at the end
        list.insertEnd(new Node(10));
        list.insertEnd(new Node(20));
        list.insertEnd(new Node(30));

        // Printing the list
        list.printList();  // Output: 10 20 30

        // Inserting node at a specific position
        list.insertAtPos(new Node(15), 2);

        // Printing the list
        list.printList();  // Output: 10 15 20 30

        // Deleting node at a specific position
        list.deleteAtPosition(3);

        // Printing the list
        list.printList();  // Output: 10 15 30

        // Deleting node after a given node
        Node node = new Node(15);
        list.deleteAfterNode(node);

        // Printing the list
        list.printList();  // Output: 10 15

        // Searching a node
        list.searchNode(15);  // Output: Node found at position 2

        // Implementing Stack using linked list
        Stack stack = new Stack(3);

        stack.push(5);
        stack.push(10);
        stack.push(15);

        System.out.println(stack.peek());  // Output: 15

        stack.pop();

        System.out.println(stack.peek());  // Output: 10
    }
}

