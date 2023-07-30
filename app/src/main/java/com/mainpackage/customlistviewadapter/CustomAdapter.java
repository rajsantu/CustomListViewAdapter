package com.mainpackage.customlistviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Objects;

public class CustomAdapter extends ArrayAdapter<CoursesModelClass> {

    Context context;

    public CustomAdapter(ArrayList<CoursesModelClass> data, Context context) {
        super(context, R.layout.item_list_layout, data);
        this.context = context;
    }


    // View Lookup Cache
    private static class ViewHolder {
        TextView textView;
        ImageView imageView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {

        // Get the data item for this position
        CoursesModelClass dataModel = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false
            );

            viewHolder.textView = (TextView) convertView.findViewById(androidx.core.R.id.text);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(viewHolder);


        } else {
            viewHolder = (ViewHolder) convertView.getTag();


            // Get the data from the model class
            viewHolder.textView.setText(Objects.requireNonNull(dataModel).getCourseName());
            viewHolder.imageView.setImageResource(dataModel.getIconImg());

        }
        return convertView;
    }
}
