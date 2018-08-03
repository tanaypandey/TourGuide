package com.example.android.tourguide;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;



public class local_transport_fragment extends Fragment {

    public local_transport_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.transport_list, container, false);

        //create arraylist
        final ArrayList<transport_items> transport_item = new ArrayList<transport_items>();
        transport_item.add(new transport_items(R.string.rickshaw, R.string.rickshaw_description,
                R.drawable.rickshaw));
        transport_item.add(new transport_items(R.string.scooter, R.string.scooter_description,
                R.drawable.scooter));
        transport_item.add(new transport_items(R.string.car, R.string.car_description,
                R.drawable.cab));

        transport_adapter adapter = new transport_adapter(getActivity(), transport_item, R.color.primary_color);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
        return rootView;
    }
}

