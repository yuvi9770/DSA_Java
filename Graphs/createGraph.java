package Graphs;

import java.util.ArrayList;

public class createGraph {
    public static void main(String[] args) {
        int v= 5;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v]; // null -> empty arrayList

        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // vertex
        graph[0].add(new Edge(0, 1, 5));

        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));

        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        graph[4].add(new Edge(4, 2, 2));


        // 2's neighbours
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println(e.dest);
        }
    }
}