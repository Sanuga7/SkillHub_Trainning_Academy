package com.skillhub.ee.model;

public class Enrolment {

    private String enrolmentId;
    private String courseId;
    private String studentId;

    public Enrolment(String enrolmentId, String courseId, String studentId) {
        this.enrolmentId = enrolmentId;
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public String getEnrolmentId() {
        return enrolmentId;
    }

    public void setEnrolmentId(String enrolmentId) {
        this.enrolmentId = enrolmentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
