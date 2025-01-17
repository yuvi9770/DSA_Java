package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class BipartiteGraph {
    // in this we using graph coloring technique
    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        // graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 2, 1));
        // graph[4].add(new Edge(4, 3, 1));
    }

    public static boolean bfsHelper(ArrayList<Edge> graph[], int col[], int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        col[start] = 0;

        while (!q.isEmpty()) {
            int curr = q.remove();
            for (int j = 0; j < graph[curr].size(); j++) {
                Edge e = graph[curr].get(j);

                if (col[e.dest] == -1) {
                    int nextCol = col[curr] == 0 ? 1 : 0;
                    col[e.dest] = nextCol;
                    q.add(e.dest);

                }else if (col[e.dest] == col[curr]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean bfs(ArrayList<Edge> graph[]){
        int col[] = new int[graph.length];
        Arrays.fill(col, -1); // no color

        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                if (!bfsHelper(graph, col, i))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        System.out.println(bfs(graph));
    }
}

// public static boolean bfs(ArrayList<Edge> graph[]){
//     int col[] = new int[graph.length];
//     Arrays.fill(col, -1); // no color

//     Queue<Integer> q = new LinkedList<>();

//     for (int i = 0; i < graph.length; i++) {
//         if (col[i] == -1) {
//             q.add(i);
//             col[i] = 0;
            
//             while (!q.isEmpty()) {
//                 int curr = q.remove();
//                 for (int j = 0; j < graph[curr].size(); j++) {
//                     Edge e = graph[curr].get(j);

//                     if (col[e.dest] == -1) {
//                         int nextCol = col[curr] == 0 ? 1 : 0;
//                         col[e.dest] = nextCol;
//                         q.add(e.dest);

//                     }else if (col[e.dest] == col[curr]) {
//                         return false;
//                     }
//                 }
//             }
//         }
//     }

//     return true;
// }