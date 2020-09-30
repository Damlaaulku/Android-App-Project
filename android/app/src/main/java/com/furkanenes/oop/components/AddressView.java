package com.furkanenes.oop.components;

import android.content.Context;

import com.furkanenes.oop.models.Address;
import com.furkanenes.oop.models.Comment;
import com.furkanenes.oop.models.User;

public class AddressView extends androidx.appcompat.widget.AppCompatTextView {

    public Address address;

    public AddressView(Context context) {
        super(context);
    }

    public AddressView(Context context, Address address){
        super(context);
        this.address=address;
        this.setPadding(60, 0,80,0);


        String str="";

        str+=address.getName()+"\n";
        str+=address.getQuarter()+", "+address.getTown()+", "+address.getTown()+"\n";
        str+=address.getDetails()+"\n_______________\n";

        this.setText(str);
    }


}
