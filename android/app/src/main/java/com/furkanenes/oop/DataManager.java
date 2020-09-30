package com.furkanenes.oop;

import com.furkanenes.oop.models.Bed;
import com.furkanenes.oop.models.BookShelf;
import com.furkanenes.oop.models.Brand;
import com.furkanenes.oop.models.Campaign;
import com.furkanenes.oop.models.Cargo;
import com.furkanenes.oop.models.Category;
import com.furkanenes.oop.models.Chair;
import com.furkanenes.oop.models.Commode;
import com.furkanenes.oop.models.Coupon;
import com.furkanenes.oop.models.Material;
import com.furkanenes.oop.models.Order;
import com.furkanenes.oop.models.Product;
import com.furkanenes.oop.models.Size;
import com.furkanenes.oop.models.Sofa;
import com.furkanenes.oop.models.Table;
import com.furkanenes.oop.models.User;
import com.furkanenes.oop.models.Wardrobe;

import java.util.ArrayList;
import java.util.HashMap;

public class DataManager {

    public static HashMap<String, String> MaterialCache=new HashMap<String, String>();



    public static void GenerateDummyData(){

        // Users
        User user1=new User(
                222,
                "Furkan Enes",
                "Apaydın",
                "1234",
                "5556667799",
                "test@ceng.deu.edu.tr"
        );

        User user2=new User(
                333,
                "Damla",
                "Ülkü",
                "1234",
                "5556667799",
                "test@ceng.deu.edu.tr"
        );

        user2.addAddress("ev","Izmir", "Buca","Ataturk", "Tınaztepe");

        User user3=new User(
                444,
                "Robert",
                "de Niro",
                "1234",
                "5556667799",
                "test@ceng.deu.edu.tr"
        );


        // Categories
        Category sofas=new Category("Sofa", null);
        Category beds=new Category("Bed", null);
        Category commodes=new Category("Commode", null);
        Category tables=new Category("Table", null);
        Category chairs=new Category("Chair", null);
        Category bookshelves=new Category("Bookshelf", null);
        Category wardrobes=new Category("Wardrobe", null);


        // Brands
        Brand b1=new Brand("Furkan Mobilya");
        Brand b2=new Brand("Damla Mobilya");
        Brand b3=new Brand("MVoice");
        Brand b4=new Brand("Sirius Design");
        Brand b5=new Brand("Venture");
        Brand b6=new Brand("DEU Mobilya A.Ş.");

        // Materials
        Material m1=new Material("Wood", "Gray");
        Material m2=new Material("Wood", "Blue");
        Material m3=new Material("Wood", "Green");
        Material m4=new Material("Wood", "Yellow");
        Material m4w=new Material("Wood", "White");
        Material m4b=new Material("Wood", "Brown");

        Material m5=new Material("Wool", "Gray");
        Material m6=new Material("Wool", "Black");
        Material m7=new Material("Wool", "White");

        Material m8=new Material("Plastic", "Red");
        Material m9=new Material("Plastic", "White");
        Material m10=new Material("Plastic", "Green");
        Material m11=new Material("Plastic", "Blue");
        Material m12=new Material("Plastic", "Orange");

        Material m13=new Material("Iron","Black");


        // Cargo
        Cargo c1=new Cargo("Aras Kargo", "www.araskargo.com", 10);
        Cargo c2=new Cargo("Yurtiçi Kargo", "www.yurticikargo.com", 9);
        Cargo c3=new Cargo("MNG Kargo", "www.mng.com.tr", 11);


        // Campaigns
        Campaign campaign30=new Campaign("New Year Discount", "01 Jan 2020", "30 Jan 2020", 30);


        // Products
        Chair p1=new Chair(29.5f, "C15567", "Small Wooden Chair", "A small wooden chair designed for children.", b3);
        p1.addToPhotos("https://www.ikea.com/us/en/images/products/stefan-chair-brown-black__0727320_PE735593_S5.JPG?f=s");
        p1.addToCategory(chairs);
        p1.setSize(new Size(30,30,60));
        p1.addBodyMaterial(m1);
        p1.addBodyMaterial(m2);
        p1.addBodyMaterial(m3);
        p1.addBodyMaterial(m4);
        p1.addSeatMaterial(m5);
        p1.addSeatMaterial(m6);
        p1.addSeatMaterial(m7);

        Table p2=new Table(499.99f, "T65975", "Elite Table", "A customized diamond table for special occaisons.", b3, 6, true);
        p2.addToPhotos("https://images-na.ssl-images-amazon.com/images/I/71zqODZipfL._AC_SX679_.jpg");
        p2.addToCategory(tables);
        p2.setSize(new Size(200,60,60));
        p2.addMaterial(m1);
        p2.addMaterial(m2);
        p2.addMaterial(m4);
        p2.addToCampaigns(campaign30);
        p2.addToComments(user3,5, "Amazing product", "Cheers from LV");
        p2.addToComments(user1,4, "Not bad!", "A bit expensive to be honest. Not everybody is de-niro-rich anyway!");

        BookShelf p3 = new BookShelf(89.99f,"B9952","Modern Shelf With 5 Shelves","A stylish library that will suit every corner of your home",b2);
        p3.addToPhotos("https://mcdn01.gittigidiyor.net/51928/tn50/519282684_tn50_0.jpg?1589934");
        p3.addToCategory(bookshelves);
        p3.setSize(new Size(56,169,20));
        p3.setNumOfShelves(5);
        p3.addMaterial(m4w);
        p3.addToCampaigns(campaign30);
        p3.addToComments(user2,5,"So chic!","The price is very affordable for such a stylish bookcase and it suits my house :)");

        Wardrobe p4 =new Wardrobe(189.99f,"W3678","Shale Wardrobe","Layers of clean details. Warm wood and full grain leather pulls add storage panache and practicality to any bedroom or entryway.",b6,2,true);
        p4.addToPhotos("https://res-4.cloudinary.com/dwpujv6in/image/upload/c_pad,dpr_2.0,f_auto,h_930,q_auto,w_930/v1/media/catalog/product/s/h/sh1_cabnet_sk.2x_mobile_2.jpg");
        p4.addToCategory(wardrobes);
        p4.setSize(new Size(430,180,80));
        p4.addMaterial(m4b);
        p4.addMaterial(m4w);
        p4.addMaterial(m13);

        Sofa p5 = new Sofa(1.999f,"S2269","KIVIK","3-seat sofa, hillared anthracite",b1);
        p5.addToPhotos("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTkQGPPArst3saHJI7q1wwSrb5rpn8Kv9-fK8vQXUi-2dXqn5HV&usqp=CAU");
        p5.addToCategory(sofas);
        p5.setSize(new Size(228,83,228));
        p5.setPersonCapacity(3);
        p5.addBodyMaterial(m13);
        p5.addSeatMaterial(m5);
        p5.addSeatMaterial(m6);
        p5.addSeatMaterial(m7);

        Bed p6 = new Bed(899f,"B9876","TARVA","double bed, pine",b5,2);
        p6.addToPhotos("https://cdn.ikea.com.tr/urunler/2000_2000/PE327865.jpg");
        p6.addToCategory(beds);
        p6.setSize(new Size(148 ,95,200));
        p6.addBodyMaterial(m4b);
        p6.addSeatMaterial(m7);
        p6.addToComments(user2,4,"Not Bad","It looks very stylish and simple, the price is also good. It just doesn't look solid enough.");

        Commode p7 =new Commode(99.99f,"C12340","MALM","Commode 3 tiroirs, blanc brillant blanc",b5);
        p7.addToPhotos("https://www.ikea.com/fr/fr/images/products/malm-chest-of-3-drawers-high-gloss-white__0496829_PE628825_S5.JPG?f=s");
        p7.addToCategory(commodes);
        p7.setSize(new Size(80,70,40));
        p7.setNumOfDrawers(3);
        p7.addMaterial(m8);
        p7.addMaterial(m9);
        p7.addMaterial(m10);
        p7.addMaterial(m11);

        //Coupons
        ArrayList<Category> coupons = new ArrayList<Category>();
        coupons.add(tables);
        coupons.add(chairs);
        Coupon co1 = new Coupon("1234", 20,0,coupons);

        // Orders
        ArrayList<Product> productlist = new ArrayList<Product>();
        productlist.add(p1);
        productlist.add(p2);

        Order o1 = new Order(productlist,c3.getPrice(),"Credit Cart",c3,0,user2,user2.getAddresses().get(0),co1);

    }


}
