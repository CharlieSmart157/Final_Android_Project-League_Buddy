package com.example.charlie.finalproject_leaguebuddy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.charlie.finalproject_leaguebuddy.Content.Content_Contract;
import com.example.charlie.finalproject_leaguebuddy.Content.Content_Presenter;
import com.example.charlie.finalproject_leaguebuddy.HomePage.HomeFragment;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerModel;
import com.example.charlie.finalproject_leaguebuddy.Realm.RealmController;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, Content_Contract.View {


    Fragment fragment;
    int userID;
    Content_Presenter mPresenter;
    SharedPreferences sharedpreferences ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPresenter = new Content_Presenter(this);

        //Preferences: Default User
        sharedpreferences  = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        if(sharedpreferences.getInt("DefaultID", 0) == 0)
        {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt("DefaultID",24102751);
        editor.commit();
        }

        userID = sharedpreferences.getInt("DefaultID", 0);
        RealmController.with(this);



        //UI
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        SelectItem(0);

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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            RealmController.getInstance().clearAll();

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void SelectItem(int position){

        Bundle args = new Bundle();

        //Insert Switch Statement here
        switch(position){
            case 0:
                Log.i("Case",""+position);
                fragment = new HomeFragment();
                //args.putInt();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    this.invalidateOptionsMenu();
                }
                break;

        }

        android.support.v4.app.FragmentManager frgManager = getSupportFragmentManager();
        frgManager.beginTransaction().replace(R.id.fragment_layout_holder, fragment).commit();


    }

    @Override
    public void setmAdapter(ArrayList<SummonerModel> L) {

    }

    @Override
    public void displaySnackbar() {

    }

    @Override
    public int getUserID() {
        return userID;
    }

    @Override
    public void setSummoner(SummonerModel s) {

    }

    @Override
    public void setPresenter(Content_Contract.Presenter presenter) {

    }
}
