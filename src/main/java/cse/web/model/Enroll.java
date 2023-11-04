package cse.web.model;

public class Enroll {

    private String id;
    private String courseCode;
    private String studentId;

    public Enroll() {
    }

    public Enroll(String id, String courseCode, String studentId) {
        this.id = id;
        this.courseCode = courseCode;
        this.studentId = studentId;
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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
