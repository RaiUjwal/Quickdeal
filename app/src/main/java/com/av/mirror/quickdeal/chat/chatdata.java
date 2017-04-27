package com.av.mirror.quickdeal.chat;

import com.av.mirror.quickdeal.R;

import java.util.ArrayList;

/**
 * Created by hp on 4/27/2017.
 */
public class chatdata {

    private static String[] title={"Chat title 1","Chat title 2","Chat title 3","Chat title 4","Chat title 5","Chat title 6","Chat title 7"};
    private static String[] subtext={"Chat subtext 1","Chat subtext 2","Chat subtext 3","Chat subtext 4","Chat subtext 5","Chat subtext 6","Chat subtext 7",};


            public static ArrayList<chatinfo> getListdata(){

                ArrayList<chatinfo> data=new ArrayList<>();
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < title.length; j++) {
                        chatinfo itemchat = new chatinfo();
                        itemchat.setChatsubtext(subtext[j]);
                        itemchat.setChattitle(title[j]);
                        data.add(itemchat);


                    }
                }

            return data;}

}
