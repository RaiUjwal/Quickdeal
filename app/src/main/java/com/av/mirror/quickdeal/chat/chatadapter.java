package com.av.mirror.quickdeal.chat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.av.mirror.quickdeal.R;

import java.util.ArrayList;

/**
 * Created by hp on 4/21/2017.
 */
public class chatadapter extends RecyclerView.Adapter<chatadapter.chatholder> {
   private LayoutInflater inflater;
    ArrayList<chatinfo> chatinfolist=new ArrayList<chatinfo>();
    Context context;
        private ItemClickCalBack itemClickCalBack;
    public interface ItemClickCalBack{
        void onItemClick(int p);
        void ondealiconclick(int p);
    }

    public void setItemClickCalBack(final ItemClickCalBack itemClickCalBack){
        this.itemClickCalBack=itemClickCalBack;
    }
    public chatadapter(ArrayList<chatinfo> chatinfolist, Context context) {
       inflater=LayoutInflater.from(context);

        this.chatinfolist = chatinfolist;
        this.context = context;
    }

    @Override
    public chatholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.chat,parent,false);
        chatholder chholder=new chatholder(view,context,chatinfolist);
        return chholder;
    }

    @Override
    public void onBindViewHolder(chatholder holder, int position) {

        chatinfo current=chatinfolist.get(position);
        holder.titlech.setText(current.chattitle);
        holder.subtext.setText(current.chatsubtext);
        if(current.isFav()){
            holder.imagethumb.setImageResource(R.drawable.dealcolor);
        }
        else holder.imagethumb.setImageResource(R.drawable.dealgrey);



    }


   /* public void setListData(ArrayList<chatinfo> info){
        this.chatinfolist.clear();
        this.chatinfolist.addAll(info);
    }*/
    @Override
    public int getItemCount() {
        return chatinfolist.size();
    }






    class chatholder extends RecyclerView.ViewHolder implements View.OnClickListener {
      TextView titlech,subtext;
        ImageView imagethumb;
      Context ctx;
        private View container;
        ArrayList<chatinfo> chatin=new ArrayList<chatinfo>();

        public chatholder(View itemView,Context ctx,ArrayList<chatinfo> chatinfolist) {
            super(itemView);
            this.ctx=ctx;
            this.imagethumb=(ImageView)itemView.findViewById(R.id.BLACKchatmsgimgthumbup);
            this.chatin=chatinfolist;
            this.titlech=(TextView)itemView.findViewById(R.id.titlechatmsg);
            this.subtext=(TextView)itemView.findViewById(R.id.subtextchatmsg);
            imagethumb.setOnClickListener(this);
            container=(View)itemView.findViewById(R.id.llchat);
            container.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.ll){
                itemClickCalBack.onItemClick(getAdapterPosition());
            } else {
                itemClickCalBack.ondealiconclick(getAdapterPosition());
            }

        }
    }
}
