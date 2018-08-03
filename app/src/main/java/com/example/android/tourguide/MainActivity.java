package com.example.android.tourguide;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Objects;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int colorId = R.color.transparent;

        // for scrollable collapsable toolbar
        final Toolbar myToolbar = (Toolbar) findViewById(R.id.MyToolbar);
        setSupportActionBar(myToolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(getResources().getColor(colorId));
        toolbar.setVisibility(View.GONE);

        //intent ot send tto Transport activity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent transportIntent = new Intent(MainActivity.this, TransportActivity.class);
                startActivity(transportIntent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //facts Layout
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new facts_fragment()).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager fm1 = getSupportFragmentManager();
        fm1.beginTransaction()
                .replace(R.id.content_frame, new Places_fragment(), "places_fragment")
                .commit();
        FragmentManager fm2 = getSupportFragmentManager();
        fm2.beginTransaction()
                .replace(R.id.content_frame, new Restaurants_fragment(), "restaurants_fragment")
                .commit();
        FragmentManager fm3 = getSupportFragmentManager();
        fm3.beginTransaction()
                .replace(R.id.content_frame, new Malls_fragment(), "malls_fragment")
                .commit();
        Fragment fragment1 = getSupportFragmentManager().findFragmentByTag("places_fragment");
        Fragment fragment2 = getSupportFragmentManager().findFragmentByTag("restaurants_fragment");
        Fragment fragment3 = getSupportFragmentManager().findFragmentByTag("malls_fragment");

        if (id == R.id.nav_camera) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new Places_fragment()).commit();
        } else if (id == R.id.nav_gallery) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new Restaurants_fragment()).commit();
        } else if (id == R.id.nav_slideshow) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new Malls_fragment()).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        if (fragment1 != null) {
            getSupportFragmentManager().beginTransaction().remove(fragment1).commitAllowingStateLoss();
        }
        if (fragment2 != null) {
            getSupportFragmentManager().beginTransaction().remove(fragment2).commitAllowingStateLoss();
        }
        if (fragment3 != null) {
            getSupportFragmentManager().beginTransaction().remove(fragment3).commitAllowingStateLoss();
        }

        return true;
    }
}