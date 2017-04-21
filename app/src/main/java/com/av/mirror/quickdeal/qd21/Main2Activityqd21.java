package com.av.mirror.quickdeal.qd21;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.av.mirror.quickdeal.R;

public class Main2Activityqd21 extends AppCompatActivity {


    private RecyclerView recyclerview;
    LinearLayout ll;
    qd21recadapter adapter21;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2_activityqd21);

        recyclerview=(RecyclerView)findViewById(R.id.recyc21);
        recyclerview.setLayoutManager(new GridLayoutManager(this,1));
        adapter21= new qd21recadapter(this,qd21data.getListdata());
        recyclerview.setAdapter(adapter21);
        ll=(LinearLayout)findViewById(R.id.ll);
        ll.setBackgroundColor(getResources().getColor(R.color.qd21));
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
