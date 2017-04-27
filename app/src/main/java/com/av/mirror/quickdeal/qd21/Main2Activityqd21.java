package com.av.mirror.quickdeal.qd21;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.av.mirror.quickdeal.R;
import com.av.mirror.quickdeal.chat.Main2Activitychats;
import com.av.mirror.quickdeal.service.Service;

import java.util.ArrayList;

public class Main2Activityqd21 extends AppCompatActivity {



    private RecyclerView recyclerview;
    LinearLayout ll;
    qd21recadapter adapter21;
    private String[] qd21text;
int pos;
    ArrayList<qd21info> qd21data= new ArrayList<qd21info>();
    @Override



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2_activityqd21);
        int posqtoq21=getIntent().getIntExtra("position",0);

        if(posqtoq21==0) {
            pos=0;
            qd21text = this.getResources().getStringArray(R.array.apparel);
            setTitle("Apparel");
        }
        if(posqtoq21==1) {
            pos=1;
            qd21text = this.getResources().getStringArray(R.array.auto);
            setTitle("Auto");
        }
        if(posqtoq21==2) {
            pos=2;
            qd21text = this.getResources().getStringArray(R.array.electronic);
            setTitle("Electronic");
        }
        if(posqtoq21==3) {
            pos=3;
            qd21text = this.getResources().getStringArray(R.array.hardware);
            setTitle("Hardware");
        }
        for(int i=0;i<1;i++){
            for (int j=0;j<qd21text.length;j++){
                qd21info item21=new qd21info();
                item21.setText(qd21text[j]);
                qd21data.add(item21);

            }
        }

        recyclerview=(RecyclerView)findViewById(R.id.recyc21);
        recyclerview.setLayoutManager(new GridLayoutManager(this,1));
        adapter21= new qd21recadapter(this,qd21data);
        recyclerview.setAdapter(adapter21);
        recyclerview.addOnItemTouchListener(new recyclertouchlistener(Main2Activityqd21.this, recyclerview, new ClickListener() {


            @Override
            public void onClick(View view, int position) {
                Intent in=new Intent(Main2Activityqd21.this, Service.class);
                in.putExtra("position",position);
                in.putExtra("pos",pos);
                startActivity(in);
                Toast.makeText(Main2Activityqd21.this, "onClick" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Intent in=new Intent(Main2Activityqd21.this, Service.class);
                in.putExtra("position",position);
                startActivity(in);
                Toast.makeText(Main2Activityqd21.this,"onLongClick"+position,Toast.LENGTH_SHORT).show();
            }
        }));
        ll=(LinearLayout)findViewById(R.id.ll);
        ll.setBackgroundColor(getResources().getColor(R.color.qd21));



        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }

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
