package com.example.android.tourguide;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemDescription extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_description_design);

        TextView rating = (TextView)findViewById(R.id.rating);
        TextView time = (TextView)findViewById(R.id.time);
        TextView address = (TextView)findViewById(R.id.address);
        TextView description = (TextView)findViewById(R.id.description);
        ImageView header = (ImageView)findViewById(R.id.bgheader_d);
        //collapsible toolbar
        final Toolbar myToolbar = (Toolbar) findViewById(R.id.MyToolbar_d);
        setSupportActionBar(myToolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout)findViewById(R.id.collapse_toolbar_d);

        Bundle activity = getIntent().getExtras();
        int activity_number = -1; // or other values
        if(activity != null) activity_number = activity.getInt("activity_number");
        if(activity_number ==1){
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
            //recieve the position of the list
            Bundle b = getIntent().getExtras();
            int value = -1; // or other values
            if(b != null) value = b.getInt("key");
            rating.setText(item.get(value).getmRating());
            time.setText(item.get(value).getmTime());
            address.setText(item.get(value).getmAddressId());
            description.setText(item.get(value).getmDescriptionId());
            //collapsing toolbar declaration and functionaing
            collapsingToolbar.setTitle(getResources().getString(item.get(value).getmPlaceName()));
            //collapsing toolbar end
            header.setImageResource(item.get(value).getmImageResourceId());
         }
         else if(activity_number == 2){
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
            //recieve the position of the list
            Bundle b = getIntent().getExtras();
            int value = -1; // or other values
            if(b != null) value = b.getInt("key");
            rating.setText(item.get(value).getmRating());
            time.setText(item.get(value).getmTime());
            address.setText(item.get(value).getmAddressId());
            description.setText(item.get(value).getmDescriptionId());
            //collapsing toolbar declaration and functionaing
            collapsingToolbar.setTitle(getResources().getString(item.get(value).getmPlaceName()));
            //collapsing toolbar end
            header.setImageResource(item.get(value).getmImageResourceId());

        }
        else{
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
//recieve the position of the list
            Bundle b = getIntent().getExtras();
            int value = -1; // or other values
            if(b != null) value = b.getInt("key");
            rating.setText(item.get(value).getmRating());
            time.setText(item.get(value).getmTime());
            address.setText(item.get(value).getmAddressId());
            description.setText(item.get(value).getmDescriptionId());
            //collapsing toolbar declaration and functionaing
            collapsingToolbar.setTitle(getResources().getString(item.get(value).getmPlaceName()));
            //collapsing toolbar end
            collapsingToolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
            header.setImageResource(item.get(value).getmImageResourceId());

        }
    }
}
