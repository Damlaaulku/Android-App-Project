package com.furkanenes.oop.components;

import android.content.Context;
import android.widget.TextView;

import com.furkanenes.oop.models.Comment;
import com.furkanenes.oop.models.User;

public class CommentView extends androidx.appcompat.widget.AppCompatTextView {

    public Comment comment;

    public CommentView(Context context) {
        super(context);
    }

    public CommentView(Context context, Comment comment){
        super(context);
        this.comment=comment;
        this.setPadding(60, 0,80,0);

        User user=comment.getUser();

        String str="";

        str+=comment.getDate()+"\n";
        str+=user.getFirstName()+" "+user.getLastName()+"\n";
        str+=comment.getRating()+"/5\n\n";
        str+=comment.getTitle()+"\n";
        str+=comment.getContent()+"\n_______________\n";

        this.setText(str);
    }


}
