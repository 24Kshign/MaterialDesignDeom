package com.share.jack.materialdesigndeom.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.share.jack.materialdesigndeom.R;

/**
 * Created by Jack on 16/10/27.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView tvContent;

    public MyViewHolder(View itemView) {
        super(itemView);
        tvContent = (TextView) itemView.findViewById(R.id.ir_tv_content);
    }
}
