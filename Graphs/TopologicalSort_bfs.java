package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort_bfs {
    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));
    }

    public static void calcIndeg(ArrayList<Edge> graph[], int indeg[]){
        for (int i = 0; i < graph.length; i++) {
            int curr = i;

            for (int j = 0; j < graph[curr].size(); j++) {
                Edge e = graph[curr].get(j);
                indeg[e.dest]++;
            }
        }
    }
    // kahn's Algo
    public static void bfs(ArrayList<Edge> graph[]){
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);

        Queue<Integer> q  = new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) 
                q.add(i);
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;

                if (indeg[e.dest] == 0) q.add(e.dest);
            }
        }
    }

    public static void main(String[] args) {
        int v = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        
        createGraph(graph);

        bfs(graph);
    }
}