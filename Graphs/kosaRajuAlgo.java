package Graphs;

import java.util.*;

public class kosaRajuAlgo {
    //use to find out Strongly Connected Components - Kosaraju's Algo
    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[2].add(new Edge(2, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
    }

    public static void topSort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s){
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e  = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSort(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static ArrayList<Edge>[] createTranspose(ArrayList<Edge>graph[], int v){
        @SuppressWarnings("unchecked")
        ArrayList<Edge> transpose[] = new ArrayList[v];
        for (int i = 0; i < graph.length; i++) {
            transpose[i] = new ArrayList<>();
        }

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src, 1)); //reverse edge
            }
        }

        return transpose;
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
        vis[curr] = true;
        System.out.print(curr + " ");

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e  =graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void kosaRaju(ArrayList<Edge> graph[], int v){
        //Step 1
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                topSort(graph, i, vis, s);
            }
        }

        //step 2
        ArrayList<Edge>[] transpose = createTranspose(graph, v);
        vis = new boolean[v];

        //step 3
        int scc_Count = 0;
        
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!vis[curr]) {
                System.out.print("Scc -> ");
                dfs(transpose, curr, vis);
                System.out.println();
                scc_Count++;
            }
        }
        System.out.println(scc_Count);
    }

    public static void main(String[] args) {
        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        kosaRaju(graph, v);
    }
}