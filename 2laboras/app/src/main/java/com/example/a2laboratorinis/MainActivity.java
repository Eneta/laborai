package com.example.a2laboratorinis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.textcountersample.utils.ElementsCalculator.getCharsCount;

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

        String selection = this.selectionVariant.getSelectedItem().toString();
        if(selection.equalsIgnoreCase("Simboliai")) {
            int count = getCharsCount(userInputText);
            showResult.setText(String.valueOf(count));
        }

        String selection = this.selectionVariant.getSelectedItem().toString();
        if(selection.equalsIgnoreCase("Žodžiai")) {
            int count = getCharsCount(userInputText);
            showResult.setText(String.valueOf(count));
    }
}