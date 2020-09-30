package com.furkanenes.oop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.furkanenes.oop.components.ProductButton;
import com.furkanenes.oop.models.Address;
import com.furkanenes.oop.models.Invoice;
import com.furkanenes.oop.models.Order;
import com.furkanenes.oop.models.Product;

public class OrderDetail extends AppCompatActivity {

    public static Order order;

    TextView status, address, cargo, cargoCode, createdAt, paymentType, productTotal, cargoFee, tax, total;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        status=(TextView)findViewById(R.id.statusText);
        address=(TextView)findViewById(R.id.addressText);
        cargo=(TextView)findViewById(R.id.cargoFirmText);
        cargoCode=(TextView)findViewById(R.id.cargoCodeText);
        createdAt=(TextView)findViewById(R.id.createdAtText);
        paymentType=(TextView)findViewById(R.id.paymentTypeText);
        productTotal=(TextView)findViewById(R.id.productTotalText);
        cargoFee=(TextView)findViewById(R.id.cargoFeeText);
        tax=(TextView)findViewById(R.id.taxText);
        total=(TextView)findViewById(R.id.totalPriceText);

        loadData();
    }

    public void onResume() {
        super.onResume();
        loadData();
    }


    public void loadData(){
        status.setText(order.getStatus());
        cargo.setText(order.getCargo().getFirmName());
        cargoCode.setText(order.getCargoCode());
        createdAt.setText(order.getCreatedAt());
        paymentType.setText(order.getPaymentType());

        Address addr=order.getAddress();
        address.setText(addr.getDetails()+"\n"+addr.getQuarter()+", "+addr.getTown()+", "+addr.getCity());

        Invoice invoice=order.getInvoice();
        productTotal.setText(order.getProductTotal()+" TL");
        cargoFee.setText(order.getCargoPrice()+" TL");
        tax.setText(invoice.getTaxPrice()+" TL ("+invoice.getTaxPercent()+"%)");
        total.setText(invoice.getTotalPrice()+" TL");


        // Products
        LinearLayout productList=(LinearLayout)findViewById(R.id.productList);
        productList.removeAllViews();
        for(Product product: order.getProducts()){
            ProductButton b=new ProductButton(this, product);
            productList.addView(b);
        }

    }
}
