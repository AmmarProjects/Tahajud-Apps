package com.uas.tahajudapps.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uas.tahajudapps.R;
import com.uas.tahajudapps.modal.Content;
import com.uas.tahajudapps.viewContent;

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
    public void onBindViewHolder(@NonNull crudContentViewHolder holder, final int position) {
        final Content data = dataList.get(position);
        holder.tvSubtitle.setText(dataList.get(position).getSubtitle());
        holder.tvBody.setText(dataList.get(position).getBody());

        holder.btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, viewContent.class);
                intent.putExtra("key",dataList.get(position).getId());
                intent.putExtra("subtitle",dataList.get(position).getSubtitle());
                intent.putExtra("body",dataList.get(position).getBody());
                intent.putExtra("category",dataList.get(position).getCategory());
                context.startActivity(intent);
                Toast.makeText(context, "You Clicked "+dataList.get(position).getId(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class crudContentViewHolder extends RecyclerView.ViewHolder {
        private TextView tvSubtitle, tvBody;
        private Button btnView;

        public crudContentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSubtitle = (TextView)itemView.findViewById(R.id.subtitle_admin);
            tvBody = (TextView)itemView.findViewById(R.id.body_admin);
            btnView = (Button)itemView.findViewById(R.id.btn_view);
        }
    }
}
