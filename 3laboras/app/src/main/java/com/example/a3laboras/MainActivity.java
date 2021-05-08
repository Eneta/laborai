package com.example.a3laboras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    private ListView notes;
    private ArrayAdapter listAdapter;
    private ArrayList<String> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.notes = findViewById(R.id.list);
        SharedPreferences sharePref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        this.notesList = new ArrayList<String>(sharePref.getStringSet("notesList", new HashSet<String>()));
        this.listAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, notesList);
        this.notes.setAdapter(this.listAdapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        SharedPreferences sharePref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        notesList.clear();
        this.notesList.addAll((sharePref.getStringSet("notesList", new HashSet<String>())));
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addNote:
                Intent addActivityIntent = new Intent(getApplicationContext(), com.example.a3laboras.AddNoteActivity.class);
                startActivity(addActivityIntent);
                return true;
            case R.id.deleteNote:
                Intent deleteActivityIntent = new Intent(getApplicationContext(), com.example.a3laboras.DeleteNoteActivity.class);
                startActivity(deleteActivityIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}