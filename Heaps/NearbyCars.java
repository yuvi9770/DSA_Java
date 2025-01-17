package Heaps;

import java.util.PriorityQueue;

class Point implements Comparable<Point>{
    int x;
    int y;
    int distSq;
    int idx;

    public Point(int x, int y, int distSq, int idx) {
        this.x = x;
        this.y = y;
        this.distSq = distSq;
        this.idx = idx;
    }

    @Override
    public int compareTo(Point p2){
        return this.distSq - p2.distSq;
    }
}

public class NearbyCars {
    
    public static void solve(int pts[][], int k){
        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int i = 0; i < pts.length; i++) {
            int distSq = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];

            pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("C" + pq.remove().idx);
        }
    }

    public static void main(String[] args) {
        int pts[][] = {{3,3}, {5,-1}, {-2,4}};
        int k =2;
        solve(pts, k);
    }
}