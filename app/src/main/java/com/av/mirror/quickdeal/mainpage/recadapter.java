package com.av.mirror.quickdeal.mainpage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.av.mirror.quickdeal.R;
import com.av.mirror.quickdeal.qd21.Main2Activityqd21;

import java.util.ArrayList;


public class recadapter extends RecyclerView.Adapter<recadapter.myviewholder> {
    private LayoutInflater inflater;
    ArrayList <qdinfo> listdata= new ArrayList<qdinfo>();
    Context context;
    public recadapter(ArrayList<qdinfo> data,Context context) {
        inflater= LayoutInflater.from(context);
        this.listdata=data;
       this.context=context;
    }

    @Override
    public myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=inflater.inflate(R.layout.customrow,parent,false);

        myviewholder holder=new myviewholder(view,context,listdata);

        return holder;

    }

    @Override
    public void onBindViewHolder(final myviewholder holder, final int position) {
        final qdinfo current=listdata.get(position);

        holder.name.setText(current.text);
        holder.image.setImageResource(current.iconid);

     /*    holder.rel20.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(context,"name:\n"+current.text+"\nposition"+(position%4),Toast.LENGTH_SHORT).show();


             }
         });
*/
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {
        qdinfo item;
        TextView name;
        ImageView image;
        Context ctx;

        ArrayList<qdinfo> qdinf=new ArrayList<qdinfo>();

        public myviewholder(View itemView,Context ctx,ArrayList<qdinfo> qdinf) {
            super(itemView);

            this.ctx=ctx;
            this.qdinf=qdinf;
            name= (TextView) itemView.findViewById(R.id.titleqd1);
            image=(ImageView)itemView.findViewById(R.id.imageqd1);
        }



    }
}
