package com.av.mirror.quickdeal.service;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.av.mirror.quickdeal.R;
import com.av.mirror.quickdeal.qd21.Main2Activityqd21;

import java.util.ArrayList;

public class Service extends AppCompatActivity {


    RecyclerView servicerecyclerview;
    serviceadapter serviceadapter;
    private String[] title;
    private String[] subtext;
    ArrayList<serviceinfo> servicedata= new ArrayList<serviceinfo>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_activitychats);
        setTitle("Services");
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }
        int positionqd21=getIntent().getIntExtra("position",0);
        int posmain=getIntent().getIntExtra("pos",0);
        String pos=null;
        String posit=null;

        if(posmain==0){
            pos="Apparel";
            title=this.getResources().getStringArray(R.array.servicetitle_apparel);
            subtext=this.getResources().getStringArray(R.array.servicesubtext_apparel);
        }

        if(posmain==1){
            pos="Auto";
            title=this.getResources().getStringArray(R.array.servicetitle_auto);
            subtext=this.getResources().getStringArray(R.array.servicesubtext_auto);
        }

        if(posmain==2){
            pos="Electronic";
            title=this.getResources().getStringArray(R.array.servicetitle_electronic);
            subtext=this.getResources().getStringArray(R.array.servicesubtext_electronic);
        }

        if(posmain==3){
            pos="Hardware";
            title=this.getResources().getStringArray(R.array.servicetitle_hardware);
            subtext=this.getResources().getStringArray(R.array.servicesubtext_hardware);
        }


        if(positionqd21==0)
        {
        posit="1";

        }



        if(positionqd21==1)
        {
            posit="2";

        }

        if(positionqd21==2)
        {
            posit="3";
        }

        if(positionqd21==3)
        {
            posit="4";
        }

        if(positionqd21==4)
        {
            posit="5";
        }

        if(positionqd21==5)
        {
            posit="6";
        }

        if(positionqd21==6)
        {
            posit="7";
        }



        for(int i=0;i<1;i++){
            for (int j=0;j<title.length;j++){
                serviceinfo item=new serviceinfo();
                String both=pos+" "+posit+" "+title[j];
                item.setServicemaintext(both);
                item.setServicesubtext(subtext[j]);
                servicedata.add(item);
            }
        }

        servicerecyclerview=(RecyclerView)findViewById(R.id.recycchat);
        servicerecyclerview.setLayoutManager(new GridLayoutManager(this,1));
        serviceadapter=new serviceadapter(this,servicedata);
        servicerecyclerview.setAdapter(serviceadapter);
        servicerecyclerview.addOnItemTouchListener(new recyclertouchlistener(Service.this, servicerecyclerview, new ClickListener() {


            @Override
            public void onClick(View view, int position) {

               Toast.makeText(Service.this, "onClick" + position , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(Service.this,"onLongClick"+position,Toast.LENGTH_SHORT).show();
            }
        }));

       }
    static class recyclertouchlistener implements RecyclerView.OnItemTouchListener{

        private GestureDetector gestureDetector;
        private ClickListener clickListener;




//constructor

        public recyclertouchlistener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {

            this.clickListener=clickListener;

            gestureDetector=new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){

                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {

                    View child=recyclerView.findChildViewUnder(e.getX(),e.getY());
                    if(child!=null && clickListener!=null ){

                        clickListener.onLongClick(child,recyclerView.getChildPosition(child));
                    }


                    super.onLongPress(e);
                }
            });
        }





        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {



            View child=rv.findChildViewUnder(e.getX(),e.getY());
            if(child!=null && clickListener!=null && gestureDetector.onTouchEvent(e)){

                clickListener.onClick(child,rv.getChildPosition(child));
            }

            //   gestureDetector.onTouchEvent(e);

            return false;
        }


        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }

    }




    public static interface ClickListener{
        public void onClick(View view,int position);

        public void onLongClick(View view,int position);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
