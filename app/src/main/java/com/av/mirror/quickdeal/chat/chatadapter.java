package com.av.mirror.quickdeal.chat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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



    }

    @Override
    public int getItemCount() {
        return chatinfolist.size();
    }

    class chatholder extends RecyclerView.ViewHolder implements View.OnClickListener {
      TextView titlech,subtext;

      Context ctx;
        ArrayList<chatinfo> chatin=new ArrayList<chatinfo>();

        public chatholder(View itemView,Context ctx,ArrayList<chatinfo> chatinfolist) {
            super(itemView);
            this.ctx=ctx;
            this.chatin=chatinfolist;
            this.titlech=(TextView)itemView.findViewById(R.id.titlechatmsg);
            this.subtext=(TextView)itemView.findViewById(R.id.subtextchatmsg);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            chatinfo ch=this.chatin.get(position);
            Toast.makeText(ctx,"position"+position,Toast.LENGTH_SHORT).show();

        }
    }
}
