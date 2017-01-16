package com.begentgroup.samplelist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.begentgroup.samplelist.data.Person;
import com.begentgroup.samplelist.widget.PersonView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-07-13.
 */
public class PersonAdapter extends BaseAdapter implements PersonView.OnImageClickListener {
    List<Person> items = new ArrayList<>();

    public void add(Person p) {
        items.add(p);
        notifyDataSetChanged();
    }

    public void addAll(List<Person> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PersonView view;
        if (convertView == null) {
            view = new PersonView(parent.getContext());
            view.setOnImageClickListener(this);
        } else {
            view = (PersonView)convertView;
        }
        view.setPerson(items.get(position));
        return view;
    }

    public interface OnAdapterImageClickListener {
        public void onAdapterImageClick(PersonAdapter adapter, PersonView view, Person person);
    }

    OnAdapterImageClickListener mAdapterListener;
    public void setOnAdapterImageClickListener(OnAdapterImageClickListener listener) {
        mAdapterListener = listener;
    }

    @Override
    public void onImageClick(PersonView view, Person person) {
        if (mAdapterListener != null) {
            mAdapterListener.onAdapterImageClick(this, view, person);
        }
    }
}
