package com.example.a3laboras;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.prefs.PreferenceChangeEvent;

public class DeleteNoteActivity extends AppCompatActivity {
    Spinner deleteSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletenote);

        deleteSpinner = findViewById(R.id.deleteSpinner);
        SharedPreferences sharePref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        ArrayList<String> allNotes = new ArrayList<String>(sharePref.getStringSet("notesList", new HashSet<String>()));
        ArrayAdapter listAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, allNotes);
        deleteSpinner.setAdapter(listAdapter);
    }

    public void onDeleteNoteClick(View view) {
        SharedPreferences sharePref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor prefEdit = sharePref.edit();
        Set<String> allNotes = sharePref.getStringSet("notesList", new HashSet<String>());

        String noteToDelete = deleteSpinner.getSelectedItem().toString();

        for (String note : allNotes) {
            if (note.equalsIgnoreCase(noteToDelete)) {
                allNotes.remove(note);
            }
        }

        prefEdit.putStringSet("notesList", allNotes);
        prefEdit.apply();
        finish();
    }
}
