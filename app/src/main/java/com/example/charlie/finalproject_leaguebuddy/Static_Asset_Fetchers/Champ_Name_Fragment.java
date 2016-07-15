package com.example.charlie.finalproject_leaguebuddy.Static_Asset_Fetchers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.charlie.finalproject_leaguebuddy.BaseTemplates.BaseFragment;
import com.example.charlie.finalproject_leaguebuddy.Content.Static_Info_Contract;
import com.example.charlie.finalproject_leaguebuddy.Content.Static_Info_Presenter;
import com.example.charlie.finalproject_leaguebuddy.Models.ChampionStaticDataModel;
import com.example.charlie.finalproject_leaguebuddy.R;

/**
 * Created by Charlie on 13/07/2016.
 */
public class Champ_Name_Fragment extends BaseFragment implements Static_Info_Contract.View{

    View view;

    Static_Info_Presenter mStaticPresenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.champ_name_fragment_layout, container, false);
        mStaticPresenter = new Static_Info_Presenter(this);

        if(getArguments().getInt("id") !=0) {
            mStaticPresenter.returnChampStatic(getArguments().getInt("id"));
        }


        return view;
    }

    @Override
    public void recieveChampStatic(ChampionStaticDataModel c) {

        TextView text = (TextView)view.findViewById(R.id.champ_nameTXT);
        text.setText(c.getName());

    }


    @Override
    public void setPresenter(Static_Info_Contract.Presenter presenter) {

    }

}
