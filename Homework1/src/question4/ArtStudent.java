package question4;

public class ArtStudent extends Student {

    private double mid;
    private double report;
    private double finall;

    public ArtStudent(double mid, double report, double finall,
            int id, String name, String major) {
        super(id, name, major);
        this.mid = mid;
        this.report = report;
        this.finall = finall;
        super.setGrade(((mid * 0.40) + (report * 0.10) + (finall * 0.50)));
    }
}
