package com.furkanenes.oop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.furkanenes.oop.components.AddressView;
import com.furkanenes.oop.models.Address;

import java.util.ArrayList;

public class Addresses extends AppCompatActivity {

    EditText title, town, city, quarter, details;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addresses);

        title=(EditText)findViewById(R.id.addressTitle);
        city=(EditText)findViewById(R.id.cityText);
        town=(EditText)findViewById(R.id.townText);
        quarter=(EditText)findViewById(R.id.quarterText);
        details=(EditText)findViewById(R.id.detailsText);


        loadAddresses();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadAddresses();
    }

    public void loadAddresses(){
        ArrayList<Address> addresses=Login.currentUser.getAddresses();

        LinearLayout addressListLayout=(LinearLayout)findViewById(R.id.linearLayout);
        addressListLayout.removeAllViews();
        for(Address address: addresses){
            AddressView e=new AddressView(this, address);
            addressListLayout.addView(e);
        }

    }

    public void createAddress(View view){
        Login.currentUser.addAddress(
                title.getText().toString(),
                city.getText().toString(),
                town.getText().toString(),
                quarter.getText().toString(),
                details.getText().toString()
                );

        loadAddresses();
    }
}
