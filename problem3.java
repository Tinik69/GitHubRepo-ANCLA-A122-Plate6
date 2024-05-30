/**Write a java program that will determine if a graph has a cycle or not. */
import java.util.*;

public class problem3 { 
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print("Enter the number of vertices: ");
        int numofVertices = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();
        List<int[]> edges = new ArrayList<>();
        System.out.println("Enter the edges:");
        for (int i = 0; i < numEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            edges.add(new int[] { vertex1 - 1, vertex2 - 1 });
        }

        boolean hasCycle = hasCycle(numofVertices, edges);
        if (hasCycle == true){
            System.out.println("Graph has a cycle");
        } else{
            System.out.println("Graph has no cycle");
        }
        
        scanner.close();
    }
    private static int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }
    private static boolean hasCycle(int numofVertices, List<int[]> edges) {
        int[] parent = new int[numofVertices];
        for (int i = 0; i < numofVertices; i++){
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int root1 = find(parent, edge[0]);
            int root2 = find(parent, edge[1]);
            if (root1 == root2)
                return true;
            parent[root1] = root2;
        }
        return false;
    }
}