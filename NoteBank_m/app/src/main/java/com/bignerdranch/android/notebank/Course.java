package com.bignerdranch.android.notebank;

public class Course {

    private  int mCourseId;
    private  String mCourseTitle;

    public Course(int courseId, String courseTitle) {
           mCourseId = courseId;
            mCourseTitle = courseTitle;
    }

    public int getCourseId() {
        return mCourseId;
    }

    public void setCourseId(int courseId) {
        mCourseId = courseId;
    }

    public String getCourseTitle() {
        return mCourseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        mCourseTitle = courseTitle;
    }

    @Override
    public String toString() {
        return "Course{" +
                "mCourseId=" + mCourseId +
                ", mCourseTitle='" + mCourseTitle + '\'' +
                '}';
    }
}
