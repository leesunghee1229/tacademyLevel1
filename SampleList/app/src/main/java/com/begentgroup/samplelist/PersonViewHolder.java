package com.begentgroup.samplelist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;

import com.begentgroup.samplelist.data.Person;

/**
 * Created by Administrator on 2016-07-15.
 */
public class PersonViewHolder extends RecyclerView.ViewHolder
        implements Checkable {
    ImageView photoView,checkView;
    TextView nameView, ageView;

    public interface OnPersonItemClickListener {
        public void onPersonItemClick(View view, Person person, int position);
    }

    OnPersonItemClickListener listener;
    public void setOnPersonItemClickListener(OnPersonItemClickListener listener) {
        this.listener = listener;
    }

    public PersonViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onPersonItemClick(v, person, getAdapterPosition());
                }
            }
        });
        photoView = (ImageView)itemView.findViewById(R.id.image_photo);
        nameView = (TextView)itemView.findViewById(R.id.text_name);
        ageView = (TextView)itemView.findViewById(R.id.text_age);
        checkView = (ImageView)itemView.findViewById(R.id.image_check);
    }

    Person person;
    public void setPerson(Person person) {
        this.person = person;
        photoView.setImageDrawable(person.getPhoto());
        nameView.setText(person.getName());
        ageView.setText("" + person.getAge());
    }

    boolean isChecked;
    @Override
    public void setChecked(boolean checked) {
        if (isChecked != checked) {
            isChecked = checked;
            drawCheck();
        }
    }

    private void drawCheck() {
        if (isChecked) {
            checkView.setImageResource(android.R.drawable.checkbox_on_background);
        } else {
            checkView.setImageResource(android.R.drawable.checkbox_off_background);
        }
    }

    @Override
    public boolean isChecked() {
        return isChecked;
    }

    @Override
    public void toggle() {
        setChecked(!isChecked);
    }
}
