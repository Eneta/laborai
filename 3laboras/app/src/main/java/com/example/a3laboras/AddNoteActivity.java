package com.example.a3laboras;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Set;

public class AddNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createnote);
    }

    public void onAddNoteClick(View view) {
        EditText note = findViewById(R.id.text);

        SharedPreferences sharePref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor prefEdit = sharePref.edit();
        Set<String> allNotes = sharePref.getStringSet("notesList", new HashSet<String>());
        Set<String> newNotes = new HashSet<String>();
        newNotes.add(note.getText().toString());
        newNotes.addAll(allNotes);

        prefEdit.putStringSet("notesList", newNotes);
        prefEdit.apply();

        finish();
    }
}
