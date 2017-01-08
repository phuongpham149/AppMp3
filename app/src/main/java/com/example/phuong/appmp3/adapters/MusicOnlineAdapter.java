package com.example.phuong.appmp3.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.phuong.appmp3.R;
import com.example.phuong.appmp3.models.MusicOnline;

import java.util.List;

/**
 * Created by phuong on 08/01/2017.
 */

public class MusicOnlineAdapter extends RecyclerView.Adapter<MusicOnlineAdapter.MyHolder> {
    private List<MusicOnline> mMusics;
    private Context mContext;
    private onItemClickListener mListener;

    public MusicOnlineAdapter(List<MusicOnline> mMusics, Context mContext, onItemClickListener listener) {
        this.mMusics = mMusics;
        this.mContext = mContext;
        mListener = listener;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_music_online, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        MusicOnline musicOnline = mMusics.get(position);
        holder.mTvName.setText(musicOnline.getName());
        holder.mTvSinger.setText(musicOnline.getSinger());
        holder.mTvDuration.setText(musicOnline.getDuration());
        holder.mCardview.setCardBackgroundColor(mContext.getResources().getColor(R.color.item_music_background));
    }

    @Override
    public int getItemCount() {
        return mMusics.size();
    }

    public interface onItemClickListener {
        void itemClickListener(int position);
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private TextView mTvName;
        private TextView mTvSinger;
        private TextView mTvDuration;
        private CardView mCardview;

        public MyHolder(View itemView) {
            super(itemView);
            mTvName = (TextView) itemView.findViewById(R.id.tvNameSong);
            mTvSinger = (TextView) itemView.findViewById(R.id.tvSinger);
            mTvDuration = (TextView) itemView.findViewById(R.id.tvDuration);
            mCardview = (CardView) itemView.findViewById(R.id.cardview_online);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.itemClickListener(getAdapterPosition());
                }
            });
        }
    }
}
