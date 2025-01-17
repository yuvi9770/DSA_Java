package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class info{
    int vertex;
    int cost;
    int stops;

    public info(int vertex, int cost, int stops) {
        this.vertex = vertex;
        this.cost = cost;
        this.stops = stops;
    }
}

public class CheapestStopWithK_Stops {
    public static void createGraph(int flights[][], ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }


    public static int cheapFlight(int flights[][], int n, int src, int dest, int k){
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != src)
                dist[i] = Integer.MAX_VALUE;
        }

        Queue<info> q = new LinkedList<>();
        q.add(new info(src, 0, 0));

        while (!q.isEmpty()) {
            info curr = q.remove();

            if (curr.stops > k) break;

            for (int i = 0; i < graph[curr.vertex].size(); i++) {
                Edge e = graph[curr.vertex].get(i);
                // int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                // dist[u]+wt < dist[v] here is an edge case where (same src with different cost exists) if we get dist[u] shorter then update globally(may the value of k exceed) and it conflict 
                if ((curr.cost+wt < dist[v]) && curr.stops <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new info(v, dist[v], curr.stops+1));
                }
            }
        }

        return (dist[dest]==Integer.MAX_VALUE) ? -1 : dist[dest];
    }

    public static void main(String[] args) {
        int n = 4;
        int flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, dest = 3, k = 1;

        int res = cheapFlight(flights, n, src, dest, k);
        System.out.println(res);
    }
}