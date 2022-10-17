package com.example.kpilabs;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("This is create");

        List<TextView> textViews = new ArrayList<>();
        textViews.add(findViewById(R.id.textView));
        textViews.add(findViewById(R.id.textView1));
        textViews.add(findViewById(R.id.textView2));
        textViews.add(findViewById(R.id.textView3));

        Button sendBtn = findViewById(R.id.button2);
        sendBtn.setOnClickListener(v -> textViews.get(new Random().nextInt(textViews.size()))
                .setText("This is random detka"));
    }
}