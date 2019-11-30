package com.uas.tahajudapps.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uas.tahajudapps.R;
import com.uas.tahajudapps.modal.User;

import java.util.List;

public class userAdapter extends RecyclerView.Adapter<userAdapter.UserViewHolder> {
    private List<User> dataList;

    public userAdapter(List<User> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.tvNama.setText(dataList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNama;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = (TextView)itemView.findViewById(R.id.nm_user);
        }
    }
}
