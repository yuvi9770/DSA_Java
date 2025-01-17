package Stacks;

import java.util.Stack;

public class Simplify_Path {
    public static String paths(String path){
        Stack<String> s = new Stack<>();
        StringBuilder res = new StringBuilder();
        String p[] = path.split("/");

        for (int i = 0; i < p.length; i++) {
            if (!s.isEmpty() && p[i].equals("..")) {
                s.pop();

            }else if (!p[i].equals("") && !p[i].equals(".") && !p[i].equals("..")) {
                s.push(p[i]);
            }
        }

        if (s.isEmpty()) return "/";
        while (!s.isEmpty()) {
            res.insert(0, s.pop()).insert(0, "/");
        }
        // for (String dir : s) {
        //     res.append("/").append(dir);
        // }
       
        return res.toString();
    }
    public static void main(String[] args) {
        String p1 = "/../";
        String p2 = "/home//foo/";
        String p3 = "/home/user/Documents/../Pictures";
        String p4 = "/.../a/../b/c/../d/./";
        
        System.out.println(paths(p1));
        System.out.println(paths(p2));
        System.out.println(paths(p3));
        System.out.println(paths(p4));
    }
}