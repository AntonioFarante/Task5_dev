package ClassesForSqlQuery;

public class LongestProject {
    private String project;
    private int duration;

    public LongestProject(String project, int duration) {
        this.project = project;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "project " + project +
                ", duration " + duration + " months" +
                '}';
    }
}
