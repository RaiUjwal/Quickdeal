package com.av.mirror.quickdeal.mainpage;

import com.av.mirror.quickdeal.R;

import java.util.ArrayList;

/**
 * Created by hp on 4/20/2017.
 */
public class qddata {
    private static final int[] icons={R.drawable.ic_appareel,R.drawable.ic_auto,R.drawable.ic_electronics,R.drawable.ic_hardware};
        private static final String[] titles={"APPAREL,TEXTILE\n& ACCESSORIES","AUTO &\nTRANSPORTATION","ELECTRONIC &\nAPPLIANCES","HARDWARE &\nTOOLS"};






    public static ArrayList<qdinfo> getListdata(){
        ArrayList<qdinfo> data=new ArrayList<>();

        for(int i=0;i<4;i++){
            for (int j=0;j<titles.length;j++){
                qdinfo item=new qdinfo();
                item.setIconid(icons[j]);
                item.setText(titles[j]);
                data.add(item);
            }
        }
        return data;
    }
}
