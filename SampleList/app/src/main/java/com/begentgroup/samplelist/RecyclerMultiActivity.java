package com.begentgroup.samplelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import java.util.Random;

public class RecyclerMultiActivity extends AppCompatActivity {

    RecyclerView listView;
    GroupAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_multi);
        listView = (RecyclerView) findViewById(R.id.rv_list);
        mAdapter = new GroupAdapter();
        listView.setAdapter(mAdapter);
//        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
//        GridLayoutManager manager = new GridLayoutManager(this, 2);
//        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                int viewType = mAdapter.getItemViewType(position);
//                switch (viewType) {
//                    case GroupAdapter.VIEW_TYPE_HEADER:
//                    case GroupAdapter.VIEW_TYPE_GROUP:
//                        return 2;
//                    case GroupAdapter.VIEW_TYPE_CHILD:
//                    default:
//                        return 1;
//                }
//            }
//        });
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        listView.setLayoutManager(manager);

        initData();
    }

    private void initData() {
        Random r = new Random();
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                int size = 20 + r.nextInt(20);
                float textSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, size, metrics);
                mAdapter.put("group" + i, "child:" + i + "," + j, textSize);
            }
        }
    }

}
