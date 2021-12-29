package com.example.secondprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        textView=findViewById(R.id.textViewResult);
        textView.setText("");

        Intent intent = getIntent();
        String str = intent.getStringExtra("key");
        textView.setText(str);

    }

    public void funcBack(View view) {
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
    }
}