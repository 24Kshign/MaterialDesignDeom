package com.share.jack.materialdesigndeom.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.share.jack.materialdesigndeom.R;
import com.share.jack.materialdesigndeom.adapter.MyRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 16/10/27.
 */
public class FragmentOne extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FragmentOne", "onCreate");
    }

    private View view;
    private RecyclerView mRecyclerView;
    private MyRecyclerAdapter mAdapter;
    private List<String> mDatas = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("FragmentOne", "onCeView");
        view = inflater.inflate(R.layout.fragment_one, container, false);
        initData();
        initView();
        return view;
    }

    private void initData() {
        for (int i = 0; i < 15; i++) {
            mDatas.add("第一页24K纯帅" + (i + 1));
        }
    }

    public void setDatas(List<String> datas) {
        mDatas.addAll(0, datas);
        mAdapter.notifyDataSetChanged();
    }

    private void initView() {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mAdapter = new MyRecyclerAdapter(getActivity(), mDatas);
        mRecyclerView.setAdapter(mAdapter);
    }
}
