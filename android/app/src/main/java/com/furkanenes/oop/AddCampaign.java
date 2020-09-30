package com.furkanenes.oop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.furkanenes.oop.models.Campaign;

public class AddCampaign extends AppCompatActivity {

    String name,start,end;
    int percent;

    EditText startInput;
    EditText endInput;
    EditText nameInput;
    EditText percentInput;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_campaign);

        startInput = (EditText)findViewById(R.id.nameInput);
        endInput = (EditText)findViewById(R.id.endInput);
        nameInput = (EditText)findViewById(R.id.nameInput);
        percentInput = (EditText)findViewById(R.id.percentInput);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start = startInput.getText().toString();
                end = endInput.getText().toString();
                name = nameInput.getText().toString();
                percent = Integer.valueOf(percentInput.getText().toString());

                Campaign newCampaign = new Campaign(name,start,end,percent);

                Campaign.CampaignDatabase.add(newCampaign);

                Intent intent =new Intent(getApplicationContext(),AddCampaignSuccess.class);
                startActivity(intent);
            }
        });
    }

}
