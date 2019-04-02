package com.example.lenovo.ag_wcx.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.ag_wcx.R;
import com.example.lenovo.ag_wcx.adapter.Home_Adapter;
import com.example.lenovo.ag_wcx.bean.Item;
import com.example.lenovo.ag_wcx.bean.ItemTest;
import com.example.lenovo.ag_wcx.util.DbUtils;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements Home_Adapter.MyLongClick {


    private View view;
    private RecyclerView mRecv;
    private ArrayList<ItemTest> newList;
    private Home_Adapter home_adapter;

    private int index;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        ArrayList<ItemTest> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new ItemTest(R.mipmap.ic_launcher,"大黄"+i,i));
        }

        newList.addAll(list);
        home_adapter.setNewList(newList);
        home_adapter.notifyDataSetChanged();
    }

    private void initView(View inflate) {
        newList = new ArrayList<>();
        mRecv = (RecyclerView) inflate.findViewById(R.id.recv);

        mRecv.setLayoutManager(new LinearLayoutManager(getContext()));

        home_adapter = new Home_Adapter(newList, getContext());
        mRecv.setAdapter(home_adapter);

        registerForContextMenu(mRecv);

        home_adapter.setMyLongClick(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0,1,0,"收藏");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        ItemTest itemTest = newList.get(index);
        Item item1 = new Item();
        item1.setAge(itemTest.getAge());
        item1.setId(null);
        item1.setImg(itemTest.getImg());
        item1.setName(itemTest.getName());
        DbUtils.getDbUtils().insert(item1);
        return super.onContextItemSelected(item);
    }

    @Override
    public void longClick(int position) {
        index = position;
    }
}
