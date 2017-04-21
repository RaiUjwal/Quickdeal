package com.av.mirror.quickdeal.qd21;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.av.mirror.quickdeal.R;

import java.util.ArrayList;


public class qd21recadapter extends RecyclerView.Adapter<qd21recadapter.qd21viewholder>{

    private LayoutInflater inflater;
    ArrayList<qd21info> q21infolist =new ArrayList<qd21info>();
    Context current;

    public qd21recadapter(Context current, ArrayList<qd21info> q21info) {
        inflater= LayoutInflater.from(current);

        this.current = current;
        this.q21infolist = q21info;
    }

    @Override
    public qd21viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.content21,parent,false);
        qd21viewholder q21holder =new qd21viewholder(view,current,q21infolist);

        return q21holder;
    }

    @Override
    public void onBindViewHolder(qd21viewholder holder, final int position) {



        qd21info curent=q21infolist.get(position);
        holder.text.setText(curent.text21);
    }

    @Override
    public int getItemCount() {
        return q21infolist.size();
    }



    class qd21viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView text;
        Context ctx21;
        ArrayList<qd21info> q21inf= new ArrayList<qd21info>();

        public qd21viewholder(View itemView,Context ctx21,ArrayList<qd21info> q21inf) {
            super(itemView);
            this.ctx21=ctx21;
            this.q21inf=q21inf;
            text=(TextView)itemView.findViewById(R.id.qd21text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            qd21info qdin=this.q21inf.get(position);

            Toast.makeText(ctx21,"position"+position,Toast.LENGTH_SHORT).show();

        }
    }

}
