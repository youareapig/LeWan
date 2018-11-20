package com.leiwan.zl.bank;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leiwan.zl.R;

import java.util.List;


/**
 * Created by DELL on 2017/8/30.
 */

public class Adapter extends RecyclerView.Adapter {


    private List<String> list;
    private Activity activity;

    public Adapter(List<String> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bank_list_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.bankID.setText("**********"+list.get(position));

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private TextView bankID;


        public ViewHolder(View itemView) {
            super(itemView);
            bankID= (TextView) itemView.findViewById(R.id.item_bankid);
        }
    }





}
