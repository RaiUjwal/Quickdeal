package com.av.mirror.quickdeal.mainpage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.av.mirror.quickdeal.R;
import com.av.mirror.quickdeal.chat.Main2Activitychats;
import com.av.mirror.quickdeal.qd21.Main2Activityqd21;
import com.av.mirror.quickdeal.service.Service;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    recadapter adapter;
    private GoogleApiClient client;
    private int[] icons={R.drawable.ic_appareel,R.drawable.ic_auto,R.drawable.ic_electronics,R.drawable.ic_hardware};;
    private String[] titles;

    ArrayList<qdinfo> data=new ArrayList<qdinfo>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        titles=this.getResources().getStringArray(R.array.quickdeal);


        for(int i=0;i<4;i++) {
            for (int j = 0; j < titles.length; j++) {
            qdinfo item=new qdinfo();
                item.setIconid(icons[j]);
                item.setText(titles[j]);
                data.add(item);
            }
        }
        recyclerview=(RecyclerView)findViewById(R.id.recyc);
        recyclerview.setLayoutManager(new GridLayoutManager(this,2));
        adapter=new recadapter(data,this);
        recyclerview.setAdapter(adapter);
        recyclerview.addOnItemTouchListener(new recyclertouchlistener(MainActivity.this, recyclerview, new ClickListener() {


            @Override
            public void onClick(View view, int position) {

                Intent in=new Intent(MainActivity.this,Main2Activityqd21.class);
                in.putExtra("position",position%4);
                startActivity(in);
                Toast.makeText(MainActivity.this,"onClick"+position%4,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Intent in=new Intent(MainActivity.this,Main2Activityqd21.class);
                in.putExtra("position",position%4);
                startActivity(in);
                Toast.makeText(MainActivity.this,"onLongClick"+position,Toast.LENGTH_SHORT).show();
            }
        }));


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.pencil);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.chat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.chattaskbar) {
            Intent in=new Intent(MainActivity.this,Main2Activitychats.class);
            startActivity(in);
            return true;
        }
        if (id == R.id.persontaskbar) {
            Toast.makeText(MainActivity.this,"Contacts",Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.av.mirror.quickdeal/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.av.mirror.quickdeal/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
