package com.furkanenes.oop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.furkanenes.oop.components.ProductButton;
import com.furkanenes.oop.models.Product;

public class Favorites extends AppCompatActivity {
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        layout = (LinearLayout) findViewById(R.id.productList);

        reloadFavorites();
    }

    @Override
    public void onResume() {
        super.onResume();
        reloadFavorites();
    }

    public void reloadFavorites(){
        layout.removeAllViews();

        for(Product product: Login.currentUser.getFavorites()){
            ProductButton b=new ProductButton(this, product);
            layout.addView(b);
        }

    }
    // end reloadCart
}
