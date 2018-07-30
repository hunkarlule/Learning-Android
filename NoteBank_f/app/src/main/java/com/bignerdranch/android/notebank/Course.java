package com.bignerdranch.android.notebank;

import java.util.UUID;

public class Course {

    private UUID mCourseId;
    private  String mCourseTitle;

    public Course(String courseTitle) {
        mCourseId = UUID.randomUUID();
            mCourseTitle = courseTitle;
    }

    public UUID getCourseId() {
        return mCourseId;
    }

//    public void setCourseId(int courseId) {
//        mCourseId = courseId;
//    }

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
