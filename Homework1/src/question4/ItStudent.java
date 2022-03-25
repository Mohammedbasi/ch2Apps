package question4;

public class ItStudent extends Student {

    private double mid;
    private double project;
    private double finall;

    public ItStudent(double mid, double project, double finall,
            int id, String name, String major) {
        super(id, name, major);
        this.mid = mid;
        this.project = project;
        this.finall = finall;
        super.setGrade(((mid * 0.30) + (project * 0.30) + (finall * 0.40)));
    }
}
