package com.example.android.cwsowner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Sign_In extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__in);

        // Find Sign Up Link View
        TextView signUpLink = findViewById(R.id.link_signup);

        // Set OnClickListener on Sign Up Link
        signUpLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(Sign_In.this, SignUp.class);
                startActivity(signUp);
            }
        });
    }
}
