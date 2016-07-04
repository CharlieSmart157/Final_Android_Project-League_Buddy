package com.example.charlie.finalproject_leaguebuddy.HomePage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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
    SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.homepage_layout, container, false);
        sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        Log.d("sharedprefUserID", ""+sharedPreferences.getInt("DefaultID", 0));
        initializeProfileView((FrameLayout)view.findViewById(R.id.profile_holder));

        return view;
    }



    public void initializeProfileView(View v){
        Bundle args = new Bundle();
        args.putInt("id", sharedPreferences.getInt("DefaultID", 0));
        fragment = new ProfileFragment();
        fragment.setArguments(args);
        android.support.v4.app.FragmentManager frgManager = getActivity().getSupportFragmentManager();
        frgManager.beginTransaction().replace(R.id.profile_holder, fragment).commit();


    }
}
