package com.furkanenes.oop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.furkanenes.oop.models.Order;

import java.util.ArrayList;

public class UpdateOrderStatus extends AppCompatActivity {

    String Upstatus;
    String selectorder;
    ArrayList<String> orderlist;

    Spinner StatusSpinner,OrderSpinner;

    Button updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_order_status);

        StatusSpinner=(Spinner)findViewById(R.id.StatusSpinner);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.status,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        StatusSpinner.setAdapter(arrayAdapter);
        StatusSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String[] status = getResources().getStringArray(R.array.status);
                Upstatus = status[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        orderlist = new ArrayList<String>();

        for (int i = 0; i < Order.OrderDatabase.size(); i++){
            String order;

            order=Order.OrderDatabase.get(i).getUser().getFirstName()+ " " +Order.OrderDatabase.get(i).getUser().getLastName();
            orderlist.add(order);
        }

        OrderSpinner=(Spinner)findViewById(R.id.OrderSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, orderlist);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        OrderSpinner.setAdapter(adapter);
        OrderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                selectorder = orderlist.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        updateButton=(Button) findViewById(R.id.UpdateButton);
        updateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                for (int i = 0; i < Order.OrderDatabase.size(); i++){
                    String order;
                    order=Order.OrderDatabase.get(i).getUser().getFirstName()+ " " +Order.OrderDatabase.get(i).getUser().getLastName();

                    if (order==selectorder){
                        Order.OrderDatabase.get(i).setStatus(Upstatus);
                    }
                }

                Intent intent =new Intent(getApplicationContext(),OrderUpdateSuccess.class);
                startActivity(intent);

            }
        });
    }
}
