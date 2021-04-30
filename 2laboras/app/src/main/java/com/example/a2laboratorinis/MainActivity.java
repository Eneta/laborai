package com.example.a2laboratorinis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.a2laboratorinis.SymbolsWordsCounter.getSymbolsCount;
import static com.example.a2laboratorinis.SymbolsWordsCounter.getWordsCount;

public class MainActivity extends AppCompatActivity {

    Spinner selectionVariant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.selectionVariant = (Spinner) findViewById(R.id.selectionVariant);
        ArrayList<String> optionList = new ArrayList<>();
        optionList.add("Žodžiai");
        optionList.add("Simboliai");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, optionList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.selectionVariant.setAdapter(adapter);
    }

    public void countWords(View view) {
        EditText fillIn = findViewById(R.id.editTxt);
        TextView showResult = findViewById(R.id.finalTxt);
        String userInputText = fillIn.getText().toString();
        int count;

        String selection = this.selectionVariant.getSelectedItem().toString();

        if (TextUtils.isEmpty(userInputText)) {
            Toast.makeText(getApplicationContext(), "Trūksta teksto", Toast.LENGTH_SHORT).show();
        } else if(selection.equalsIgnoreCase("Simboliai")) {
            count = getSymbolsCount(userInputText);
            showResult.setText(String.valueOf(count));
        } else if(selection.equalsIgnoreCase("Žodžiai")) {
            count = getWordsCount(userInputText);
            showResult.setText(String.valueOf(count));
        }
    }
}