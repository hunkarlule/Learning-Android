package com.bignerdranch.android.notebank;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NoteManager {
    private static NoteManager sNoteManager;
    private List<Note> mNotes;
    private List<Course> mCourse;


    public static NoteManager getNoteManager(Context context) {
        if (sNoteManager == null) {
            sNoteManager = new NoteManager(context);
        }

        return sNoteManager;
    }

    private NoteManager(Context context) {
        mNotes = new ArrayList<>();
        mCourse = new ArrayList<>();
        setupCourses();
        setupNotes();
    }

    private void setupCourses() {
        mCourse.add(new Course("Java"));
        mCourse.add(new Course("Android Programming"));
        mCourse.add(new Course( "Intro to Programming"));
        mCourse.add(new Course( "Swift"));
        mCourse.add(new Course( "C & Objective C"));
        mCourse.add(new Course("IOS Programming"));
    }

    private void setupNotes() {
        addNote(new Note(mCourse.get(0), "Primitive Types", "Primitive types do not have the advantages of reference types. However they could be treated as reference types with help of wrapper clases"));
        addNote(new Note(mCourse.get(3), "Switch statement", "It is vital to put break after every case statement. Otherwise it could cause your program to misbhave."));
        addNote(new Note(mCourse.get(2), "Intents", "Intents are tools for activities to talk eachother. You can put extras into intents that new activity requires."));
        addNote(new Note(mCourse.get(0), "Interfaces", "Interfaces are contracts that each class that implements that interface should complately follow. With java 8, interfases have default methods."));
        addNote(new Note(mCourse.get(4), "Primitive Types", "Primitive types do not have the advantages of reference types. However they could be treated as reference types with help of wrapper clases"));
        addNote(new Note(mCourse.get(5), "Switch statement", "It is vital to put break after every case statement. Otherwise it could cause your program to misbhave."));
        addNote(new Note(mCourse.get(1), "Intents", "Intents are tools for activities to talk eachother. You can put extras into intents that new activity requires."));
        addNote(new Note(mCourse.get(0), "Interfaces", "Interfaces are contracts that each class that implements that interface should complately follow. With java 8, interfases have default methods."));
    }

    public void addNote(Note note) {
        mNotes.add(note);
    }

    public void addCourse(Course course) {
        mCourse.add(course);
    }

    public void removeNote(Note note) {
        mNotes.remove(note);
    }

    public void removeNote(int index) {
        mNotes.remove(index);
    }

    public void removeNote(UUID noteId) {

        for(int i = 0; i < mNotes.size(); i++) {
            if(mNotes.get(i).getNoteId(). equals(noteId)) {
                mNotes.remove(i);
            }
        }

    }

    public List<Note> getNotes() {
        return mNotes;
    }

    public List<Course> getCourses() {
        return mCourse;
    }

    public Note getNote(int index) {
        return mNotes.get(index);
    }

        public Note getNote(UUID noteId) {
            for (int index = 0; index < mNotes.size(); index++) {
                Note tempNote = mNotes.get(index);
                if (noteId.equals(tempNote.getNoteId())) {
                    return tempNote;
                }
            }
            return null;
        }

    public String[] getCourses(List<Course> courses) {
        String[] myCourses = new String[courses.size()];
        for (int index = 0; index < courses.size(); index++) {
            myCourses[index] = courses.get(index).getCourseTitle();
        }
        return myCourses;
    }
}


