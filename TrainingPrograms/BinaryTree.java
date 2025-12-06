import java.util.Scanner;

public class BinaryTree<T extends Comparable<T>> {

    // --- Node Structure ---
    public static class Node<T> {
        public T data;
        public Node<T> left;
        public Node<T> right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node<T> root;

    public BinaryTree() {
        this.root = null;
    }

    // --- INSERT OPERATIONS (BST) ---
    public void insert(T data) {
        root = insertRecursive(root, data);
    }

    private Node<T> insertRecursive(Node<T> current, T data) {
        if (current == null) {
            return new Node<>(data);
        }

        if (data.compareTo(current.data) < 0) {
            current.left = insertRecursive(current.left, data);
        } else if (data.compareTo(current.data) > 0) {
            current.right = insertRecursive(current.right, data);
        }
        return current;
    }

    // --- SEARCH OPERATION ---
    public boolean search(T data) {
        return searchRecursive(root, data);
    }

    private boolean searchRecursive(Node<T> current, T data) {
        if (current == null) {
            return false;
        }
        if (data.compareTo(current.data) == 0) {
            return true;
        }
        return data.compareTo(current.data) < 0 ?
            searchRecursive(current.left, data) :
            searchRecursive(current.right, data);
    }

    // --- DELETE OPERATION ---
    public void delete(T data) {
        root = deleteRecursive(root, data);
    }

    private Node<T> deleteRecursive(Node<T> current, T data) {
        if (current == null) {
            return null;
        }

        if (data.compareTo(current.data) < 0) {
            current.left = deleteRecursive(current.left, data);
        } else if (data.compareTo(current.data) > 0) {
            current.right = deleteRecursive(current.right, data);
        } else {
            // Node to delete found
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            } else {
                // Node has two children
                Node<T> successor = findMin(current.right);
                current.data = successor.data;
                current.right = deleteRecursive(current.right, successor.data);
            }
        }
        return current;
    }

    private Node<T> findMin(Node<T> current) {
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // --- TRAVERSAL OPERATIONS ---
    public void inorder() {
        System.out.print("Inorder: ");
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(Node<T> current) {
        if (current != null) {
            inorderRecursive(current.left);
            System.out.print(current.data + " ");
            inorderRecursive(current.right);
        }
    }

    public void preorder() {
        System.out.print("Preorder: ");
        preorderRecursive(root);
        System.out.println();
    }

    private void preorderRecursive(Node<T> current) {
        if (current != null) {
            System.out.print(current.data + " ");
            preorderRecursive(current.left);
            preorderRecursive(current.right);
        }
    }

    public void postorder() {
        System.out.print("Postorder: ");
        postorderRecursive(root);
        System.out.println();
    }

    private void postorderRecursive(Node<T> current) {
        if (current != null) {
            postorderRecursive(current.left);
            postorderRecursive(current.right);
            System.out.print(current.data + " ");
        }
    }

    // --- TREE HEIGHT ---
    public int height() {
        return heightRecursive(root);
    }

    private int heightRecursive(Node<T> current) {
        if (current == null) {
            return 0;
        }
        return 1 + Math.max(heightRecursive(current.left), heightRecursive(current.right));
    }

    // --- PRINT TREE STATE ---
    public void printTree() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        System.out.println("Tree traversals:");
        inorder();
        preorder();
        postorder();
        System.out.println("Height: " + height());
    }

    // --- INTERACTIVE MAIN METHOD ---
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("--- Binary Search Tree Menu ---");

        while (running) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Insert Node");
            System.out.println("2. Search Node");
            System.out.println("3. Delete Node");
            System.out.println("4. Inorder Traversal");
            System.out.println("5. Preorder Traversal");
            System.out.println("6. Postorder Traversal");
            System.out.println("7. Print Tree State");
            System.out.println("8. Tree Height");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            int data;

            switch (choice) {
                case 1:
                    System.out.print("Enter number to insert: ");
                    data = sc.nextInt();
                    tree.insert(data);
                    System.out.println(data + " inserted successfully!");
                    break;
                case 2:
                    System.out.print("Enter number to search: ");
                    data = sc.nextInt();
                    if (tree.search(data)) {
                        System.out.println(data + " found in tree!");
                    } else {
                        System.out.println(data + " not found in tree.");
                    }
                    break;
                case 3:
                    System.out.print("Enter number to delete: ");
                    data = sc.nextInt();
                    if (tree.search(data)) {
                        tree.delete(data);
                        System.out.println(data + " deleted successfully!");
                    } else {
                        System.out.println(data + " not found in tree.");
                    }
                    break;
                case 4:
                    tree.inorder();
                    break;
                case 5:
                    tree.preorder();
                    break;
                case 6:
                    tree.postorder();
                    break;
                case 7:
                    tree.printTree();
                    break;
                case 8:
                    System.out.println("Tree height: " + tree.height());
                    break;
                case 9:
                    running = false;
                    System.out.println("Exiting...");
                    continue;
                default:
                    System.out.println("Invalid choice, try again.");
            }

            // Print tree state after most operations
            if (running && choice != 4 && choice != 5 && choice != 6 && choice != 8) {
                System.out.print("Current Tree: ");
                tree.printTree();
            }
        }
        sc.close();
    }
}
