package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(@NonNull Context context, @NonNull List<Earthquake> listOfEarthquakes) {
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


        String formattedMagnitude = formatMagnitude(currentEarthquake.getMagnitude());

        magnituteTextView.setText(formattedMagnitude);

        String[] place = splitLocationString(currentEarthquake.getPlace());

        TextView locationOffsetTextView = (TextView) listItemView.findViewById(R.id.location_offset_text_view);
        locationOffsetTextView.setText(place[0]);

        TextView primaryLocationTextView = (TextView) listItemView.findViewById(R.id.primary_location_text_view);
        primaryLocationTextView.setText(place[1]);

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date_text_view);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time_text_view);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String[] splitLocationString(String location) {

        String[] result = new String[2];

        if(location.contains("km")) {
            result = location.split("(?<=of)");
        } else {
            result[0] = "Near the";
            result[1] = location;
        }

        return result;

    }

    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

}
