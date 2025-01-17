package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

class pair{
    int node;
    int path;
    public pair(int node, int path) {
        this.node = node;
        this.path = path;
    }
}
public class Dijkstra_Algorithm {
    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    public static void dijkstra(ArrayList<Edge> graph[], int src){
        int dist[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i != src)
                dist[i] = Integer.MAX_VALUE;
        }

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> a.path - b.path);
        pq.add(new pair(src, 0));

        while (!pq.isEmpty()) {
            pair curr = pq.remove();

            if (!vis[curr.node]) {
                vis[curr.node] = true;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u]+wt < dist[v]){
                        dist[v] = dist[u]+wt;
                        pq.add(new pair(v, dist[v]));
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void main(String[] args) {
        int v = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        
        createGraph(graph);

        dijkstra(graph, 0);
    }
}