/**Write a java program that accepts an adjacency matrix of a graph. The program should list the edges of this graph and give
the number of times each edge appears. */

import java.util.*;

public class problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        int[][] adjacencyMatrix = new int[vertices][vertices];

        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        
        Map<String, Integer> edgeCount = new HashMap<>();

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (adjacencyMatrix[i][j] > 0) {
                    String edge = "(" + (i+1) + ", " + (j+1) + ")";
                    edgeCount.put(edge, edgeCount.getOrDefault(edge, 0) + adjacencyMatrix[i][j]);
                }
            }
        }

        System.out.println("Edges and their counts:");
        for (Map.Entry<String, Integer> entry : edgeCount.entrySet()) {
            System.out.println(entry.getKey() + " appears " + entry.getValue() + " time(s)");
        }

        scanner.close();
    }
}
