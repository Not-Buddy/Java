import java.util.Scanner;

public class DoublyLinkedList<T> {

    // --- Node Structure (Now with 'prev') ---
    public static class Node<T> {
        public T data;
        public Node<T> next;
        public Node<T> prev;
        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public Node<T> head;

    public DoublyLinkedList() {
        this.head = null;
    }

    // --- ADD OPERATIONS ---
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node<T> curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.prev = curr; // Link backwards
    }

    public void addAt(int index, T data) {
        if (index < 0) {
            System.out.println("Invalid index.");
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }

        Node<T> newNode = new Node<>(data);
        Node<T> curr = head;

        // Traverse to the node BEFORE the index
        for (int i = 0; i < index - 1; i++) {
            if (curr == null) {
                System.out.println("Index out of bounds.");
                return;
            }
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println("Index out of bounds.");
        } else {
            // Wiring the new node
            newNode.next = curr.next;
            newNode.prev = curr;
            
            // If there is a node ahead, link it back to new node
            if (curr.next != null) {
                curr.next.prev = newNode;
            }
            curr.next = newNode;
        }
    }

    // --- DELETE OPERATIONS ---
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        head = head.next;
        head.prev = null; // Remove reference to old head
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }

        Node<T> curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        // curr is now the last node
        curr.prev.next = null; // Go back one step and cut the link forward
    }

    public void deleteAt(int index) {
        if (head == null || index < 0) {
            System.out.println("Invalid operation.");
            return;
        }
        if (index == 0) {
            deleteFirst();
            return;
        }

        Node<T> curr = head;
        for (int i = 0; i < index; i++) {
            if (curr == null) {
                System.out.println("Index out of bounds.");
                return;
            }
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println("Index out of bounds.");
            return;
        }

        // Wiring around the node to delete
        if (curr.prev != null) {
            curr.prev.next = curr.next;
        }
        if (curr.next != null) {
            curr.next.prev = curr.prev;
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node<T> curr = head;
        System.out.print("null <- "); // Visual indicator for start
        while (curr != null) {
            System.out.print(curr.data + (curr.next != null ? " <-> " : " -> "));
            curr = curr.next;
        }
        System.out.println("null");
    }

    // --- INTERACTIVE MAIN METHOD ---
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("--- Doubly Linked List Menu ---");

        while (running) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add First");
            System.out.println("2. Add Last");
            System.out.println("3. Add At Position");
            System.out.println("4. Delete First");
            System.out.println("5. Delete Last");
            System.out.println("6. Delete At Position");
            System.out.println("7. Print List");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            int data, index;

            switch (choice) {
                case 1:
                    System.out.print("Enter number to add at start: ");
                    data = sc.nextInt();
                    list.addFirst(data);
                    break;
                case 2:
                    System.out.print("Enter number to add at end: ");
                    data = sc.nextInt();
                    list.addLast(data);
                    break;
                case 3:
                    System.out.print("Enter index: ");
                    index = sc.nextInt();
                    System.out.print("Enter number: ");
                    data = sc.nextInt();
                    list.addAt(index, data);
                    break;
                case 4:
                    list.deleteFirst();
                    System.out.println("Deleted first node.");
                    break;
                case 5:
                    list.deleteLast();
                    System.out.println("Deleted last node.");
                    break;
                case 6:
                    System.out.print("Enter index to delete: ");
                    index = sc.nextInt();
                    list.deleteAt(index);
                    break;
                case 7:
                    // Loops back to print below
                    break;
                case 8:
                    running = false;
                    System.out.println("Exiting...");
                    continue;
                default:
                    System.out.println("Invalid choice, try again.");
            }

            if (running) {
                System.out.print("Current List: ");
                list.printList();
            }
        }
        sc.close();
    }
}