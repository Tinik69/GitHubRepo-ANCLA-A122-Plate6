/** Write a java program that receives the vertex pairs associated to the edges of a graph, the program should construct an adjacency matrix for the graph. */
import java.util.*;

public class problem6 {
    private int[][] adjacencyMatrix;
    private int numberOfVertices;

    public problem6(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        adjacencyMatrix = new int[numberOfVertices][numberOfVertices];
    }

    public void addEdge(int vertex1, int vertex2) {
        adjacencyMatrix[vertex1][vertex2]++;
    }

    public void printAdjacencyMatrix() {
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numberOfVertices = scanner.nextInt();

        problem6 graph = new problem6(numberOfVertices);

        System.out.println("Enter the edges (format: vertex1 vertex2), type 'end' to stop:");
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("end")) {
                break;
            }
            int vertex1 = Integer.parseInt(input);
            int vertex2 = scanner.nextInt();
            graph.addEdge(vertex1, vertex2);
        }

        System.out.println("Adjacency Matrix:");
        graph.printAdjacencyMatrix();
        
        scanner.close();
    }
}
