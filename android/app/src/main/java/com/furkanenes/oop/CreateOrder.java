package com.furkanenes.oop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.furkanenes.oop.models.Address;
import com.furkanenes.oop.models.Cargo;
import com.furkanenes.oop.models.Order;

import java.util.ArrayList;
import java.util.HashMap;

public class CreateOrder extends AppCompatActivity {

    Spinner paymentTypeSpinner, addressSpinner, cargoSpinner;
    TextView cartTotal;

    HashMap<String, Cargo> cargoEntries=new HashMap<String, Cargo>();
    HashMap<String, Address> addressEntries=new HashMap<String, Address>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);

        paymentTypeSpinner=(Spinner)findViewById(R.id.paymentTypeSpinner);
        addressSpinner=(Spinner)findViewById(R.id.addressSpinner);
        cargoSpinner=(Spinner)findViewById(R.id.cargoSpinner);

        cartTotal=(TextView)findViewById(R.id.orderTotalText);

        loadData();

    }

    public void onResume() {
        super.onResume();
        loadData();
    }


    public void loadData(){

        cartTotal.setText(Login.currentUser.getCartPrice()+" TL");

        addressEntries.clear();
        ArrayList<String> addressTitles=new ArrayList<String>();
        for(Address address: Login.currentUser.getAddresses())
        {
            addressTitles.add(address.getName());
            addressEntries.put(address.getName(), address);
        }

        cargoEntries.clear();
        ArrayList<String> cargoNames=new ArrayList<String>();
        for(Cargo cargo: Cargo.CargoDatabase)
        {
            cargoNames.add(cargo.getFirmName());
            cargoEntries.put(cargo.getFirmName(), cargo);
        }


        ArrayList<String> paymentTypes=new ArrayList<String>();
        paymentTypes.add("Credit Cart");
        paymentTypes.add("Cash");


        ArrayAdapter<String> addressAdapter = new ArrayAdapter<String>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, addressTitles);
        addressAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        addressSpinner.setAdapter(addressAdapter);

        ArrayAdapter<String> cargoAdapter = new ArrayAdapter<String>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, cargoNames);
        cargoAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        cargoSpinner.setAdapter(cargoAdapter);

        ArrayAdapter<String> paymentTypeAdapter = new ArrayAdapter<String>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, paymentTypes);
        paymentTypeAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        paymentTypeSpinner.setAdapter(paymentTypeAdapter);

    }


    public void createOrder(View view){

        String selectedCargoEntry=cargoSpinner.getSelectedItem().toString();
        Cargo selectedCargo=cargoEntries.get(selectedCargoEntry);

        String selectedAddressEntry=addressSpinner.getSelectedItem().toString();
        Address selectedAddress=addressEntries.get(selectedAddressEntry);

        Order order=Login.currentUser.createOrder(
                selectedCargo,
                paymentTypeSpinner.getSelectedItem().toString(),
                selectedCargo.getPrice(),
                0,
                selectedAddress,
                null
        );

        order.createInvoice(18);

        startActivity(new Intent(this, OrderSuccess.class));
    }


}
