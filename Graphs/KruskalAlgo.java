package Graphs;

import java.util.ArrayList;
import java.util.Collections;

class dj{
    static int n = 4; // vertices
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init(){
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x){
        if (x == par[x]) {
            return x;
        }

        return par[x] = find(par[x]); // optimize by assign value and this decrease the height of tree
    }

    public static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA; // assign any as rank is same
            rank[parA]++;
            
        }
        else if (rank[parA] < rank[parB]) {
            par[parA] = parB;

        }else if (rank[parA] > rank[parB]) {
            par[parB] = parA;
        }
    }
}

public class KruskalAlgo {
    public static void createGraph(ArrayList<Edge> edges){
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0,2,15));
        edges.add(new Edge(0,3,30));
        edges.add(new Edge(1,3,40));
        edges.add(new Edge(2,3,50));
    }

    public static void krusMST(ArrayList<Edge> edges, int v){
        dj.init();
        Collections.sort(edges, (a,b) -> a.wt - b.wt);
        int minCost = 0;
        int count = 0;

        for (int i = 0; count < v-1; i++) {
            Edge e = edges.get(i);
            
            int parA = dj.find(e.src);
            int parB = dj.find(e.dest);

            if (parA != parB) {
                dj.union(e.src, e.dest);
                minCost += e.wt;
                count++;
            }
        }
        System.out.println("min Cost : " + minCost);
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);

        krusMST(edges, v);
    }
}