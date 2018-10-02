package com.myassistant.aldiros.coba_firebase.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myassistant.aldiros.coba_firebase.R;
import com.myassistant.aldiros.coba_firebase.activity.DetailJobActivity;
import com.myassistant.aldiros.coba_firebase.model.babysitterUser;

import java.util.List;

public class BabysitterAdapter extends RecyclerView.Adapter<BabysitterAdapter.ViewHolder> {
    Context context;
    List<babysitterUser> postList;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView user_name;
        public TextView user_umur;
        public TextView user_gaji;
        public ImageView user_image;
        public TextView user_alamat;
        public LinearLayout llRow;

        public ViewHolder(View itemView) {
            super(itemView);
            user_name = (TextView) itemView.findViewById(R.id.nama);
//            user_umur = (TextView) itemView.findViewById(R.id.umur);
            user_gaji = (TextView) itemView.findViewById(R.id.gaji);
            user_alamat = (TextView) itemView.findViewById(R.id.alamat);
            user_image = (ImageView) itemView.findViewById(R.id.image);
            llRow = (LinearLayout) itemView.findViewById(R.id.llRow);
        }
    }

    public BabysitterAdapter(Context context, List<babysitterUser> postList) {
        this.context = context;
        this.postList = postList;
    }

    @Override
    public BabysitterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_babysitter, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(BabysitterAdapter.ViewHolder holder, int position) {
        final babysitterUser post = postList.get(position);

        holder.user_name.setText(post.getNama());
//        holder.user_umur.setText(post.getUmur());
        holder.user_alamat.setText(post.getAlamat());
        holder.user_gaji.setText(post.getGaji());
        Glide.with(context).load(post.getImage()).into(holder.user_image);
        holder.llRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DetailJobActivity.class);
                i.putExtra("image", post.getImage());
                i.putExtra("nama", post.getNama());
                i.putExtra("umur", post.getUmur());
                i.putExtra("gaji", post.getGaji());
                i.putExtra("lokasi", post.getAlamat());
                i.putExtra("notelp", post.getPhone());
                i.putExtra("desc", post.getDeskripsi());
                i.putExtra("menu", "babysitter");
                i.putExtra("key_menu", post.getKey_menu());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
