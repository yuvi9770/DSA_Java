package Graphs;

import java.util.ArrayList;;

public class ArticulationPoint {
    //use to find out Articulation Point in Graph - Tarjan's Algo
    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));
        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[4].add(new Edge(4, 3, 1));
    }


    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int low[], boolean vis[], int time, boolean ap[]){
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if (neigh == par) {
                continue;

            }else if (!vis[neigh]) {
                dfs(graph, neigh, curr, dt, low, vis, time,ap);
                low[curr] = Math.min(low[curr], low[neigh]);
                if (par != -1 && dt[curr] <= low[neigh]) {
                    ap[curr] = true;
                }
                children++;

            }else{ //Back Edge
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }

        if (par == -1 && children > 1) {
            ap[curr] = true;
        }
    }

    public static void getAP(ArrayList<Edge> graph[], int v){
        int dt[] = new int[v];
        int low[] = new int[v];
        int time = 0;
        boolean vis[] = new boolean[v];
        boolean ap[] = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, dt, low, vis, time, ap);
            }
        }

        for (int i = 0; i < v; i++) {
            if (ap[i])
                System.out.println("AP : " + i);
        }
    }

    public static void main(String[] args) {
        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        getAP(graph, v);
    }
}