package com.bignerdranch.android.notebank;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.UUID;

public class NoteFragment extends Fragment {

    private Note mNote;
    private Spinner mNoteCourse;
    private EditText mNoteTitle;
    private EditText mNoteText;
    private static final String ARG_NOTE_ID = "arg_note_id";
    private UUID noteId;
    private boolean mNoteDelete;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        noteId = (UUID) getArguments().getSerializable(ARG_NOTE_ID);

        if (noteId != null) {
            mNote = NoteManager.getNoteManager().getNote(noteId);
        }
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note, container, false);
        mNoteTitle = view.findViewById(R.id.note_title);
        mNoteText = view.findViewById(R.id.note_text);
        mNoteCourse = view.findViewById(R.id.note_course);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, NoteManager.getNoteManager().getCourses(NoteManager.getNoteManager().getCourses()));
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mNoteCourse.setAdapter(adapter);
        updateViews();

        mNoteTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                checkEditText();
            }
        });

        mNoteText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                checkEditText();
            }
        });

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d("NoteFragment", "onPause!");
        if (!mNoteDelete) {
            String noteTitle = mNoteTitle.getText().toString();
            String noteText = mNoteText.getText().toString();

            if (!noteTitle.isEmpty() && !noteText.isEmpty()) {

                Course course = null;
                for (int i = 0; i < NoteManager.getNoteManager().getCourses().size(); i++) {
                    if (mNoteCourse.getSelectedItem().toString().equals(NoteManager.getNoteManager().getCourses().get(i).getCourseTitle())) {
                        course = NoteManager.getNoteManager().getCourses().get(i);
                    }
                }
                if (noteId == null) {
                    mNote = new Note(course, noteTitle, noteText);
                    NoteManager.getNoteManager().addNote(mNote);
                } else {
                    int index = NoteManager.getNoteManager().getNotes().indexOf(mNote);
                    NoteManager.getNoteManager().getNote(index).setNoteTitle(noteTitle);
                    NoteManager.getNoteManager().getNote(index).setNoteText(noteText);
                    NoteManager.getNoteManager().getNote(index).setCourse(course);
                }
            }
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_note, menu);
        if(mNote == null) {
            menu.clear();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_note:
                if (mNote != null) {
                    NoteManager.getNoteManager().getNotes().remove(mNote);
                }
                mNoteDelete = true;
                getActivity().finish();
                return true;

            case R.id.share_note:
                if (mNote != null) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    StringBuilder msgString = new StringBuilder();
                    msgString.append(mNote.getCourse().getCourseTitle() + " - ");
                    msgString.append(mNote.getNoteTitle() + " - ");
                    msgString.append(mNote.getNoteText());
                    intent.putExtra(intent.EXTRA_TEXT, msgString.toString() );
                    intent.setType("text/*");
                    startActivity(intent);
                }
                mNoteDelete = true;
                getActivity().finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateViews() {
        if (mNote != null) {
            selectSpinnerItemByValue(mNoteCourse, mNote.getCourse().getCourseTitle());
            mNoteTitle.setText(mNote.getNoteTitle());
            mNoteText.setText(mNote.getNoteText());
        }
    }

    public static NoteFragment newInstance(UUID noteId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_NOTE_ID, noteId);

        NoteFragment fragment = new NoteFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static void selectSpinnerItemByValue(Spinner spnr, String value) {
        ArrayAdapter adapter = (ArrayAdapter) spnr.getAdapter();
        if (value == null) {
            spnr.setSelection(0);
            return;
        } else {
            for (int position = 0; position < adapter.getCount(); position++) {
                if (adapter.getItem(position).toString().equals(value)) {
                    spnr.setSelection(position);
                    return;
                }
            }
        }
    }

    public void checkEditText() {

        String strNoteTitle = mNoteTitle.getText().toString();
        String strNoteText = mNoteText.getText().toString();

        if (TextUtils.isEmpty(strNoteTitle)) {
            mNoteTitle.setError("Note Title is empty");
            return;
        }

        if (TextUtils.isEmpty(strNoteText)) {
            mNoteText.setError("Note Text is empty");
            return;
        }

        return;
    }
}
