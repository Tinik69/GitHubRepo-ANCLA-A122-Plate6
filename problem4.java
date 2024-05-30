//*  Write a java program, given the pair of vertex associated to the edges of an undirected graph, it will output the degree of each vertex.
import java.util.*;

public class problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        HashMap<Integer, Integer> degreeMap = new HashMap<>();
        
        System.out.print("Enter the number of edges: ");
        int numberOfEdges = scanner.nextInt();
        
        System.out.println("Enter the pair of vertices:");
        for (int i = 0; i < numberOfEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            
            degreeMap.put(vertex1, degreeMap.getOrDefault(vertex1, 0) + 1);
            degreeMap.put(vertex2, degreeMap.getOrDefault(vertex2, 0) + 1);
        }
        
        scanner.close();

        System.out.println("Degree of each vertex:");
        for (Map.Entry<Integer, Integer> entry : degreeMap.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
