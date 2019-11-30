package com.uas.tahajudapps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uas.tahajudapps.R;
import com.uas.tahajudapps.modal.Content;

import java.util.ArrayList;

public class contentAdapter extends RecyclerView.Adapter<contentAdapter.ContentViewHolder> {
    private ArrayList<Content> dataList;
    Context context;

    public contentAdapter(Context context, ArrayList<Content> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_content, parent, false);
        ContentViewHolder zz = new  ContentViewHolder(view);
        return zz;
    }

    @Override
    public void onBindViewHolder(@NonNull ContentViewHolder holder, int position) {
        final Content data = dataList.get(position);
        holder.tvSubtitle.setText(dataList.get(position).getSubtitle());
        holder.tvBody.setText(dataList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class ContentViewHolder extends RecyclerView.ViewHolder {
        private TextView tvSubtitle, tvBody;

        public ContentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSubtitle = (TextView)itemView.findViewById(R.id.tv_Subtitle);
            tvBody = (TextView)itemView.findViewById(R.id.tv_Content);
        }
    }
}
