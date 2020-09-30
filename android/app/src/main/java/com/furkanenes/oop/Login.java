package com.furkanenes.oop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.furkanenes.oop.models.User;

public class Login extends AppCompatActivity {

    public static boolean DataGenerated=false;
    public static User currentUser= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Populate data
        if(!DataGenerated){
            DataManager.GenerateDummyData();
            DataGenerated=true;
        }


    }

    public void loginButtonClick(View view){

        EditText usernameField=(EditText)findViewById(R.id.username);
        String username=usernameField.getText().toString();

        EditText passwordField=(EditText)findViewById(R.id.password);
        String password=passwordField.getText().toString();

        Log.v("LOGIN",username+" : "+password);

        TextView errorText=(TextView)findViewById(R.id.loginError);

        if((username.equals("User") || username.equals("Admin")) && password.equals("1234"))
        {
            // Sample information about user,
            //  Would be fetched from database in production
            currentUser=new User(
                111,
                "Test",
                "User",
                "1234",
                "5556667788",
                "test@ceng.deu.edu.tr"
            );

            currentUser.addAddress("Kampüs", "İzmir", "Buca", "Tınaztepe", "Dokuz Eylül Üniversitesi Tınaztepe Yerleşkesi Mühendislik Fakültesi");

            Log.v("LOGIN","Login Success");

            if(username.equals("User"))
                startActivity(new Intent(Login.this, Home.class));
            else if(username.equals("Admin"))
                startActivity(new Intent(Login.this, AdminActions.class));
        }
        else{
            // Fail
            errorText.setVisibility(view.VISIBLE);
            usernameField.setText("");
            passwordField.setText("");
        }


    }
    // end login


}
