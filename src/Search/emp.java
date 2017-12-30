package Search;

public class emp {

    String id;
    String name;
    String date;
    String salary;
    String course;

    public emp(String id, String name, String date, String salary, String course) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.salary = salary;
        this.course = course;

    }

   

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getSalary() {
        return salary;
    }

    public String getCourse() {
        return course;
    }

}
