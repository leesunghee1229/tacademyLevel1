package com.begentgroup.samplelist;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.begentgroup.samplelist.data.GroupItem;

/**
 * Created by Administrator on 2016-07-18.
 */
public class GroupViewHolder extends RecyclerView.ViewHolder {
    TextView titleView;
    public GroupViewHolder(View itemView) {
        super(itemView);
        titleView = (TextView)itemView;
        titleView.setBackgroundColor(Color.GREEN);
    }

    public void setGroup(GroupItem groupItem) {
        titleView.setText(groupItem.groupName);
    }
}
