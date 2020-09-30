package com.furkanenes.oop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.furkanenes.oop.components.ProductButton;
import com.furkanenes.oop.models.Product;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        loadResults();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadResults();
    }


    public void loadResults(){
        ArrayList<Product> products=Product.search(Home.SearchText);

        LinearLayout layout = (LinearLayout)findViewById(R.id.searchLayout);
        layout.removeAllViews();

        final Search currentActivity=this;

        for(Product product: products){
            ProductButton b=new ProductButton(this, product);
            layout.addView(b);
        }

    }
}
