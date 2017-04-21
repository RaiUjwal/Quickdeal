package com.av.mirror.quickdeal.chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.av.mirror.quickdeal.R;

public class Main2Activitychats extends AppCompatActivity {
    RecyclerView chatrecyc;
    chatadapter chatadap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_activitychats);


        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }

        chatrecyc=(RecyclerView)findViewById(R.id.recycchat);
        chatrecyc.setLayoutManager(new GridLayoutManager(this,1));
        chatadap=new chatadapter(chatdata.getlistdata(),this);
        chatrecyc.setAdapter(chatadap);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
