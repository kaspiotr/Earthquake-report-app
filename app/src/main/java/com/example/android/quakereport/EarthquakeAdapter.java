package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(@NonNull Context context, int resource, @NonNull List<Earthquake> listOfEarthquakes) {
        super(context, 0, listOfEarthquakes);
        // The second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, 0 was used.
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthaquake_list_item, parent, false);
        }
        Earthquake currentEarthquake = (Earthquake) getItem(position);
        TextView magnituteTextView = (TextView) listItemView.findViewById(R.id.magnitute_text_view);
        magnituteTextView.setText(currentEarthquake.getMagnitude());
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location_text_view);
        locationTextView.setText(currentEarthquake.getPlace());
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text_view);
        dateTextView.setText(currentEarthquake.getDate());

        return listItemView;
    }
}
