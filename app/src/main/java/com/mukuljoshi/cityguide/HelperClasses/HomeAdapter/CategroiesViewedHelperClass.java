package com.mukuljoshi.cityguide.HelperClasses.HomeAdapter;

import android.graphics.drawable.Drawable;

public class CategroiesViewedHelperClass {


    int image;
    String title;
    Drawable drawdable;

    public CategroiesViewedHelperClass(int image, String title,Drawable drawable) {
        this.image = image;
        this.title = title;
       this.drawdable = drawable;
    }

//    public int getImageView() {
//        return image;
//    }
//
//    public String getTextView() {
//        return title;
//    }

//    public String getDescription() {
//        return description;
//    }




    public int getImage() {
        return image;
    }

    public String getText() {
        return title;
    }

    public Drawable getGradient() {
        return drawdable;
    }
}
