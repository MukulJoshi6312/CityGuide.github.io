package com.mukuljoshi.cityguide.HelperClasses.HomeAdapter;

public class MostViewedHelperClass {


    int image;
    String title, description;


    public MostViewedHelperClass(int image, String title) {
        this.image = image;
        this.title = title;
//        this.description = description;
    }

    public int getImageView() {
        return image;
    }

    public String getTextView() {
        return title;
    }

//    public String getDescription() {
//        return description;
//    }


}
