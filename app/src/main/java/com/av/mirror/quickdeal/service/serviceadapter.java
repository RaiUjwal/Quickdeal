package com.av.mirror.quickdeal.service;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import com.av.mirror.quickdeal.R;

/**
 * Created by hp on 4/23/2017.
 */
public class serviceadapter extends RecyclerView.Adapter<serviceadapter.serviceholder> {

    private LayoutInflater inflater;
    ArrayList<serviceinfo> serviceinfolist=new ArrayList<serviceinfo>();
    Context context;

    public serviceadapter(Context context, ArrayList<serviceinfo> serviceinfolist) {
       inflater=LayoutInflater.from(context);
        this.context = context;
        this.serviceinfolist = serviceinfolist;
    }

    @Override
    public serviceholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_service,parent,false);
        serviceholder sh=new serviceholder(view,context,serviceinfolist);
        return sh;
    }

    @Override
    public void onBindViewHolder(serviceholder holder, int position) {

        serviceinfo current=serviceinfolist.get(position);
        holder.serviceholdertitle.setText(current.servicemaintext);
        holder.serviceholdersubtext.setText(current.servicesubtext);

    }

    @Override
    public int getItemCount() {
        return serviceinfolist.size();
    }





    class serviceholder extends RecyclerView.ViewHolder  {

        TextView serviceholdertitle, serviceholdersubtext;

        Context shctx;
        ArrayList<serviceinfo> si=new ArrayList<serviceinfo>();



        public serviceholder(View itemView,Context ctx,ArrayList<serviceinfo> serviceinfos) {


            super(itemView);
            this.si=serviceinfos;
            this.shctx=ctx;
            this.serviceholdertitle=(TextView) itemView.findViewById(R.id.servicetitle);
            serviceholdersubtext=(TextView)itemView.findViewById(R.id.servicesubtext);
        }


    }
}
