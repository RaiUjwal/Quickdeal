package com.av.mirror.quickdeal.qd21;

import java.util.ArrayList;

/**
 * Created by hp on 4/20/2017.
 */
public class qd21data {

    private static String[] textq21={"text20","text21","text22","text23","text24","text25","text26","text27"};


    public static ArrayList<qd21info> getListdata() {
        ArrayList<qd21info> data = new ArrayList<>();
        for(int i=0;i<1;i++){
            for (int j=0;j<textq21.length;j++){
            qd21info item=new qd21info();
                item.setText(textq21[j]);
                data.add(item);


            }
        }

        return data;

    }

}
