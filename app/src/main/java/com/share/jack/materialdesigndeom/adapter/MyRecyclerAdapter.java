package com.share.jack.materialdesigndeom.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.share.jack.materialdesigndeom.R;
import com.share.jack.materialdesigndeom.viewholder.MyViewHolder;

import java.util.List;

/**
 * Created by Jack on 16/10/27.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context mContext;
    private List<String> mList;

    public MyRecyclerAdapter(Context mContext, List<String> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recycler, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvContent.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
