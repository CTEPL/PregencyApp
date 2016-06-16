package com.example.nvanamala.pregnencyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.nvanamala.fragments.AppointmentTracker;
import com.example.nvanamala.fragments.BellyAlbumFragment;
import com.example.nvanamala.fragments.CheckListFragment;
import com.example.nvanamala.fragments.ClickToCallFragment;
import com.example.nvanamala.fragments.FoodFragment;
import com.example.nvanamala.fragments.ForumFragment;
import com.example.nvanamala.fragments.HealthProgramFragment;
import com.example.nvanamala.fragments.MapsFragment;
import com.example.nvanamala.fragments.RewardsFragment;

public class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
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

        if (id == R.id.action_logout) {
            Utils.saveBooleanInSP(this, "LoggedIn", false);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.item_appointment_tracker) {
            // Handle the camera action
            replaceFragment(new AppointmentTracker());
        } else if (id == R.id.item_belly_album) {
            replaceFragment(new BellyAlbumFragment());
        } else if (id == R.id.item_food) {
            replaceFragment(new FoodFragment());
        } else if (id == R.id.item_checklist) {
            replaceFragment(new CheckListFragment());
        } else if (id == R.id.item_reward) {
            replaceFragment(new RewardsFragment());
        } else if (id == R.id.item_map) {
            replaceFragment(new MapsFragment());
        } else if (id == R.id.item_health_program) {
            replaceFragment(new HealthProgramFragment());
        } else if (id == R.id.item_click_to_call) {
            replaceFragment(new ClickToCallFragment());
        } else if (id == R.id.item_forum) {
            replaceFragment(new ForumFragment());
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void replaceFragment(Fragment fragment) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }

}
