/*Write a java program that accepts vertex pairs associated to the edges of an undirected graph and the number of times each edge appears as input. 
The program should construct an incidence matrix for the graph. */
import java.util.*;

public class problem7 {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int numofEdges = scanner.nextInt();
        List<int[]> edges = new ArrayList<>();
        System.out.println("Enter the edges (vertex1 vertex2):");
        for (int i = 0; i < numofEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edges.add(new int[] { u, v });
        }
        

        int[][] incMatrix = makeIncMatrix(vertices, edges);
        System.out.println("Incidence Matrix:");
        printMatrix(incMatrix);
        scanner.close();
    }

    private static int[][] makeIncMatrix(int vertices, List<int[]> edges) {
        int[][] incMatrix = new int[vertices][edges.size()];
        for (int i = 0; i < edges.size(); i++) {
            int[] edge = edges.get(i);
            incMatrix[edge[0]][i] = 1;
            if (edge[0] != edge[1]) {
                incMatrix[edge[1]][i] = 1;
            }
        }
        return incMatrix;
    }
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
