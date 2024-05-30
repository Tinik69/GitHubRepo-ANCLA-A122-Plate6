/**Write a java program that receives a list of edges of a simple graph, the program should determine whether it is connected
and find the number of connected components if it is not connected. */
import java.util.*;

public class problem1 {
    private Map<Integer, List<Integer>> adjacencyList;
    private Set<Integer> visitedNodes;

    public problem1() {
        adjacencyList = new HashMap<>();
        visitedNodes = new HashSet<>();
    }

    public void addEdge(int node1, int node2) {
        adjacencyList.computeIfAbsent(node1, k -> new ArrayList<>()).add(node2);
        adjacencyList.computeIfAbsent(node2, k -> new ArrayList<>()).add(node1);
    }

    public void searchgraph(int startNode) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);
        visitedNodes.add(startNode);

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            for (int neighbor : adjacencyList.getOrDefault(currentNode, Collections.emptyList())) {
                if (!visitedNodes.contains(neighbor)) {
                    visitedNodes.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }
    }

    public boolean isConnected() {
        if (adjacencyList.isEmpty()) {
            return true; 
        }

        int startNode = adjacencyList.keySet().iterator().next();
        searchgraph(startNode);

        return visitedNodes.size() == adjacencyList.size();
    }

    public int countConnectedComponents() {
        visitedNodes.clear();
        int componentCount = 0;

        for (int node : adjacencyList.keySet()) {
            if (!visitedNodes.contains(node)) {
                searchgraph(node);
                componentCount++;
            }
        }

        return componentCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        problem1 graph = new problem1();

        System.out.print("Enter the number of edges: ");
        int numberOfEdges = scanner.nextInt();

        System.out.println("Enter the edges:");
        for (int i = 0; i < numberOfEdges; i++) {
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            graph.addEdge(node1, node2);
        }

        if (graph.isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            int components = graph.countConnectedComponents();
            System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " + components);
        }

        scanner.close();
    }
}
