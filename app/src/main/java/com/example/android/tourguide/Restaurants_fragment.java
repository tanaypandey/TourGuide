package com.example.android.tourguide;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Objects;


public class Restaurants_fragment extends Fragment {


    public Restaurants_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.grid_view, container, false);

        //create arraylist
        final ArrayList<items> item = new ArrayList<items>();
        item.add(new items(R.string.rn1, R.string.rt1,
                R.string.rr1, R.string.ra1,R.string.rd1, R.drawable.rone));
        item.add(new items(R.string.rn2, R.string.rt2,
                R.string.rr2, R.string.ra2,R.string.rd2, R.drawable.rtwo));
        item.add(new items(R.string.rn3, R.string.rt1,
                R.string.rr1, R.string.ra1,R.string.rd3, R.drawable.rthree));
        item.add(new items(R.string.rn1, R.string.rt1,
                R.string.rr1, R.string.ra1,R.string.rd4, R.drawable.rfour));
        item.add(new items(R.string.rn5, R.string.rt5,
                R.string.rr5, R.string.ra5,R.string.rd5, R.drawable.rfive));
        item.add(new items(R.string.rn6, R.string.rt6,
                R.string.rr1, R.string.ra1,R.string.rd6, R.drawable.rsix));
        item.add(new items(R.string.rn7, R.string.rt7,
                R.string.rr7, R.string.ra7,R.string.rd7, R.drawable.rseven));
        item.add(new items(R.string.rn8, R.string.rt8,
                R.string.rr8, R.string.ra8,R.string.rd8, R.drawable.reight));
        item.add(new items(R.string.rn9, R.string.rt9,
                R.string.rr9, R.string.ra9,R.string.rd9, R.drawable.rnine));
        item.add(new items(R.string.rn9, R.string.rt9,
                R.string.rr9, R.string.ra9,R.string.rd10, R.drawable.rten));

        //collapsing toolbar declaration and functionaing
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) rootView.findViewById(R.id.collapse_toolbar);
        collapsingToolbar.setTitle("Restaurants");

        //collapsing toolbar end

        ImageView fragmentImage = (ImageView)rootView.findViewById(R.id.bgheader);
        fragmentImage.setImageResource(R.drawable.restaurantsfull);
        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        // Make the {@link ListView} use the {@link arrayList_adapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        ProductAdapter adapter = new ProductAdapter(getActivity(), item,2);
        recyclerView.setAdapter(adapter);
        return rootView;
    }
}
