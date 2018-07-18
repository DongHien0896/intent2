package com.example.dong.intent;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterFolder extends RecyclerView.Adapter<AdapterFolder.ViewHolderFolder> {

    private List<ItemImage> mListFolder;
    private Context mContext;

    public AdapterFolder(List<ItemImage> listFolder, Context context) {
        this.mListFolder = listFolder;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolderFolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recyclerview, viewGroup, false);
        return new ViewHolderFolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFolder viewHolderFolder, int i) {
        viewHolderFolder.mTextViewNameFolder.setText(mListFolder.get(i).getNameFolder());
        viewHolderFolder.mTextViewNumberImage.setText(mListFolder.get(i).getListPathImage().size() + Constants.STRING_EMPTY);
        Glide.with(mContext).load(Constants.PATH + mListFolder.get(i).getListPathImage().get(Constants.FOLDER_FIRST))
                .into(viewHolderFolder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mListFolder == null ? 0 : mListFolder.size();
    }


    public class ViewHolderFolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView mImageView;
        TextView mTextViewNameFolder;
        TextView mTextViewNumberImage;

        public ViewHolderFolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_item);
            mTextViewNameFolder = itemView.findViewById(R.id.text_name_folder);
            mTextViewNumberImage = itemView.findViewById(R.id.text_number_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, ActivityImage.class);
            intent.putExtra(Constants.VALUE, mListFolder.get(getPosition()).getListPathImage());
            mContext.startActivity(intent);
        }
    }
}
