package com.example.charlie.finalproject_leaguebuddy.HomePage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.charlie.finalproject_leaguebuddy.BaseTemplates.BaseFragment;
import com.example.charlie.finalproject_leaguebuddy.Leaderboards.SummonerLeaderboardFragment;
import com.example.charlie.finalproject_leaguebuddy.ProfileHolder.ProfileFragment;
import com.example.charlie.finalproject_leaguebuddy.R;
import com.example.charlie.finalproject_leaguebuddy.Realm.RealmController;

/**
 * Created by Charlie on 28/06/2016.
 */
public class HomeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{

    Boolean local = true;
    View view;
    Fragment fragment;
    SharedPreferences sharedPreferences;
    SwipeRefreshLayout mSwipeRefresher;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.homepage_layout, container, false);
        sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        Log.d("sharedprefUserID", ""+sharedPreferences.getInt("DefaultID", 0));
        mSwipeRefresher = (SwipeRefreshLayout)view.findViewById(R.id.swipeRefreshLayout);
        mSwipeRefresher.setOnRefreshListener(this);
        initializeProfileView();
        initializeFavouritesLeaderboard();
        return view;
    }



    public void initializeProfileView(){
        Bundle args = new Bundle();
        args.putInt("id", sharedPreferences.getInt("DefaultID", 0));
        args.putBoolean("idMode",true);
        args.putBoolean("local", local);
        fragment = new ProfileFragment();
        fragment.setArguments(args);
        android.support.v4.app.FragmentManager frgManager = getActivity().getSupportFragmentManager();
        frgManager.beginTransaction().replace(R.id.profile_holder, fragment).commit();


    }

    public void initializeFavouritesLeaderboard(){
        Bundle args = new Bundle();
        args.putBoolean("local", local);
        args.putIntegerArrayList("ids",RealmController.getInstance().getSummonerIDs());
        fragment = new SummonerLeaderboardFragment();
        fragment.setArguments(args);
        android.support.v4.app.FragmentManager frgManager = getActivity().getSupportFragmentManager();
        frgManager.beginTransaction().replace(R.id.leaderboard_holder, fragment).commit();

    }

    @Override
    public void onRefresh() {
        local = false;
        initializeProfileView();
        initializeFavouritesLeaderboard();
        local = true;
        mSwipeRefresher.setRefreshing(false);
    }
}
