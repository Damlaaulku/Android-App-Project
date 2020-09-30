package com.furkanenes.oop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.furkanenes.oop.components.CategoryButton;
import com.furkanenes.oop.models.Category;

import java.util.ArrayList;

public class Home extends AppCompatActivity {


    TextView welcomeText;

    public static String SearchText="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String fullName=Login.currentUser.getFirstName()+" "+Login.currentUser.getLastName();

        welcomeText=(TextView)findViewById(R.id.userNameText);
        welcomeText.setText("Welcome "+fullName);

        //Generate category buttons
        LinearLayout layout = (LinearLayout)findViewById(R.id.categoryLayout);
        layout.removeAllViews();
        for(Category category: Category.CategoryDatabase){
            CategoryButton b=new CategoryButton(this, category);
            layout.addView(b);
        }
    }
    // end onCreate

    @Override
    protected void onResume() {
        super.onResume();
        String fullName = Login.currentUser.getFirstName() + " " + Login.currentUser.getLastName();
        welcomeText.setText("Welcome " + fullName);
    }


    public void profileButtonClick(View view){
        startActivity(new Intent(this, Profile.class));
    }

    public void cartButtonClick(View view){
        startActivity(new Intent(this, Cart.class));
    }

    public void favButtonClick(View view){
        startActivity(new Intent(this, Favorites.class));
    }

    public void ordersButtonClick(View view){
        startActivity(new Intent(this, Orders.class));
    }

    public void searchButtonClick(View view){
        TextView searchInput=(TextView)findViewById(R.id.searchInput);
        SearchText=searchInput.getText().toString();

        startActivity(new Intent(this, Search.class));
    }


}
