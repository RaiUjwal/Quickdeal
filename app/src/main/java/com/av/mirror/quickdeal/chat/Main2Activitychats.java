package com.av.mirror.quickdeal.chat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.av.mirror.quickdeal.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class Main2Activitychats extends AppCompatActivity implements chatadapter.ItemClickCalBack{
    RecyclerView chatrecyc;
    chatadapter chatadap;
    private ArrayList listdata;
    private static final String BUNDEL_EXTRAS="BUNDEL_EXTRAS";
    private static final String EXTRA_QUOTE="EXTRA_QUOTE";
    private static final String EXTRA_ATTR="EXTRA_ATTR";
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_activitychats);

        setTitle("Chats");

        listdata=(ArrayList)chatdata.getListdata();
        chatrecyc = (RecyclerView) findViewById(R.id.recycchat);
        chatrecyc.setLayoutManager(new GridLayoutManager(this, 1));
        chatadap = new chatadapter(listdata, this);
        chatrecyc.setAdapter(chatadap);


        chatadap.setItemClickCalBack(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(int p) {
        chatinfo item=(chatinfo)listdata.get(p);
        Toast.makeText(Main2Activitychats.this,"onItemClick",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ondealiconclick(final int p) {
        View v= LayoutInflater.from(Main2Activitychats.this).inflate(R.layout.activity_chat2,null);
        AlertDialog.Builder builder=new AlertDialog.Builder(Main2Activitychats.this);
        ImageView yesbutton=(ImageView)v.findViewById(R.id.yes);
        ImageView notbutton=(ImageView)v.findViewById(R.id.notyet);

        yesbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chatinfo item = (chatinfo) listdata.get(p);

                 item.setFav(true);

                // chatadap.setListData(listdata);
                chatadap.notifyDataSetChanged();

                Toast.makeText(Main2Activitychats.this,"Congratulations!!",Toast.LENGTH_SHORT).show();
            }
        });
        notbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chatinfo item = (chatinfo) listdata.get(p);

                    item.setFav(false);


                // chatadap.setListData(listdata);
                chatadap.notifyDataSetChanged();


                Toast.makeText(Main2Activitychats.this,"You can take your time.",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setView(v);
        AlertDialog dialog=builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }
}
