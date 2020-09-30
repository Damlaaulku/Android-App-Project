package com.furkanenes.oop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.furkanenes.oop.models.Brand;
import com.furkanenes.oop.models.Size;

public class AdminActions extends AppCompatActivity {

    Button CampaignButton;
    Button UpdateButton;
    Button ProductButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_actions);

        CampaignButton = (Button) findViewById(R.id.CampaignButton);
        CampaignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),AddCampaign.class);
                startActivity(intent);
            }
        });

        UpdateButton = (Button) findViewById(R.id.UpdateButton);
        UpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),UpdateOrderStatus.class);
                startActivity(intent);
            }
        });

        ProductButton = (Button) findViewById(R.id.ProductButton);
        ProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),AddProduct.class);
                startActivity(intent);
            }
        });

    }
}
