package com.furkanenes.oop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.furkanenes.oop.components.CommentView;
import com.furkanenes.oop.models.Comment;
import com.furkanenes.oop.models.Product;

public class Comments extends AppCompatActivity {

    public Product product;

    Button addCommentButton;
    EditText commentText, commentTitle;
    Spinner ratingSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        this.product=ProductDetail.product;

        addCommentButton=(Button)findViewById(R.id.addButton);
        commentText=(EditText)findViewById(R.id.commentDetails);
        commentTitle=(EditText)findViewById(R.id.commentTitle);
        ratingSpinner=(Spinner)findViewById(R.id.spinner);

        String[] ratings = {"1", "2", "3", "4", "5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, ratings);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ratingSpinner.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadComments();
    }

    public void loadComments(){
        LinearLayout commentsLayout=(LinearLayout)findViewById(R.id.commentsLayout);
        commentsLayout.removeAllViews();

        for(Comment comment: product.getComments()){
            CommentView cw=new CommentView(this, comment);
            commentsLayout.addView(cw);
        }
    }


    public void addCommentButtonClick(View view){
        String details=commentText.getText().toString();
        String title=commentTitle.getText().toString();
        int rating=Integer.parseInt(ratingSpinner.getSelectedItem().toString());

        product.addToComments(Login.currentUser, rating, title, details);

        commentText.setText("");
        commentTitle.setText("");

        loadComments();
    }
}
