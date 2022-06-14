package com.example.imagedownloaderapp;

public class CategoryModel {

    String catname, catimage;

    public CategoryModel(String catname, String catimage) {
        this.catname = catname;
        this.catimage = catimage;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public String getCatimage() {
        return catimage;
    }

    public void setCatimage(String catimage) {
        this.catimage = catimage;
    }
}
