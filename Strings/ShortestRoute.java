package Strings;

public class ShortestRoute {
    public static void getpath(String path){
        int x = 0 , y = 0;
        for (int i = 0; i < path.length(); i++) {
            char dir = path.charAt(i);

            if (dir == 'N') {
                y++;
            } else if (dir == 'S') {
                y--;
            }else if (dir == 'E') {
                x++;
            }else if(dir == 'W'){
                x--;
            }
        }
        int x2 = x*x , y2 = y*y;
        System.out.println(Math.sqrt(x2+y2));
    }
    public static void main(String[] args) {
        String path ="WNEENESENNN";
        getpath(path);
    }
}