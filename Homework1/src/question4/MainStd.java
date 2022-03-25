
package question4;

import java.io.FileWriter;
import java.io.IOException;


public class MainStd {
    public static void main(String[] args) throws IOException {
        Student students[] = new Student[5]; 
        students[0] = new ItStudent(60, 40, 60, 5, "tigger", "MM");
        students[1] = new ItStudent(30, 25, 70, 2, "ahmed", "AI");
        students[2] = new ArtStudent(50, 30, 50, 3, "salem", "ART");
        students[3] = new ArtStudent(33, 40, 60, 4, "mahmoud", "ART");
        students[4] = new ItStudent(25, 28, 55, 1, "mohammed", "SE");
        System.out.println("Before sorting the students");
        
        for(Student student: students){
            System.out.println(student.getGrade());
        }
        
        System.out.println("After sorting the students"); 
        
        Student.sortStudent(students);        
        for(Student student: students){
            System.out.println(student.getGrade());
        }      
        FileWriter fileWriter = new FileWriter("./src/question4/students.txt", true);
        try{
            for(Student student : students){
                fileWriter.write(student.getId() + " "
                          + student.getName() + " "
                          + student.getMajor() + " "
                          + student.getGrade()+ "\n");
            }
            fileWriter.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
