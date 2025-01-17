package OOPS;

public class copyConstructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Rama";
        s1.roll = 564;
        s1.password = "abcd";
        
        s1.marks[0] = 85;
        s1.marks[1] = 95;
        s1.marks[2] = 79;

        Student s2 = new Student(s1);
        s2.password = "xyz";
        s1.marks[1] = 100;

        for (int mark : s2.marks) {
            System.out.println(mark);
        }
    }
}

class Student{
    int roll;
    String name;
    String password;
    int marks[];

    Student(){
        marks = new int[3];
    }

    // copy Constructor
    Student(Student s1){
        this.name = s1.name;
        this.roll = s1.roll;
        // Shallow copy (it reflect new changes)
        this.marks = s1.marks; 

        // Create a new array for deep copy(if changes are made after coping then It don't reflect new changes)
        // marks = new int[3]; 
        // for (int i = 0; i < 3; i++) {
        //     this.marks[i] = s1.marks[i]; // Copy each element
        // }
    }
}