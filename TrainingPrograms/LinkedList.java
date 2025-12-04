import java.util.Scanner;

public class LinkedList<T> {

    // --- Node Structure ---
    public static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    // --- ADD OPERATIONS ---
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
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
            newNode.next = curr.next;
            curr.next = newNode;
        }
    }

    // --- DELETE OPERATIONS ---
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
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
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
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
        for (int i = 0; i < index - 1; i++) {
            if (curr.next == null) {
                System.out.println("Index out of bounds.");
                return;
            }
            curr = curr.next;
        }

        if (curr.next == null) {
            System.out.println("Index out of bounds.");
        } else {
            curr.next = curr.next.next;
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node<T> curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // --- INTERACTIVE MAIN METHOD ---
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("--- Linked List Menu ---");

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
                    // Just print (loops back to printList below anyway)
                    break;
                case 8:
                    running = false;
                    System.out.println("Exiting...");
                    continue; // Skip the final printList
                default:
                    System.out.println("Invalid choice, try again.");
            }

            // Print the list state after every operation
            if (running) {
                System.out.print("Current List: ");
                list.printList();
            }
        }
        sc.close();
    }
}