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
        EditText txtNote = findViewById(R.id.text);

        SharedPreferences sharePref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor spEd = sharePref.edit();
        Set<String> oldSet = sharePref.getStringSet("notes", new HashSet<String>());
        Set<String> newStrSet = new HashSet<String>();
        newStrSet.add(txtNote.getText().toString());
        newStrSet.addAll(oldSet);

        spEd.putStringSet("notes", newStrSet);
        spEd.apply();

        finish();
    }
}
