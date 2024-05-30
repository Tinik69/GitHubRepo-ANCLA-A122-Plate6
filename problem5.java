/*Write a java program that receives a list of edges of a simple graph and determine whether the graph is bipartite. */
import java.util.*;

public class problem5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();
        System.out.println("Enter the edges of the graph:");
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < numEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edges.add(new Edge(u, v));
        }
        scanner.close();

        problem5 checker = new problem5();
        boolean isBipartite = checker.isGraphBipartite(edges, numVertices);
        if (isBipartite) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }

    public boolean isGraphBipartite(List<Edge> edges, int numVertices) {
        List<Integer> color = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            color.add(-1);
        }

        for (Edge edge : edges) {
            if (color.get(edge.u) == -1) {
                color.set(edge.u, 0);
            }
            if (color.get(edge.v) == -1) {
                color.set(edge.v, 1 - color.get(edge.u));
            } else if (color.get(edge.u) == color.get(edge.v)) {
                return false;
            }
        }
        return true;
    }

    private static class Edge {
        int u;
        int v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }
}