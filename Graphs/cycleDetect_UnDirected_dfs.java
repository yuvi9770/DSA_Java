package Graphs;

import java.util.ArrayList;

public class cycleDetect_UnDirected_dfs {
    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        // graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 3, 1));
    }

    public static boolean dfsHelper(ArrayList<Edge> graph[], boolean vis[], int curr, int parent){
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // case 1 : neighbour is visited but curr != parent
            if (vis[e.dest] && e.dest != parent) {
                return true;
            }
            // case 2 : neighbour is visited and curr = parent (do nothing -> continue)

            // case 3 : neighbour is not visited
            else if (!vis[e.dest]) {
                if (dfsHelper(graph, vis, e.dest, curr))
                    return true;
            }
        }

        return false;
    }

    public static boolean dfs(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (dfsHelper(graph, vis, i, -1)) { // if any one component is true then return
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        System.out.println(dfs(graph));
    }
}