package Graphs;

import java.util.ArrayList;

public class AllPathFromSrcToTarget_Directed {
    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3, 1));

        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));
    }

    public static void printPath(ArrayList<Edge> graph[], int src, int dest, StringBuilder path){
        if (src == dest) {
            System.out.println(path.append(src));

            path.deleteCharAt(path.length()-1);
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);

            printPath(graph, e.dest, dest, path.append(src));
            path.deleteCharAt(path.length()-1);
        }
    }

    public static void main(String[] args) {
        int v = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        
        createGraph(graph);

        printPath(graph, 5, 1, new StringBuilder());
    }
}