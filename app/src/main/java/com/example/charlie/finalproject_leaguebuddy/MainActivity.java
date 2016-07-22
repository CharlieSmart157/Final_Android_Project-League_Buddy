package com.example.charlie.finalproject_leaguebuddy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
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
import com.example.charlie.finalproject_leaguebuddy.Models.RankedStatsModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerMasteryModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerModel;
import com.example.charlie.finalproject_leaguebuddy.ProfilePage.ProfilePageFragment;
import com.example.charlie.finalproject_leaguebuddy.Realm.RealmController;
import com.example.charlie.finalproject_leaguebuddy.Realm.RealmSummoner;
import com.example.charlie.finalproject_leaguebuddy.UserSelectPage.UserAddFragment;
import com.example.charlie.finalproject_leaguebuddy.UserSelectPage.UserSelectFragment;

import java.util.ArrayList;
import java.util.List;

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


        RealmController.with(this);



        //UI
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        //        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
          //              .setAction("Action", null).show();
                AddSummoner();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //Preferences: Default User

        sharedpreferences  = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        if(sharedpreferences.getInt("DefaultID",0)==0)
            SelectItem(1);
        else
            SelectItem(0);


    }

    @Override
    public void onBackPressed() {
        Log.d("BACK_PRESSED"," ");
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
        Log.d("NAV_ID", id+"");
        if(id == R.id.nav_home){

            SelectItem(0);
        }
        else
        if (id == R.id.nav_profile) {
            // Handle the camera action
        } else if (id == R.id.nav_reset) {

            sharedpreferences  = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.clear();
            //editor.putInt("DefaultID",25487967);
            editor.commit();
            RealmController.getInstance().clearAll();
            Log.d("RESET", "DONE");


        }
        if(id == R.id.nav_set_user){
            SelectItem(1);
        }
        else
        if(id == R.id.nav_profile)
            SelectItem(2,sharedpreferences.getInt("DefaultID", 0) );

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void SelectItem(int position, int... id){
        userID = sharedpreferences.getInt("DefaultID", 0);
        Bundle args = new Bundle();
        int selectedId = id.length > 0 ? id[0]:0;
        if(id.length >0)
            selectedId = id[0];

        //Insert Switch Statement here
        switch(position){
            case 0:
                Log.i("Case"," "+position);
                getSupportActionBar().setTitle("Home");
                fragment = new HomeFragment();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    this.invalidateOptionsMenu();
                }
                break;
            case 1:
                Log.i("Case"," "+position);
                getSupportActionBar().setTitle("Select Default User");
                fragment = new UserSelectFragment();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    this.invalidateOptionsMenu();
                }
                break;
            case 2:
                Log.i("Case", ""+position);
                getSupportActionBar().setTitle("View Profile");
                fragment = new ProfilePageFragment();
                fragment.setRetainInstance(true);
                args.putInt("id", selectedId);
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
                    this.invalidateOptionsMenu();
                }
                break;

        }
        fragment.setArguments(args);
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
    public void setSummoner(RealmSummoner s) {

    }

    @Override
    public void setTopMastery(List<SummonerMasteryModel> m) {

    }

    @Override
    public void setRankedStats(RankedStatsModel rankedStats) {

    }

    @Override
    public void setPresenter(Content_Contract.Presenter presenter) {

    }

    public void  AddSummoner(){

        android.support.v4.app.FragmentManager frgManager = getSupportFragmentManager();

        UserAddFragment userAddFragment = new UserAddFragment();
        userAddFragment.show(frgManager, "UserAddDialog");

    }

}
