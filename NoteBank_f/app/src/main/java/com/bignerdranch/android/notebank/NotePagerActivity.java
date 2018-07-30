package com.bignerdranch.android.notebank;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;
import java.util.UUID;

public class NotePagerActivity extends AppCompatActivity {
    private static final String EXTRA_NOTE_ID = "com.bignerdranch.android.notebank.note_id";

    private ViewPager mViewPager;
    private List<Note> mNotes;

//    private static final String EXTRA_CRIME_ID = "com.bignerdranch.android.criminalintent.crime_id";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_pager);

        UUID noteId = (UUID) getIntent().getSerializableExtra(EXTRA_NOTE_ID);

        mViewPager = findViewById(R.id.note_view_pager);
        mNotes = NoteManager.getNoteManager(this).getNotes();


        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {

                Note note = mNotes.get(position);
                return NoteFragment.newInstance(note.getNoteId());
            }

            @Override
            public int getCount() {
                return mNotes.size();
            }
        });

        for( int i = 0 ; i < mNotes.size(); i++) {
            if(mNotes.get(i).getNoteId().equals(noteId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }

    public static Intent newIntent (Context packageContext, UUID noteId) {
        Intent intent = new Intent(packageContext, NotePagerActivity.class);
        intent.putExtra(EXTRA_NOTE_ID, noteId);
        return intent;
    }
}
