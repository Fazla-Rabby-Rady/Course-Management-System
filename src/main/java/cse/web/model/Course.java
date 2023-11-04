package cse.web.model;

public class Course {

    private String id;
    private String courseCode;
    private String courseName;
    private String courseTeacher;

    public Course() {
    }
    public Course(String id, String courseCode, String courseName, String courseTeacher) {
        this.id = id;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseTeacher = courseTeacher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }



}
