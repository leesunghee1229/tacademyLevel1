package com.begentgroup.samplelist;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Administrator on 2016-07-18.
 */
public class HeaderViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "HeaderViewHolder";
    EditText inputView;
    public HeaderViewHolder(View itemView) {
        super(itemView);
        inputView = (EditText)itemView.findViewById(R.id.edit_input);
        Button btn = (Button)itemView.findViewById(R.id.btn_search);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "input : " + inputView.getText().toString());
            }
        });
    }
}
