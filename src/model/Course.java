package model;

public class Course {
    private int id;
    private String name;
    private String instructor;
    private int duration;

    public Course(int id, String name, String instructor, int duration) {
        this.id = id;
        this.name = name;
        this.instructor = instructor;
        this.duration = duration;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getInstructor() { return instructor; }
    public int getDuration() { return duration; }
}