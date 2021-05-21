package com.example.a4laboras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.text = findViewById(R.id.text);
    }

    public void onButtonClick(View view) {
        EditText editTxt = findViewById(R.id.editTxt);
        String currency = editTxt.getText().toString();

        new DataLoader() {
            @Override
            public void onPostExecute(String string) {
                text.setText(currency + ": " + string);
            }
        }.execute(currency);
    }
}