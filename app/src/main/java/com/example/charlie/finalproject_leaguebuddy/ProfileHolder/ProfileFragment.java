package com.example.charlie.finalproject_leaguebuddy.ProfileHolder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.charlie.finalproject_leaguebuddy.BaseTemplates.BaseFragment;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerModel;
import com.example.charlie.finalproject_leaguebuddy.R;
import com.example.charlie.finalproject_leaguebuddy.Realm.RealmController;

/**
 * Created by Charlie on 29/06/2016.
 */
public class ProfileFragment extends BaseFragment{

    View view;
    SummonerModel summoner;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.profile_holder_card, container, false);
        summoner = new SummonerModel(RealmController.getInstance().getSummoner(getArguments().getInt("id")));

        TextView text = (TextView)view.findViewById(R.id.Name_Text);
        text.setText(summoner.getName());


        return view;
    }

}
