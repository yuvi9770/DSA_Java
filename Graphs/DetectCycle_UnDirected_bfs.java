package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycle_UnDirected_bfs {
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

    private static class pair4{
        int node;
        int parent;
        public pair4(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public static boolean bfsHelper(ArrayList<Edge> graph[], boolean vis[], int start, int parent){
        Queue<pair4> q = new LinkedList<>();
        q.add(new pair4(start, parent));

        while (!q.isEmpty()) {
            pair4 currNode = q.remove();
            int curr = currNode.node;
            int par = currNode.parent;

            if (!vis[curr]) {
                vis[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);

                    if (vis[e.dest] && par != e.dest) return true;

                    else if (!vis[e.dest]) 
                        q.add(new pair4(e.dest, curr));
                }
            }
            
        }        

        return false;
    }

    public static boolean bfs(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (bfsHelper(graph, vis, i, -1)) { // if any one component is true then return
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

        System.out.println(bfs(graph));
    }
}
