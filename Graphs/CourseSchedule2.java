package Graphs;

import java.util.*;;

public class CourseSchedule2 {
    // Leetcode - 210
    class Solution {
        public void calc(int[][] prerequisites, int indeg[], int lenPre){
            for(int i = 0; i < lenPre; i++){
                int idx = prerequisites[i][0];
                indeg[idx]++;
            }
        }
    
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int indeg[] = new int[numCourses];
            int lenPre = prerequisites.length;
            calc(prerequisites, indeg, lenPre);
    
            int res[] = new int[numCourses];
            int idx = 0;
            Queue<Integer> q  = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (indeg[i] == 0) 
                    q.add(i);
            }
    
            while(!q.isEmpty()){
                int curr = q.remove();
                res[idx++] = curr;
    
                for(int i = 0; i < lenPre; i++){
                    if(curr == prerequisites[i][1]){
                        int index = prerequisites[i][0];
                        indeg[index]--;
    
                        if(indeg[index] == 0){
                            q.add(index);
                        }
                    }
                }
            }
    
            if(idx != numCourses){
                return new int[0];
            }
    
            return res;
        }
    }
}



class Solution {
    ArrayList<Integer> graph[];

    @SuppressWarnings("unchecked")

    public void CreateGraph(int numCourses){
        graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        CreateGraph(numCourses);

        int indeg[] = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];

            graph[pre].add(course);
            indeg[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) q.add(i);
        }

        int[] res = new int[numCourses];
        int idx = 0;

        while(!q.isEmpty()){
                int curr = q.remove();
                res[idx++] = curr;
    
                for(int i = 0; i < graph[curr].size(); i++){
                    int index = graph[curr].get(i);
                    indeg[index]--;

                    if(indeg[index] == 0) q.add(index);
                }
            }
    
            if(idx != numCourses){
                return new int[0];
            }
    
            return res;
    }
}