package com.example.android.tourguide;

import android.content.Context;
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


public class Places_fragment extends Fragment {


    public Places_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.grid_view, container, false);

        //create arraylist
        final ArrayList<items> item = new ArrayList<items>();
        item.add(new items(R.string.pn1, R.string.pt1,
              R.string.pr1, R.string.pa1 ,R.string.pd1, R.drawable.pone));
        item.add(new items(R.string.pn2, R.string.pt2,
                R.string.pr2, R.string.pa2,R.string.pd2, R.drawable.ptwo));
        item.add(new items(R.string.pn3, R.string.pt1,
                R.string.pr1, R.string.pa1,R.string.pd3, R.drawable.pthree));
        item.add(new items(R.string.pn1, R.string.pt1,
                R.string.pr1, R.string.pa1,R.string.pd4, R.drawable.pfour));
        item.add(new items(R.string.pn5, R.string.pt5,
                R.string.pr5, R.string.pa5,R.string.pd5, R.drawable.pfive));
        item.add(new items(R.string.pn6, R.string.pt6,
                R.string.pr6, R.string.pa6,R.string.pd6, R.drawable.psix));
        //collapsing toolbar declaration and functionaing
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) rootView.findViewById(R.id.collapse_toolbar);
        collapsingToolbar.setTitle("Places");
        //collapsing toolbar end

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        ImageView fragmentImage = (ImageView)rootView.findViewById(R.id.bgheader);
        fragmentImage.setImageResource(R.drawable.placesfull);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        // Make the {@link ListView} use the {@link arrayList_adapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        ProductAdapter adapter = new ProductAdapter(getActivity(), item,1);
        recyclerView.setAdapter(adapter);

                return rootView;

    }
}
