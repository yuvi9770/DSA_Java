package Graphs;

import java.util.ArrayList;

public class BellmanFordAlgoUsingArrayList {
    public static void createGraph(ArrayList<Edge> graph){
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
        graph.add(new Edge(1, 2, -4));
        graph.add(new Edge(2, 3, 2));
        graph.add(new Edge(3, 4, 4));
        graph.add(new Edge(4, 1, -1));
    }

    public static void bellman(ArrayList<Edge> graph, int src, int vlen){
        int dist[] = new int[vlen];
        for (int i = 0; i < dist.length; i++) {
            if (i != src)
                dist[i] = Integer.MAX_VALUE;
        }
        boolean updated;

        // time : O(V*E)
        for (int i = 0; i < vlen-1; i++) {
            updated = false;
            // iterate edges - O(E)
            for (int j = 0; j < graph.size(); j++) {
                    Edge e = graph.get(j);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    // relaxation
                    if (dist[u]!= Integer.MAX_VALUE && dist[u]+wt < dist[v]) {
                        dist[v] = dist[u]+wt;
                        updated = true;
                    }
            }

            if (!updated) break;
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i]+ " ");
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph = new ArrayList<>();
        
        createGraph(graph);
        bellman(graph, 0, v);
    }
}