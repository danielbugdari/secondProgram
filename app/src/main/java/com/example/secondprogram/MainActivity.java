package com.example.secondprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    char opp;
    int num1;
    int num2;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textFurmola);
        textView.setText("");

        mAuth = FirebaseAuth.getInstance();
    }

    public void funcNumber(View view) {

        Button b = (Button) view;
        String str = b.getText().toString();
        textView.append(str);
    }

    public void funcAction(View view) {

        Button b = (Button) view;
        String str = b.getText().toString();
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

    public void funcPushResult(View view) {
        Intent intent = new Intent(this , ActivityTwo.class);
        intent.putExtra("key" ,"Hello");
        startActivity(intent);
    }

    public  void loginFunc(){

        String email = ((EditText)findViewById(R.id.text1)).getText().toString();
        String password = ((EditText)findViewById(R.id.text2)).getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

    }
    public  void regFunc(){

    }
}