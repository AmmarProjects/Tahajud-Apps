package com.uas.tahajudapps.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uas.tahajudapps.R;
import com.uas.tahajudapps.modal.Content;

import java.util.ArrayList;

public class crud_contentAdapter extends RecyclerView.Adapter<crud_contentAdapter.crudContentViewHolder> {
    private ArrayList<Content> dataList;
    Context context;

    public crud_contentAdapter(Context context, ArrayList<Content> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public crudContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_crud_content, parent, false);
        crudContentViewHolder zz = new crudContentViewHolder(view);
        return zz;
    }

    @Override
    public void onBindViewHolder(@NonNull crudContentViewHolder holder, int position) {
        final Content data = dataList.get(position);
        holder.tvSubtitle.setText(dataList.get(position).getSubtitle());
        holder.tvBody.setText(dataList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class crudContentViewHolder extends RecyclerView.ViewHolder {
        private TextView tvSubtitle, tvBody;

        public crudContentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSubtitle = (TextView)itemView.findViewById(R.id.subtitle_admin);
            tvBody = (TextView)itemView.findViewById(R.id.body_admin);
        }
    }
}
