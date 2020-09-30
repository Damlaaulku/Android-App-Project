package com.furkanenes.oop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddCampaignSuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_campaign_success);
    }

    public void backToMenu(View view) {
        Intent intent =new Intent(getApplicationContext(),AdminActions.class);
        startActivity(intent);
    }
}
