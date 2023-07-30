package com.mainpackage.customlistviewadapter;

public class CoursesModelClass {
    private String courseName;
    private int iconImg;

    public CoursesModelClass(String courseName, int iconImg) {
        this.courseName = courseName;
        this.iconImg = iconImg;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getIconImg() {
        return iconImg;
    }

    public void setIconImg(int iconImg) {
        this.iconImg = iconImg;
    }
}
