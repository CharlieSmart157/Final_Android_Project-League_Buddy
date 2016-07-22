package com.example.charlie.finalproject_leaguebuddy.ProfilePage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.charlie.finalproject_leaguebuddy.BaseTemplates.BaseFragment;
import com.example.charlie.finalproject_leaguebuddy.Content.Content_Contract;
import com.example.charlie.finalproject_leaguebuddy.Models.RankedStatsModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerMasteryModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerModel;
import com.example.charlie.finalproject_leaguebuddy.ProfileHolder.ProfileFragment;
import com.example.charlie.finalproject_leaguebuddy.R;
import com.example.charlie.finalproject_leaguebuddy.RankedStats.ranked_stats_fragment;
import com.example.charlie.finalproject_leaguebuddy.Realm.RealmSummoner;
import com.example.charlie.finalproject_leaguebuddy.SummonerMasteryFragments.SummonerTopMasteryFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlie on 11/07/2016.
 */
public class ProfilePageFragment extends BaseFragment implements Content_Contract.View, SwipeRefreshLayout.OnRefreshListener{

    Boolean local = true;
    View view;
    Fragment fragment;
    SharedPreferences sharedPreferences;
    SwipeRefreshLayout mSwipeRefresher;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.profilepage_layout, container, false);
        sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        mSwipeRefresher = (SwipeRefreshLayout)view.findViewById(R.id.swipeRefreshLayout);
        mSwipeRefresher.setOnRefreshListener(this);
        initializeProfileView();
        initializeSummonerMastery();
        initializeSummonerRankStats();
        setRetainInstance(true);
        return view;
    }



    public void initializeProfileView(){
        Bundle args = new Bundle();
        args.putInt("id", getArguments().getInt("id"));
        args.putBoolean("idMode",true);
        args.putBoolean("local", local);
        fragment = new ProfileFragment();
        fragment.setArguments(args);
        android.support.v4.app.FragmentManager frgManager = getActivity().getSupportFragmentManager();
        frgManager.beginTransaction().replace(R.id.profile_holder, fragment).commit();
    }

    public void initializeSummonerMastery(){
        Bundle args = new Bundle();
        args.putInt("id", getArguments().getInt("id"));
        args.putBoolean("local", local);
        android.support.v4.app.FragmentManager frgManager = getActivity().getSupportFragmentManager();

        fragment = new SummonerTopMasteryFragment();
        fragment.setArguments(args);
        fragment.setRetainInstance(true);
        frgManager.beginTransaction().replace(R.id.mastery_holder, fragment).commit();

    }

    public void initializeSummonerRankStats(){
        Bundle args = new Bundle();
        args.putInt("id", getArguments().getInt("id"));
        args.putBoolean("local", local);
        android.support.v4.app.FragmentManager frgManager = getActivity().getSupportFragmentManager();

        fragment = new ranked_stats_fragment();
        fragment.setArguments(args);
        fragment.setRetainInstance(true);
        frgManager.beginTransaction().replace(R.id.stats_holder, fragment).commit();




    }

    @Override
    public void setmAdapter(ArrayList<SummonerModel> L) {

    }

    @Override
    public void displaySnackbar() {

    }

    @Override
    public int getUserID() {
        return 0;
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

    @Override
    public void onRefresh() {
        local = false;
        mSwipeRefresher.setRefreshing(false);
        initializeProfileView();
        //initializeSummonerMastery();
        //initializeSummonerRankStats();
        local = true;

    }
}
