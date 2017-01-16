package com.begentgroup.samplelist;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.begentgroup.samplelist.data.Person;
import com.begentgroup.samplelist.widget.PersonView;

import java.util.Random;

public class CustomListActivity extends AppCompatActivity {

    ListView listView;
    PersonAdapter mAdapter;
    ImageView pictureView;

    EditText inputView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        listView = (ListView)findViewById(R.id.listView3);

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        View headerView = getLayoutInflater().inflate(R.layout.header_list_item, null);
        inputView = (EditText)headerView.findViewById(R.id.edit_input);
        Button btn = (Button)headerView.findViewById(R.id.btn_search);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = inputView.getText().toString();
                if (!TextUtils.isEmpty(text)) {
                    Toast.makeText(CustomListActivity.this, "input : " + text, Toast.LENGTH_SHORT).show();
                }
            }
        });


        pictureView = (ImageView)findViewById(R.id.image_picture);
        pictureView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pictureView.setVisibility(View.GONE);
            }
        });

        mAdapter = new PersonAdapter();
        mAdapter.setOnAdapterImageClickListener(new PersonAdapter.OnAdapterImageClickListener() {
            @Override
            public void onAdapterImageClick(PersonAdapter adapter, PersonView view, Person person) {
                pictureView.setImageDrawable(person.getPhoto());
                pictureView.setVisibility(View.VISIBLE);
            }
        });
        listView.addHeaderView(headerView, null, false);
        listView.setAdapter(mAdapter);
        initData();
    }

    int[] resIds = {R.drawable.sample_0, R.drawable.sample_1, R.drawable.sample_2,
                R.drawable.sample_3,R.drawable.sample_4, R.drawable.sample_5,
                R.drawable.sample_6,R.drawable.sample_7};

    private void initData() {
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            Person p = new Person();
            p.setName("name " + i);
            p.setAge(20 + r.nextInt(30));
            p.setPhoto(ContextCompat.getDrawable(this, resIds[i % resIds.length]));
            mAdapter.add(p);
        }
    }
}
