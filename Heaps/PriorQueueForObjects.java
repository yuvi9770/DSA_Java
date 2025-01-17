package Heaps;

import java.util.PriorityQueue;

class Student implements Comparable<Student>{
    String name;
    int rank;

    public Student(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    @Override
    public int compareTo(Student s2){
        return this.rank - s2.rank;
    }
}

public class PriorQueueForObjects {
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student("A", 5));
        pq.add(new Student("B", 145));
        pq.add(new Student("C", 1));
        pq.add(new Student("D", 62));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + " -> " + pq.peek().rank);
            pq.remove();
        }
    }
}