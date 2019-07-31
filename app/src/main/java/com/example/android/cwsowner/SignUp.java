package com.example.android.cwsowner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class SignUp extends AppCompatActivity {

    // Input Data Variables
    String iName;
    String iPhone;
    String iEmail;
    String iPassword;
    String iConfirmPass;
    String iCwsName;
    String iCwsAddress;

    // Find submit button
    Button submitButton;

    // Find user input views
    TextInputEditText name;
    TextInputEditText phoneNumber;
    TextInputEditText email;
    TextInputEditText password;
    TextInputEditText confirmPassword;
    TextInputEditText cwsName;
    TextInputEditText cwsAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Find submit button
        submitButton = findViewById(R.id.btn_signup);

        // Find user input views
        name = findViewById(R.id.input_name);
        phoneNumber = findViewById(R.id.input_phone_number);
        email = findViewById(R.id.input_email);
        password = findViewById(R.id.input_password);
        confirmPassword = findViewById(R.id.confirm_password);
        cwsName = findViewById(R.id.input_cws_name);
        cwsAddress = findViewById(R.id.input_cws_address);

        // Set OnClickListener on submitButton
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if all data is filled
                getInput();

                if(!allFilled())
                {
                    confirmPassword.setError(null);
                    Toast.makeText(getApplicationContext(), "Please Fill all Data", Toast.LENGTH_SHORT).show();
                }
                else if (!iPassword.equals(iConfirmPass))
                {
                    confirmPassword.setError("Password doesn/'t match");
                }
                else
                {
                    confirmPassword.setError(null);
                    Intent completeSignUp = new Intent(SignUp.this, SignUpSuccesfull.class);
                    startActivity(completeSignUp);
                }
            }
        });
    }

    /*
     * This method gets the user input and is called when the submit button is clicked
     */
    void getInput()
    {
        iName = name.getText().toString();
        iPhone = phoneNumber.getText().toString();
        iEmail = email.getText().toString();
        iPassword = password.getText().toString();
        iConfirmPass = confirmPassword.getText().toString();
        iCwsName = cwsName.getText().toString();
        iCwsAddress = cwsAddress.getText().toString();
    }

    /*
     * This method checks whether all the fields are filled or not and is called when submit
     * button is clicked
     * Returns a boolean
     */
    boolean allFilled()
    {
        boolean result = true;

        if(iName.isEmpty())
        {
            name.setError("Enter Your Name");
            result = false;
        }
        else
        {
            name.setError(null);
        }

        if(iPhone.isEmpty())
        {
            phoneNumber.setError("Enter Your Phone Number");
            result = false;
        }
        else
        {
            phoneNumber.setError(null);
        }

        if(iEmail.isEmpty())
        {
            email.setError("Enter Your Email");
            result = false;
        }
        else
        {
            email.setError(null);
        }

        if(iPassword.isEmpty())
        {
            password.setError("Enter Your Password");
            result = false;
        }
        else
        {
            password.setError(null);
        }

        if(iConfirmPass.isEmpty())
        {
            confirmPassword.setError("Confirm Password");
            result = false;
        }
        else
        {
            confirmPassword.setError(null);
        }

        if(iCwsName.isEmpty())
        {
            cwsName.setError("Enter Your Co-Working Space's Name");
            result = false;
        }
        else
        {
            cwsName.setError(null);
        }

        if(iCwsAddress.isEmpty())
        {
            cwsAddress.setError("Enter Your Co-Working Space's Address");
            result = false;
        }
        else
        {
            cwsAddress.setError(null);
        }

        return result;
    }
}
