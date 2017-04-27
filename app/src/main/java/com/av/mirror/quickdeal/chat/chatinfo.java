package com.av.mirror.quickdeal.chat;

/**
 * Created by hp on 4/21/2017.
 */
public class chatinfo {
    public String chattitle,chatsubtext;
    public int chatimageid;
    private boolean fav=false;

    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }

    public int getImageid() {
        return chatimageid;
    }

    public void setImageid(int imageid) {
        this.chatimageid = imageid;
    }

    public String getChatsubtext() {
        return chatsubtext;
    }

    public void setChatsubtext(String chatsubtext) {
        this.chatsubtext = chatsubtext;
    }

    public String getChattitle() {
        return chattitle;
    }

    public void setChattitle(String chattitle) {
        this.chattitle = chattitle;
    }
}
