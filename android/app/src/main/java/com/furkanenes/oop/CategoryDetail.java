package com.furkanenes.oop;



import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.furkanenes.oop.components.ProductButton;
import com.furkanenes.oop.models.Category;
import com.furkanenes.oop.models.Product;

public class CategoryDetail extends AppCompatActivity {

    public static Category category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);
        loadItems();

        TextView categoryNameTW=(TextView)findViewById(R.id.pageHeader);
        categoryNameTW.setText(category.getName());
    }

    @Override
    public void onResume() {
        super.onResume();
        loadItems();
    }


    public void loadItems(){

        LinearLayout productListLayout=(LinearLayout)findViewById(R.id.itemsLayout);
        productListLayout.removeAllViews();

        for(Product p: category.getProducts()){
            ProductButton b=new ProductButton(this, p);
            productListLayout.addView(b);
        }
    }

}
