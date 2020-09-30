package com.furkanenes.oop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.furkanenes.oop.components.OrderButton;
import com.furkanenes.oop.models.Order;

public class Orders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        loadOrders();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadOrders();
    }

    public void loadOrders(){
        LinearLayout layout=(LinearLayout)findViewById(R.id.ordersLayout);
        layout.removeAllViews();

        for(Order order: Login.currentUser.getOrders()){
            OrderButton b=new OrderButton(this, order);
            layout.addView(b);
        }
    }
}
