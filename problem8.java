/**Write a Java program that checks whether two graphs are isomorphic or not, given a set of vertices. */

import java.util.*;
public class problem8 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        System.out.print("Enter the number of edges for the first graph: ");
        int numEdges1 = scanner.nextInt();
        List<int[]> edges1 = new ArrayList<>();
        System.out.println("Enter the edges for the first graph:");
        for (int i = 0; i < numEdges1; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            edges1.add(new int[] { (vertex1 - 1), (vertex2 - 1) });
        }

        System.out.print("Enter the number of edges for the second graph: ");
        int numEdges2 = scanner.nextInt();
        List<int[]> edges2 = new ArrayList<>();
        System.out.println("Enter the edges for the second graph:");
        for (int i = 0; i < numEdges2; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            edges2.add(new int[] { (vertex1 - 1), (vertex2 - 1) });
        }

        boolean isIsomorphic = areIsomorphic(vertices, edges1, edges2);
        if (isIsomorphic == true) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }
        scanner.close();
    }

    private static boolean areIsomorphic(int vertices, List<int[]> edges1, List<int[]> edges2) {
        if (edges1.size() != edges2.size())
            return false;

        int[][] adjMatrix1 = makeAdjMatrix(vertices, edges1);
        int[][] adjMatrix2 = makeAdjMatrix(vertices, edges2);

        return Arrays.deepEquals(adjMatrix1, adjMatrix2);
    }
    private static int[][] makeAdjMatrix(int vertices, List<int[]> edges) {
        int[][] adjMatrix = new int[vertices][vertices];
        for (int[] edge : edges) {
            adjMatrix[edge[0]][edge[1]]++;
        }
        return adjMatrix;
    }
}