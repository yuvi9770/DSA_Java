package Graphs;

import java.util.PriorityQueue;

class info2{
    int dest;
    int cost;

    public info2(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }
}

public class ConnectingCities {

    public static int minCost(int cities[][]){
        boolean vis[] = new boolean[cities.length];

        PriorityQueue<info2> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new info2(0, 0));

        int finalCost = 0;

        while (!pq.isEmpty()) {
            info2 curr = pq.remove();

            if (!vis[curr.dest]) {
                vis[curr.dest] = true;
                finalCost += curr.cost;

                for (int i = 0; i < cities[curr.dest].length; i++) {
                    if (cities[curr.dest][i] != 0) {
                        pq.add(new info2(i, cities[curr.dest][i]));
                    }
                }
            }
        }

        return finalCost;
    }
    public static void main(String[] args) {
        int cities[][] = {{0,1,2,3,4},{1,0,5,0,7},{2,5,0,6,0},{3,0,6,0,0},{4,7,0,0,0}};

        int res = minCost(cities);
        System.out.println(res);
    }
}