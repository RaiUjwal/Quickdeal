package com.av.mirror.quickdeal.chat;

import java.util.ArrayList;

/**
 * Created by hp on 4/21/2017.
 */
public class chatdata {

    private static String[] titledata = {"COMPANY1", "COMPANY2", "COMPANY3", "COMPANY4", "COMPANY5", "COMPANY6", "COMPANY7"};
    private static String[] subtextdata = {"Subtext1", "Subtext2", "Subtext3", "Subtext4", "Subtext5", "Subtext6", "Subtext7"};

    public static ArrayList<chatinfo> getlistdata() {
        ArrayList<chatinfo> data = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < titledata.length; j++) {
                chatinfo item = new chatinfo();
                item.setChattitle(titledata[j]);
                item.setChatsubtext(subtextdata[j]);
                data.add(item);


            }
        }
        return data;
    }
}

