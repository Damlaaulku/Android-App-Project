package com.furkanenes.oop.components;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.furkanenes.oop.OrderDetail;
import com.furkanenes.oop.ProductDetail;
import com.furkanenes.oop.models.Order;
import com.furkanenes.oop.models.Product;

public class OrderButton extends androidx.appcompat.widget.AppCompatButton {

    public Order order;

    public OrderButton(Context context) {
        super(context);
    }

    public OrderButton(final Context context, Order order){
        super(context);
        this.order=order;

        final Order pTemp=order;

        setText(order.getTotalPrice()+" TL - "+order.getProducts().size()+" Ürün - "+order.getCreatedAt());

        // OnClick
        this.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                OrderDetail.order=pTemp;
                context.startActivity(new Intent(context, OrderDetail.class));
            }
        });

    }

}
