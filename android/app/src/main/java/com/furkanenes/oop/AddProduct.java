package com.furkanenes.oop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.furkanenes.oop.models.Brand;
import com.furkanenes.oop.models.Campaign;
import com.furkanenes.oop.models.Category;
import com.furkanenes.oop.models.Product;
import com.furkanenes.oop.models.Size;

import java.util.ArrayList;

public class AddProduct extends AppCompatActivity {

    String code, name, description,brand;
    float price,width,height,depth;
    ArrayList<String> catlist;
    ArrayList<String> camlist;


    ImageView img;

    EditText codeInput;
    EditText nameInput;
    EditText descInput;
    EditText brandInput;
    EditText priceInput;
    EditText widthInput;
    EditText heightInput;
    EditText depthInput;

    Spinner CategoriesSpinner;
    Spinner CampaignsSpinner;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        img=(ImageView)findViewById(R.id.productImage);
        codeInput = (EditText)findViewById(R.id.codeInput);
        nameInput = (EditText)findViewById(R.id.nameInput);
        descInput = (EditText)findViewById(R.id.descInput);
        brandInput = (EditText)findViewById(R.id.brandInput);
        priceInput = (EditText)findViewById(R.id.priceInput);
        widthInput = (EditText)findViewById(R.id.widthInput);
        heightInput = (EditText)findViewById(R.id.heightInput);
        depthInput = (EditText)findViewById(R.id.depthInput);

        catlist=new ArrayList<String>();

        for (int i = 0; i < Category.CategoryDatabase.size(); i++){
            String name;

            name=Category.CategoryDatabase.get(i).getName();
            catlist.add(name);
        }

        CategoriesSpinner=(Spinner)findViewById(R.id.CampaignsSpinner);
       ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, catlist);
       CategoriesSpinner.setAdapter(dataAdapter1);

        camlist=new ArrayList<String>();

        for (int i = 0; i < Campaign.CampaignDatabase.size(); i++){
            String name;

            name=Campaign.CampaignDatabase.get(i).getName();
            camlist.add(name);
        }

        CampaignsSpinner=(Spinner)findViewById(R.id.CampaignsSpinner);
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, camlist);
        CampaignsSpinner.setAdapter(dataAdapter2);

        button = (Button) findViewById(R.id.save);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               
            }
        });
    }
}
