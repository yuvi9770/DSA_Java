package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair2{
    int vertex;
    int cost;
    public Pair2(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }
}

public class PrimAlgo {
    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
        
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    public static void prims(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];

        PriorityQueue<Pair2> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Pair2(0, 0));

        int finalCost = 0; // MST cost/weight

        while (!pq.isEmpty()) {
            Pair2 curr = pq.remove();
            if (!vis[curr.vertex]) {
                vis[curr.vertex] = true;
                finalCost += curr.cost;

                for (int i = 0; i < graph[curr.vertex].size(); i++) {
                    Edge e = graph[curr.vertex].get(i);
                    pq.add(new Pair2(e.dest, e.wt));
                }
            }
        }

        System.out.println("final(min) cost : " + finalCost);
    }

    public static void main(String[] args) {
        int v = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        
        createGraph(graph);
        prims(graph);
    }
}