package Graphs;

import java.util.ArrayList;

public class cycleDetect_Directed_dfs {
    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 0, 1));
    }

    public static void createGraph2(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 3, 1));
    }

    public static boolean dfsHelper(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[]){
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (stack[e.dest]) { //cycle
                return true;
            }

            if (!vis[e.dest] && dfsHelper(graph, e.dest, vis, stack)) {
                return true;
            }
        }

        stack[curr] = false;
        return false;
    }

    public static boolean dfs(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];

        boolean stack[] = new boolean[graph.length]; //track node locally whether there path is same or not

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (dfsHelper(graph, i, vis, stack)) { // if any one component is true then return
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int v = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        
        createGraph(graph);
        System.out.println(dfs(graph));

        createGraph2(graph);
        System.out.println(dfs(graph));
    }
}