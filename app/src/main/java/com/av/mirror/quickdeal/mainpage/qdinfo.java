package com.av.mirror.quickdeal.mainpage;

import android.widget.RelativeLayout;

/**
 * Created by hp on 4/20/2017.
 */
public class qdinfo {

   public int iconid;
   public String text;

    RelativeLayout rel;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIconid() {
        return iconid;
    }

    public void setIconid(int iconid) {
        this.iconid = iconid;
    }
}
