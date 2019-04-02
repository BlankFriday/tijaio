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
import com.example.lenovo.ag_wcx.bean.ItemTest;

import java.util.ArrayList;

public class Home_Adapter extends RecyclerView.Adapter<Home_Adapter.ViewHolder> {
    private ArrayList<ItemTest> newList;
    private Context context;

    public Home_Adapter(ArrayList<ItemTest> newList, Context context) {
        this.newList = newList;
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
        ItemTest test = newList.get(position);
        holder.iv.setImageResource(test.getImg());
        holder.tvName.setText(test.getName());
        holder.tvAge.setText(test.getAge()+"");

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (myLongClick !=null){
                    myLongClick.longClick(position);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return newList.size();
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
    private MyLongClick myLongClick;

    public void setNewList(ArrayList<ItemTest> newList) {
        this.newList = newList;
    }

    public void setMyLongClick(MyLongClick myLongClick) {
        this.myLongClick = myLongClick;
    }

    public interface MyLongClick{
        void longClick(int position);
    }
}
