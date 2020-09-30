package com.furkanenes.oop.components;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.furkanenes.oop.CategoryDetail;
import com.furkanenes.oop.ProductDetail;
import com.furkanenes.oop.models.Category;
import com.furkanenes.oop.models.Product;

public class CategoryButton extends androidx.appcompat.widget.AppCompatButton {

    public Category category;

    public CategoryButton(Context context) {
        super(context);
    }

    public CategoryButton(final Context context, Category category){
        super(context);
        this.category=category;

        final Category pTemp=category;

        setText(category.getName());

        // OnClick
        this.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                CategoryDetail.category=pTemp;
                context.startActivity(new Intent(context, CategoryDetail.class));
            }
        });

    }

}
