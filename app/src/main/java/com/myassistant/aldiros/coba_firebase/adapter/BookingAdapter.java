package com.myassistant.aldiros.coba_firebase.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myassistant.aldiros.coba_firebase.R;
import com.myassistant.aldiros.coba_firebase.model.bookingModel;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.ViewHolder> {
    Context context;
    private DatabaseReference mUserDatabase;
    List<bookingModel> postList;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView user_name;
        public TextView user_umur;
        public ImageView user_image;
        public LinearLayout llRow;

        public ViewHolder(View itemView) {
            super(itemView);
            user_name = (TextView) itemView.findViewById(R.id.nama);
            user_umur = (TextView) itemView.findViewById(R.id.umur);
            user_image = (ImageView) itemView.findViewById(R.id.image);
            llRow = (LinearLayout) itemView.findViewById(R.id.llRow);
        }
    }

    public BookingAdapter(Context context, List<bookingModel> postList) {
        this.context = context;
        this.postList = postList;
    }

    @Override
    public BookingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_history, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(BookingAdapter.ViewHolder holder, int position) {
        final bookingModel post = postList.get(position);

        holder.user_name.setText(post.getNama()+" ("+post.getMenu().toUpperCase()+")");
        holder.user_umur.setText(post.getUmur());
        Glide.with(context).load(post.getImage()).into(holder.user_image);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }


}
