package com.example.kpilabs;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private TextView resultText;
    private RadioGroup group;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultText = findViewById(R.id.resultText);
        editText = findViewById(R.id.enterText);
        group = findViewById(R.id.groupRadios);
    }

    public void showResult(View view) {
        int selectedId = group.getCheckedRadioButtonId();
        String text = editText.getText().toString();

        if (isNotCorrectData(selectedId, text)) return;

        RadioButton selectedRadioButton = findViewById(selectedId);

        setColorTextByText(selectedRadioButton.getText().toString());
        resultText.setText(editText.getText());
    }

    public void clearResult(View view) {
        group.clearCheck();
        resultText.setText("");
        editText.setText("");
    }

    private boolean isNotCorrectData(int selectedId, String text) {
        System.out.println("Selected id is : " + selectedId);
        System.out.println("Text enter is : " + text);

        if (selectedId == -1 && text.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Будь ласка введіть текст та виберіть колір", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (selectedId == -1) {
            Toast.makeText(getApplicationContext(), "Будь ласка виберіть колір", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (text.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Будь ласка введіть текст ", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    private void setColorTextByText(String colorText) {
        System.out.println("Вибраний колір: " + colorText);

        switch (colorText) {
            case "Фіолетовий":
                resultText.setTextColor(ContextCompat.getColor(this, R.color.violet));
                return;
            case "Зелений":
                resultText.setTextColor(ContextCompat.getColor(this, R.color.green));
                return;
            case "Синій":
                resultText.setTextColor(ContextCompat.getColor(this, R.color.blue));
                return;
            case "Червоний":
                resultText.setTextColor(ContextCompat.getColor(this, R.color.red));
                return;
            case "Оранжевий":
                resultText.setTextColor(ContextCompat.getColor(this, R.color.orange));
                return;
            default:
                Toast.makeText(getApplicationContext(), "Невідомий колір!", Toast.LENGTH_SHORT).show();
        }
    }
}