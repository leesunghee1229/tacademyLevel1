package com.begentgroup.samplelist;

import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.begentgroup.samplelist.data.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-07-15.
 */
public class RecyclerPersonAdapter extends RecyclerView.Adapter<PersonViewHolder> implements PersonViewHolder.OnPersonItemClickListener {
    List<Person> items = new ArrayList<>();
    SparseBooleanArray itemSelected = new SparseBooleanArray();
    int checkedPosition = INVALID_POSITION;

    public static final int INVALID_POSITION = -1;

    public static final int CHOICE_MODE_SINGLE = 0;
    public static final int CHOICE_MODE_MULTIPLE = 1;

    private int mode = CHOICE_MODE_SINGLE;

    public void add(Person p) {
        items.add(p);
        notifyDataSetChanged();
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_person_recycler, parent, false);
        PersonViewHolder holder = new PersonViewHolder(view);
        holder.setOnPersonItemClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.setPerson(items.get(position));
        if (mode == CHOICE_MODE_SINGLE) {
            holder.setChecked(checkedPosition == position);
        } else {
            holder.setChecked(itemSelected.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface OnAdapterItemClickLIstener {
        public void onAdapterItemClick(View view, Person person, int position);
    }

    OnAdapterItemClickLIstener listener;
    public void setOnAdapterItemClickListener(OnAdapterItemClickLIstener listener) {
        this.listener = listener;
    }

    @Override
    public void onPersonItemClick(View view, Person person, int position) {

        if (mode == CHOICE_MODE_SINGLE) {
            setItemChecked(position, true);
        } else {
            boolean checked = itemSelected.get(position);
            setItemChecked(position, !checked);
        }

        if (listener != null) {
            listener.onAdapterItemClick(view, person, position);
        }
    }

    public SparseBooleanArray getCheckedItemPositions() {
        if (mode == CHOICE_MODE_MULTIPLE) {
            return itemSelected;
        }
        throw new IllegalStateException("invalid mode");
    }

    public int getCheckItemPosition() {
        if (mode == CHOICE_MODE_SINGLE) {
            return checkedPosition;
        }
        throw new IllegalStateException("invalid mode");
    }

    public void setItemChecked(int position, boolean isChecked) {
        if (mode == CHOICE_MODE_SINGLE) {
            if (checkedPosition != position) {
                if (isChecked) {
                    checkedPosition = position;
                    notifyDataSetChanged();
                }
            } else {
                if (!isChecked) {
                    checkedPosition = INVALID_POSITION;
                    notifyDataSetChanged();
                }
            }
        } else {
            boolean checked = itemSelected.get(position);
            if (checked != isChecked) {
                itemSelected.put(position, isChecked);
                notifyDataSetChanged();
            }
        }
    }

    public void clearChecked() {
        itemSelected.clear();
    }
}
