import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class GraphMatrix {
    private int[][] adjMatrix; 
    private int numVertices;

    public GraphMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1;
    }

    // Method to print the adjacency matrix
    public void printMatrix() {
        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // BFS traversal method
    public void BFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true; 
        queue.add(startVertex);

        System.out.println("\nBFS Traversal:");
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true; 
                    queue.add(i);
                }
            }
        }
        System.out.println();
    }

    public void DFS(int startVertex) {
        boolean[] visited = new boolean[numVertices]; 
        
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        visited[startVertex] = true;
        stack.push(startVertex);

        System.out.println("\nDFS Traversal:");
        while (!stack.isEmpty()) {
            int vertex = stack.pop(); // Pop the top vertex
            System.out.print(vertex + " ");

            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GraphMatrix graph = new GraphMatrix(9); // Create a graph with 9 vertices (0-8)

        // Add edges
        graph.addEdge(0, 1); // A-B
        graph.addEdge(0, 3); // A-D
        graph.addEdge(0, 4); // A-E
        graph.addEdge(4, 6); // E-G
        graph.addEdge(1, 2); // B-C
        graph.addEdge(1, 5); // B-F
        graph.addEdge(3, 6); // D-G
        graph.addEdge(6, 7); // G-H
        graph.addEdge(7, 8); // H-I

        graph.printMatrix();

        graph.BFS(0);
        graph.DFS(0);
    }
}