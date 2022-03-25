package question4;

abstract public class Student {

    private int id;
    private String name;
    private String major;
    private double grade;

    public Student(int id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public static void sortStudent(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if(students[i].getGrade() < students[j].getGrade()){
                    Student temp = students[i];
                    students[i]=students[j];
                    students[j] = temp;
                }
            }
        }
    }
    
    
}
