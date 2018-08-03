package com.example.android.tourguide;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class facts_fragment extends Fragment {

    public facts_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.transport_list, container, false);

        //create arraylist
        final ArrayList<facts> fact = new ArrayList<facts>();
        fact.add(new facts(R.string.fh1, R.string.f1,
                R.drawable.fone));
        fact.add(new facts(R.string.fh2, R.string.f2,
                R.drawable.ftwo));
        fact.add(new facts(R.string.fh3, R.string.f3,
                R.drawable.fthree));
//        fact.add(new facts(R.string.fh4, R.string.f4,
//                R.drawable.ffour));
//        fact.add(new facts(R.string.fh5, R.string.f5,
//                R.drawable.ftwo));
//        fact.add(new facts(R.string.fh6, R.string.f6,
//                R.drawable.ffive));
        factsAdapter adapter = new factsAdapter(getActivity(), fact, R.color.primary_color);

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