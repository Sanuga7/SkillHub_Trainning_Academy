package com.skillhub.ee.model;

public class Course {

    private String courseId;
    private String courseName;
    private int capacity;
    private String trainerId;

    public Course(String courseId, String courseName, int capacity, String trainerId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.capacity = capacity;
        this.trainerId = trainerId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
