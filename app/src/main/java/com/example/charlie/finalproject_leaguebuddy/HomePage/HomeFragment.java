package com.example.charlie.finalproject_leaguebuddy.HomePage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.charlie.finalproject_leaguebuddy.BaseTemplates.BaseFragment;
import com.example.charlie.finalproject_leaguebuddy.ProfileHolder.ProfileFragment;
import com.example.charlie.finalproject_leaguebuddy.R;

/**
 * Created by Charlie on 28/06/2016.
 */
public class HomeFragment extends BaseFragment {

    View view;
    Fragment fragment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.homepage_layout, container, false);
        initializeProfileView((FrameLayout)view.findViewById(R.id.profile_holder));

        return view;
    }



    public void initializeProfileView(View v){
        Bundle args = new Bundle();
        args.putInt("id", getArguments().getInt("id"));
        fragment = new ProfileFragment();
        fragment.setArguments(args);
        android.support.v4.app.FragmentManager frgManager = getActivity().getSupportFragmentManager();
        frgManager.beginTransaction().replace(R.id.profile_holder, fragment).commit();


    }
}
