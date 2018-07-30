package com.bignerdranch.android.notebank;

import java.util.UUID;

public class Note {
    private UUID mNoteId;
    private Course mCourse;
    private String mNoteTitle;
    private String mNoteText;

    public Note() {};
    public Note(Course course, String noteTitle, String noteText) {
        mCourse = course;
        mNoteTitle = noteTitle;
        mNoteText = noteText;
        mNoteId = UUID.randomUUID();
    }

    public UUID getNoteId() {
        return mNoteId;
    }

    public Course getCourse() {
        return mCourse;
    }

    public void setCourse(Course course) {
        mCourse = course;
    }

    public String getNoteTitle() {
        return mNoteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        mNoteTitle = noteTitle;
    }

    public String getNoteText() {
        return mNoteText;
    }

    public void setNoteText(String noteText) {
        mNoteText = noteText;
    }

    @Override
    public String toString() {
        return "Note{" +
                "mCourse=" + mCourse +
                ", mNoteTitle='" + mNoteTitle + '\'' +
                ", mNoteText='" + mNoteText + '\'' +
                '}';
    }
}
