package com.furkanenes.oop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Profile extends AppCompatActivity {


    EditText firstNameInputO;
    EditText lastNameInputO;
    EditText phoneInputO;
    EditText emailInputO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firstNameInputO=(EditText)findViewById(R.id.firstNameInput);
        lastNameInputO=(EditText)findViewById(R.id.lastNameInput);
        phoneInputO=(EditText)findViewById(R.id.phoneInput);
        emailInputO=(EditText)findViewById(R.id.emailInput);

        firstNameInputO.setText(Login.currentUser.getFirstName());
        lastNameInputO.setText(Login.currentUser.getLastName());
        phoneInputO.setText(Login.currentUser.getPhone());
        emailInputO.setText(Login.currentUser.getEmail());
    }


    public void save(View view){

        Login.currentUser.update(firstNameInputO.getText().toString(),
                lastNameInputO.getText().toString(),
                "1234",
                phoneInputO.getText().toString(),
                emailInputO.getText().toString()
        );

        TextView savedText=(TextView)findViewById(R.id.savedText);
        savedText.setVisibility(View.VISIBLE);

    }

    public void switchAddresses(View view){
        startActivity(new Intent(this, Addresses.class));
    }

}
