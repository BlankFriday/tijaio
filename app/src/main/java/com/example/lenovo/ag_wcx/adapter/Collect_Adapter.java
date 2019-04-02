package com.example.lenovo.ag_wcx.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.ag_wcx.R;
import com.example.lenovo.ag_wcx.bean.Item;
import com.example.lenovo.ag_wcx.bean.ItemTest;

import java.util.ArrayList;

public class Collect_Adapter extends RecyclerView.Adapter<Collect_Adapter.ViewHolder> {
    private ArrayList<Item> items;
    private Context context;

    public Collect_Adapter(ArrayList<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Item item = items.get(position);
        holder.iv.setImageResource(item.getImg());
        holder.tvName.setText(item.getName());
        holder.tvAge.setText(item.getAge()+"");


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tvName;
        private TextView tvAge;
        public ViewHolder(View itemView) {
            super(itemView);


            iv = itemView.findViewById(R.id.iv);
            tvName = itemView. findViewById(R.id.tv_name);
            tvAge = itemView.findViewById(R.id.tv_age);

        }
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }


}
