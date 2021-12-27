package com.example.secondprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    char opp;
    int num1;
    int num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textFurmola);
        textView.setText("");
    }

    public void funcNumber(View view) {

        Button b = (Button) view;
        String str = b.getText().toString();
        textView.append(str);
    }

    public void funcAction(View view) {

        Button b = (Button) view;
        String str = b.getText().toString();
        //textView.setText(str);
        opp = str.charAt(0);
        num1 = Integer.parseInt(textView.getText().toString());

       textView.setText("");

    }

    public void funcResult(View view) {

        num2 = Integer.parseInt(textView.getText().toString());

        switch (opp) {
            case '+':
                textView.setText((num1 + num2) + "");
                break;
            case '-':
                textView.setText((num1 - num2) + "");
                break;
            case '/':
                textView.setText((num1 / num2) + "");
                break;
            case '*':
                textView.setText((num1 * num2) + "");
                break;
        }
    }
    public void funcClear(View view) {

        textView.setText("");

    }
}