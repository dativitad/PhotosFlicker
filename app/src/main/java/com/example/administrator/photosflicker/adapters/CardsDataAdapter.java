package com.example.administrator.photosflicker.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.administrator.photosflicker.R;

import java.util.List;

/**
 * Created by Administrator on 24.12.2016.
 */

public class CardsDataAdapter extends ArrayAdapter<String> {

    public CardsDataAdapter(Context context, List<String> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        String imageUrl = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_card_layout, parent, false);
        }
        TextView v = (TextView)(convertView.findViewById(R.id.textContent));
        v.setText(imageUrl);
        return convertView;
    }
}
