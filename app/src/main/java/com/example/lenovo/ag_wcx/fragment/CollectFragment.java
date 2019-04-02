package com.example.lenovo.ag_wcx.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.ag_wcx.R;
import com.example.lenovo.ag_wcx.adapter.Collect_Adapter;
import com.example.lenovo.ag_wcx.bean.Item;
import com.example.lenovo.ag_wcx.util.DbUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectFragment extends Fragment {


    private View view;
    private RecyclerView mRecv;

    private ArrayList<Item> items = new ArrayList<>();
    private Collect_Adapter collect_adapter;

    public CollectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_collect, container, false);
        initView(inflate);
        return inflate;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()){
            query();
        }else {
            items.clear();
        }
    }

    private void query() {
        List<Item> list = DbUtils.getDbUtils().queryAll();

        items.addAll(list);

        collect_adapter.setItems(items);
        collect_adapter.notifyDataSetChanged();
    }

    private void initView(View inflate) {

        mRecv = (RecyclerView) inflate.findViewById(R.id.recv);

        mRecv.setLayoutManager(new LinearLayoutManager(getContext()));

        collect_adapter = new Collect_Adapter(items, getContext());

        mRecv.setAdapter(collect_adapter);
    }
}
