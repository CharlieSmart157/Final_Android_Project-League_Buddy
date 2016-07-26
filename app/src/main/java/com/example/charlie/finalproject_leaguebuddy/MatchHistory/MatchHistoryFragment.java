package com.example.charlie.finalproject_leaguebuddy.MatchHistory;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.charlie.finalproject_leaguebuddy.BaseTemplates.BaseFragment;
import com.example.charlie.finalproject_leaguebuddy.R;

/**
 * Created by Charlie on 22/07/2016.
 */
public class MatchHistoryFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{

    Boolean local = true;
    View view;
    SharedPreferences sharedPreferences;
    SwipeRefreshLayout mSwipeRefresher;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.profilepage_layout, container, false);
        sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        mSwipeRefresher = (SwipeRefreshLayout)view.findViewById(R.id.swipeRefreshLayout);
        mSwipeRefresher.setOnRefreshListener(this);


        initializeRecyclerView();
        setRetainInstance(true);
        return view;
    }



    public void initializeRecyclerView(){


    }

    @Override
    public void onRefresh() {
        mSwipeRefresher.setRefreshing(false);
    }
}

