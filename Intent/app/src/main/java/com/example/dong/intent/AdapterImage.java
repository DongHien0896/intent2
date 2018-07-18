package com.example.dong.intent;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterImage extends RecyclerView.Adapter<AdapterImage.ViewHolderImage> {

    private List<String> mListItem;
    private Context mContext;

    public AdapterImage(Context context, List<String> listItem) {
        this.mListItem = listItem;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolderImage onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recyclerview, viewGroup, false);
        return new ViewHolderImage(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderImage viewHolderImage, int i) {
        Glide.with(mContext).load(Constants.PATH + mListItem.get(i))
                .into(viewHolderImage.mImageView);
    }

    @Override
    public int getItemCount() {
        return mListItem == null ? 0 : mListItem.size();
    }

    public class ViewHolderImage extends RecyclerView.ViewHolder {

        ImageView mImageView;

        public ViewHolderImage(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_item);
        }
    }

}
