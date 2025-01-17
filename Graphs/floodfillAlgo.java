package Graphs;

// import java.util.LinkedList;
// import java.util.Queue;

public class floodfillAlgo {
    public static void dfs(int[][] image, int sr, int sc, int color, int orgCol) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != orgCol) {
            return;
        }
        // vis[sr][sc] = true;
        image[sr][sc] = color;

        //left
        dfs(image, sr, sc-1, color, orgCol);
        //right
        dfs(image, sr, sc+1, color, orgCol);
        //up
        dfs(image, sr-1, sc, color, orgCol);
        //down
        dfs(image, sr+1, sc, color, orgCol);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // boolean vis[][] = new boolean[image.length][image[0].length];
        if (image[sr][sc] == color) return image; // base case

        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    
    public static void main(String[] args) {
        int image[][] = {{1,1,1},{1,1,0},{1,0,1}};
        
        int res[][] = floodFill(image, 1, 1, 2);

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}


// class bfs{
//     private static class pair3{
//         int row, col;
//         public pair3(int row, int col) {
//             this.row = row;
//             this.col = col;
//         }
//     }

//     public static boolean isSafe(int sr, int sc, int n, int m){
//         if (sr >= 0 && sr < n && sc >= 0 && sc < m) {
//             return true;
//         }
//         return false;
//     }

//     public static int[][] flood(int[][] image, int sr, int sc, int color) {
//         if (image[sr][sc] == color) return image; // base case

//         int n = image.length;
//         int m = image[0].length;
//         int orgCol = image[sr][sc];

//         Queue<pair3> q = new LinkedList<>();
//         q.add(new pair3(sr, sc));
//         image[sr][sc] = color;

//         while (!q.isEmpty()) {
//             pair3 curr = q.remove();
//             int r = curr.row;
//             int c = curr.col;

//             int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};
//             for (int i = 0; i < 4; i++) {
//                 int nr = r + dir[i][0];
//                 int nc = c + dir[i][1];

//                 if (isSafe(nr, nc, n, m) && image[nr][nc] == orgCol) {
//                     q.add(new pair3(nr, nc));
//                     image[nr][nc] = color;
//                 }
//             }
//         }
//         return image;
//     }
// }