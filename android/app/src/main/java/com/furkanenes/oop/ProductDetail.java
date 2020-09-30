package com.furkanenes.oop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.telephony.IccOpenLogicalChannelResponse;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.furkanenes.oop.components.ProductButton;
import com.furkanenes.oop.models.Bed;
import com.furkanenes.oop.models.BookShelf;
import com.furkanenes.oop.models.Campaign;
import com.furkanenes.oop.models.Category;
import com.furkanenes.oop.models.Chair;
import com.furkanenes.oop.models.Commode;
import com.furkanenes.oop.models.Material;
import com.furkanenes.oop.models.Materialable;
import com.furkanenes.oop.models.Product;
import com.furkanenes.oop.models.Size;
import com.furkanenes.oop.models.Sofa;
import com.furkanenes.oop.models.Stack;
import com.furkanenes.oop.models.Table;
import com.furkanenes.oop.models.Wardrobe;

import org.w3c.dom.Text;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ProductDetail extends AppCompatActivity {

    public static Product product;

    TextView codeTW, nameTW, brandTW, priceTW, descriptionTW, categoriesTW, sizeTW, metadata, campaignTW;
    ImageView img;
    Button cartButton, favButton, commentsButton;
    boolean inCart, inFavs;
    Spinner materialsSelect;
    ArrayList<String> materials;
    RatingBar rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        codeTW=(TextView)findViewById(R.id.codeText);
        nameTW=(TextView)findViewById(R.id.nameText);
        brandTW=(TextView)findViewById(R.id.brandText);
        descriptionTW=(TextView)findViewById(R.id.descriptionText);
        priceTW=(TextView)findViewById(R.id.priceText);
        categoriesTW=(TextView)findViewById(R.id.categoriesText);
        sizeTW=(TextView)findViewById(R.id.sizeText);
        img=(ImageView)findViewById(R.id.productImage);
        metadata=(TextView)findViewById(R.id.metadata);
        campaignTW=(TextView)findViewById(R.id.campaignText);
        rating=(RatingBar)findViewById(R.id.ratingBar);

        materials=new ArrayList<String>();
        materialsSelect=(Spinner)findViewById(R.id.materials);
        materialsSelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String mat=materials.get(position);
                DataManager.MaterialCache.put(product.getCode(), mat);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                DataManager.MaterialCache.put(product.getCode(), "Not Selected");
            }
        });

        cartButton=(Button)findViewById(R.id.cartButton);
        favButton=(Button)findViewById(R.id.favoritesButton);
        commentsButton=(Button)findViewById(R.id.commentsButton);

        loadProduct();
        loadImage();
        loadBrowsingHistory();
        loadMaterials();

        Stack browsingHistory=Login.currentUser.getBrowsingHistory();
        if(browsingHistory.isEmpty() || !((Product)browsingHistory.Peek()).getCode().equals(product.getCode()))
            Login.currentUser.getBrowsingHistory().Push(product);

    }

    @Override
    public void onResume() {
        super.onResume();
        loadProduct();
        loadImage();
        loadBrowsingHistory();
        loadMaterials();
    }


    public void loadProduct() {
        codeTW.setText(product.getCode());
        nameTW.setText(product.getName());
        descriptionTW.setText(product.getDescription());
        priceTW.setText(product.getPrice()+" TL");
        brandTW.setText(product.getBrand().getName());
        rating.setRating(product.getRating());
        commentsButton.setText("Comments ("+product.getComments().size()+")");


        // Categories
        String categoryText="";
        for(Category cat: product.getCategories())
        {
            categoryText+=cat.getName()+" ";
        }
        categoriesTW.setText(categoryText);

        Size size=product.getSize();
        sizeTW.setText(size.getWidth()+"x"+size.getHeight()+"x"+size.getDepth());

        // Campaigns
        if(product.getCampaigns().size()>0){

            String campaigns="";
            for(Campaign camp: product.getCampaigns()){
                campaigns+=camp.getName()+" (-"+camp.getPercent()+"%)\n";
            }

            campaignTW.setVisibility(View.VISIBLE);
            campaignTW.setText(campaigns);
        }

        // Buttons
        inCart=Login.currentUser.getCart().contains(product);
        inFavs=Login.currentUser.getFavorites().contains(product);

        cartButton.setText(inCart ? "Remove from Cart" : "Add to Cart");
        favButton.setText(inFavs ? "Remove from Favorites" : "Add to Favorites");

        loadMetadata();
    }


    public void loadMaterials(){
        materials.clear();

        String className=product.getClass().getSimpleName();

        int index=0, selectedIndex=0;

        if(className.equals("Chair"))
        {
            Chair c=(Chair)product;
            for(Material bodyMat: c.getBodyMaterials()){
                for(Material seatMat: c.getSeatMaterials()){
                    materials.add(bodyMat.getColor()+" "+bodyMat.getName()+" body, "+seatMat.getColor()+" "+seatMat.getName()+" seat");

                    if(materials.get(index).equals(DataManager.MaterialCache.get(product.getCode())))
                        selectedIndex=index;

                    index++;
                }
            }
        }
        else if(className.equals("Bed")){
            Bed b=(Bed)product;
            for(Material bodyMat: b.getBodyMaterials()){
                for(Material seatMat: b.getSeatMaterials()){
                    materials.add(bodyMat.getColor()+" "+bodyMat.getName()+" body, "+seatMat.getColor()+" "+seatMat.getName()+" seat");

                    if(materials.get(index).equals(DataManager.MaterialCache.get(product.getCode())))
                        selectedIndex=index;

                    index++;
                }
            }
        }
        else if(className.equals("Sofa")){
            Sofa b=(Sofa)product;
            for(Material bodyMat: b.getBodyMaterials()){
                for(Material seatMat: b.getSeatMaterials()){
                    materials.add(bodyMat.getColor()+" "+bodyMat.getName()+" body, "+seatMat.getColor()+" "+seatMat.getName()+" seat");

                    if(materials.get(index).equals(DataManager.MaterialCache.get(product.getCode())))
                        selectedIndex=index;

                    index++;
                }
            }
        }
        else if(className.equals("Commode"))
        {
            for(Material mat: ((Commode)product).materials){
                materials.add(mat.getColor()+" "+mat.getName());

                if(materials.get(index).equals(DataManager.MaterialCache.get(product.getCode())))
                    selectedIndex=index;

                index++;
            }
        }
        else if(className.equals("Table"))
        {
            for(Material mat: ((Table)product).materials){
                materials.add(mat.getColor()+" "+mat.getName());

                if(materials.get(index).equals(DataManager.MaterialCache.get(product.getCode())))
                    selectedIndex=index;

                index++;
            }
        }
        else if(className.equals("BookShelf"))
        {
            for(Material mat: ((BookShelf)product).materials){
                materials.add(mat.getColor()+" "+mat.getName());

                if(materials.get(index).equals(DataManager.MaterialCache.get(product.getCode())))
                    selectedIndex=index;

                index++;
            }
        }
        else if(className.equals("Wardrobe"))
        {
            for(Material mat: ((Wardrobe)product).materials){
                materials.add(mat.getColor()+" "+mat.getName());

                if(materials.get(index).equals(DataManager.MaterialCache.get(product.getCode())))
                    selectedIndex=index;

                index++;
            }
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, materials);
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        materialsSelect.setAdapter(adapter);
        materialsSelect.setSelection(selectedIndex);
    }

    public void loadMetadata(){
        // Metadata
        String md="";
        String className=product.getClass().getSimpleName();

        if(className.equals("Chair")){
            md=((Chair)product).isTurn() ? "Is a swivel chair." : "Not a swivel chair.";
        }
        else if(className.equals("Bed")){
            md="For "+((Bed)product).getCapacity()+" person";
        }
        else if(className.equals("Sofa")){
            Sofa s=(Sofa)product;
            md="For "+s.getPersonCapacity()+" person. ";
            md+=s.hasLegs() ? "Has legs." : "Do not has legs.";

            if(s.isL())
                md+="\nCorner fit sofa.";
        }
        else if(className.equals("Table")){
            Table t=(Table)product;
            md="Has "+t.getNumOfLegs()+" legs.";
            if(t.isExpandable())
                md+="\nExpandable.";
        }
        else if(className.equals("Wardrobe")){
            Wardrobe w=(Wardrobe)product;
            md="Has "+w.getNumOfCabinets()+" cabinets.";
            if(w.isHasLegs())
                md+="\nHas legs.";
        }
        else if(className.equals("Commode")){
            Commode c=(Commode)product;
            md="Has "+c.getNumOfDrawers()+" drawers.";
            if(c.isHasLegs())
                md+="\nHas legs.";
        }
        else if(className.equals("BookShelf")){
            BookShelf bs=(BookShelf)product;
            md="Has "+bs.getNumOfShelves()+" shelves.";
            if(bs.isHasLegs())
                md+="\nHas legs.";
        }

        metadata.setText(md);
    }

    public void loadImage(){
        if(product.getPhotos().size()>0)
        {
            new DownloadImageTask(img).execute(product.getPhotos().get(0));
        }
    }

    public void loadBrowsingHistory(){
        LinearLayout layout = (LinearLayout)findViewById(R.id.browsingHistoryLayout);
        layout.removeAllViews();

        Stack browsingHistory=Login.currentUser.getBrowsingHistory();
        Stack temp=new Stack(browsingHistory.Size());

        while(!browsingHistory.isEmpty()){

            Product p=Login.currentUser.getBrowsed();

            if(!p.getCode().equals(product.getCode()))
            {
                ProductButton b=new ProductButton(this, p);
                layout.addView(b);
            }

            temp.Push(p);
        }

        // Recover
        while(!temp.isEmpty()){
            Login.currentUser.getBrowsingHistory().Push(temp.Pop());
        }
    }

    public void cartButtonClick(View view){
        if(inCart)
            Login.currentUser.removeFromCart(product);
        else
            Login.currentUser.addToCart(product);

        loadProduct();
    }

    public void favButtonClick(View view){
        if(inFavs)
            Login.currentUser.removeFromFavorites(product);
        else
            Login.currentUser.addToFavorites(product);

        loadProduct();
    }

    public void commentsButtonClick(View view){
        startActivity(new Intent(this, Comments.class));
    }


}
