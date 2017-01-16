package com.begentgroup.samplelist;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.begentgroup.samplelist.data.Person;
import com.begentgroup.samplelist.widget.PersonView;

public class MainActivity extends AppCompatActivity {

    PersonView personView;
    ImageView photoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        photoView = (ImageView)findViewById(R.id.image_picture);
        photoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                photoView.setVisibility(View.GONE);
            }
        });


        personView = (PersonView)findViewById(R.id.view_person);
        personView.setOnImageClickListener(new PersonView.OnImageClickListener() {
            @Override
            public void onImageClick(PersonView view, Person person) {
                photoView.setImageDrawable(person.getPhoto());
                photoView.setVisibility(View.VISIBLE);
            }
        });

        initData();
    }

    private void initData() {
        Drawable photo = ContextCompat.getDrawable(this, R.drawable.sample_0);

        Person p = new Person("ysi", 42, photo);

        personView.setPerson(p);
    }
}
