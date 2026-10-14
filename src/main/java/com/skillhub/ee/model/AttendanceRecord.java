package com.skillhub.ee.model;

import java.time.LocalDateTime;

public class AttendanceRecord {

    private String recordId;
    private String studentId;
    private String courseId;
    private LocalDateTime date;

    public AttendanceRecord(String recordId, String studentId, String courseId, LocalDateTime date) {
        this.recordId = recordId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.date = date;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
