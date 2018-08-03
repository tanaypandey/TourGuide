package com.example.android.tourguide;

import android.os.Bundle;
import android.support.annotation.NonNull;
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


public class Malls_fragment extends Fragment {


    public Malls_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.grid_view, container, false);

        //create arraylist
        final ArrayList<items> item = new ArrayList<items>();
        item.add(new items(R.string.mn1, R.string.mt1,
                R.string.mr1, R.string.ma1,R.string.md1, R.drawable.mone));
        item.add(new items(R.string.mn2, R.string.mt2,
                R.string.mr2, R.string.ma2,R.string.md2, R.drawable.mtwo));
        item.add(new items(R.string.mn3, R.string.mt1,
                R.string.mr1, R.string.ma1,R.string.md3, R.drawable.mthree));
        item.add(new items(R.string.mn1, R.string.mt1,
                R.string.mr1, R.string.ma1,R.string.md4, R.drawable.mfour));
        item.add(new items(R.string.mn5, R.string.mt5,
                R.string.mr5, R.string.ma5,R.string.md5, R.drawable.mfive));

        //collapsing toolbar declaration and functionaing
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) rootView.findViewById(R.id.collapse_toolbar);
        collapsingToolbar.setTitle("Malls");
        //collapsing toolbar end

        ImageView fragmentImage = (ImageView)rootView.findViewById(R.id.bgheader);
        fragmentImage.setImageResource(R.drawable.mallfull);
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
        ProductAdapter adapter = new ProductAdapter(getActivity(), item,3);
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}

