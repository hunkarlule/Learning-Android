package com.bignerdranch.android.notebank;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.UUID;

public class NoteActivity extends SingleFragmentActivity {
    public  static final String NOTE_ID = "Note_Id";

    @Override
    protected Fragment createFragment() {
        UUID noteId =(UUID) getIntent().getSerializableExtra(NOTE_ID);
        return NoteFragment.newInstance(noteId);
    }

    public static Intent newIntent(Context context, UUID noteId) {
        Intent intent = new Intent(context, NoteActivity.class);
        intent.putExtra(NOTE_ID, noteId);
        return intent;

    }

}

