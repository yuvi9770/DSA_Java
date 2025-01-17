package Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

class cell implements Comparable<cell>{
    int row, col, cost;

    public cell(int row, int col, int cost) {
        this.row = row;
        this.col = col;
        this.cost = cost;
    }

    @Override
    public int compareTo(cell other){
        return this.cost - other.cost;
    }
}

public class MiniEffortPath {

    public static int minPath(int grid[][]){
        int rows = grid.length;
        int cols = grid[0].length;
        int minCost[][] = new int[rows][cols];

        int dRow[] = {0,1,0,-1};
        int dCol[] = {1,0,-1,0};

        // fill the 2-D Array
        for (int i = 0; i < rows; i++) {
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
        }

        // Add first value to Queue
        PriorityQueue<cell> pq = new PriorityQueue<>();
        pq.add(new cell(0, 0, grid[0][0]));
        minCost[0][0] = grid[0][0];

        while (!pq.isEmpty()) {
            cell curr = pq.poll();

            int r = curr.row;
            int c = curr.col;
            int currCost = curr.cost;

            if (r == rows-1 && c ==cols-1) {
                return currCost;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = r + dRow[i];
                int newCol = c + dCol[i];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    int newCost = currCost + grid[newRow][newCol];

                    if (newCost < minCost[newRow][newCol]) {
                        minCost[newRow][newCol] = newCost;
                        pq.add(new cell(newRow, newCol, newCost)); 
                    }
                    
                }
            }
        }

        return minCost[rows-1][cols-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{31, 100, 65, 12, 18},
                        {10, 13, 47, 157, 6},
                        {100, 113, 174, 11, 33},
                        {88, 124, 41, 20, 140},
                        {99, 32, 111, 41, 20}};
        
        int result = minPath(grid);
        System.out.println(result);
    }
}