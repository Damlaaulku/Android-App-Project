package com.furkanenes.oop.components;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.furkanenes.oop.ProductDetail;
import com.furkanenes.oop.models.Product;

public class ProductButton extends androidx.appcompat.widget.AppCompatButton {

    public Product product;

    public ProductButton(Context context) {
        super(context);
    }

    public ProductButton(final Context context, Product product){
        super(context);
        this.product=product;

        final Product pTemp=product;

        setText(product.getBrand().getName()+" "+product.getName()+" | "+product.getPrice());

        // OnClick
        this.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ProductDetail.product=pTemp;
                context.startActivity(new Intent(context, ProductDetail.class));
            }
        });

    }

}
