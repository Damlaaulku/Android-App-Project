package com.furkanenes.oop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.furkanenes.oop.components.ProductButton;
import com.furkanenes.oop.models.Product;

public class Cart extends AppCompatActivity {

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        layout = (LinearLayout) findViewById(R.id.productList);

        reloadCart();
    }

    @Override
    public void onResume() {
        super.onResume();
        reloadCart();
    }

    public void reloadCart(){
        layout.removeAllViews();

        float totalPrice=Login.currentUser.getCartPrice();
        TextView totalText=(TextView)findViewById(R.id.totalText);
        totalText.setText("Cart Total: "+totalPrice+" TL");


        for(Product product: Login.currentUser.getCart()){
            ProductButton b=new ProductButton(this, product);
            layout.addView(b);
        }


    }
    // end reloadCart

    public void finalizeOrder(View view){
        startActivity(new Intent(this, CreateOrder.class));
    }
}
