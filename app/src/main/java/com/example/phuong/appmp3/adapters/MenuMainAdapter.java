package com.example.phuong.appmp3.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.phuong.appmp3.R;
import com.example.phuong.appmp3.listeners.ItemMenuClickListener;
import com.example.phuong.appmp3.models.MenuItem;

import java.util.List;

/**
 * Created by phuong on 07/01/2017.
 */

public class MenuMainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ITEM_HEADER = 0;
    private static final int ITEM_CONTENT = 1;
    private List mMenuItems;
    private Context mContext;
    private ItemMenuClickListener mListener;

    public MenuMainAdapter(List mMenuItems, Context mContext, ItemMenuClickListener listener) {
        this.mMenuItems = mMenuItems;
        this.mContext = mContext;
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case ITEM_CONTENT:
                View contentItem = inflater.inflate(R.layout.item_menu_content, parent, false);
                viewHolder = new MyViewHolder(contentItem);
                break;
            case ITEM_HEADER:
                View headerItem = inflater.inflate(R.layout.item_menu_header, parent, false);
                viewHolder = new HeaderHolder(headerItem);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case ITEM_CONTENT:
                MyViewHolder mMyViewHolder = (MyViewHolder) holder;
                final MenuItem mMenuItem = (MenuItem) mMenuItems.get(position);
                mMyViewHolder.mTvTitle.setText(mMenuItem.getTitle());
                mMyViewHolder.mImgIcon.setImageResource(mMenuItem.getIdImage());
                break;
        }

    }

    @Override
    public int getItemCount() {
        return mMenuItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mMenuItems.get(position) instanceof MenuItem) {
            return ITEM_CONTENT;
        }
        if (mMenuItems.get(position) instanceof String) {
            return ITEM_HEADER;
        }
        return -1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImgIcon;
        private TextView mTvTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            mImgIcon = (ImageView) itemView.findViewById(R.id.imgIcon);
            mTvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        }
    }

    public class HeaderHolder extends RecyclerView.ViewHolder {
        private ImageView mImvHeader;

        public HeaderHolder(View itemView) {
            super(itemView);
            mImvHeader = (ImageView) itemView.findViewById(R.id.imgIcon);
        }
    }
}
