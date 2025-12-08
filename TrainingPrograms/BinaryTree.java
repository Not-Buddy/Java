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


    public void delete2(T data) {
    root = deleteIterative(root, data);
}

private Node<T> deleteIterative(Node<T> root, T data) {
    Node<T> parent = null;
    Node<T> current = root;

    // Find the node to delete and its parent
    while (current != null && !current.data.equals(data)) {
        parent = current;
        if (data.compareTo(current.data) < 0) {
            current = current.left;
        } else {
            current = current.right;
        }
    }

    // If the node was not found
    if (current == null) {
        System.out.println("Node not found.");
        return root;
    }

    // Case 1: Node to delete has no children (leaf node)
    if (current.left == null && current.right == null) {
        if (current == root) {
            return null;
        }
        if (parent.left == current) {
            parent.left = null;
        } else {
            parent.right = null;
        }
    }
    // Case 2: Node to delete has one child
    else if (current.left == null || current.right == null) {
        Node<T> child = (current.left != null) ? current.left : current.right;
        if (current == root) {
            return child; // Replace root with its child
        }
        if (parent.left == current) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }
    // Case 3: Node to delete has two children
    else {
        Node<T> successor = findMin(current.right);
        T successorData = successor.data;
        deleteIterative(root, successorData); // Delete the successor
        current.data = successorData; // Replace current node's data with successor's data
    }

    return root;
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
            System.out.println("10. Delete Node (Iterative)");
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
                System.out.print("Enter number to delete (recursive): ");
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
            case 10:
                System.out.print("Enter number to delete (iterative): ");
                data = sc.nextInt();
                if (tree.search(data)) {
                    tree.delete2(data);
                    System.out.println(data + " deleted successfully (iterative)!");
                } else {
                    System.out.println(data + " not found in tree.");
                }
                break;
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
