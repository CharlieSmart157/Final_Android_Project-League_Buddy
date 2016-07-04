package com.example.charlie.finalproject_leaguebuddy.ProfileHolder;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.charlie.finalproject_leaguebuddy.BaseTemplates.BaseFragment;
import com.example.charlie.finalproject_leaguebuddy.Content.Content_Contract;
import com.example.charlie.finalproject_leaguebuddy.Content.Content_Presenter;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerModel;
import com.example.charlie.finalproject_leaguebuddy.R;

import java.util.ArrayList;

/**
 * Created by Charlie on 29/06/2016.
 */
public class ProfileFragment extends BaseFragment implements Content_Contract.View{

    View view;
    SummonerModel summoner;
    Content_Presenter mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.profile_holder_card, container, false);
        mPresenter = new Content_Presenter(this);
        Log.d("UserID",""+getArguments().getInt("id"));
        if(getArguments().getInt("id") !=0) {
            mPresenter.returnSummonerById(getArguments().getInt("id"));

        }
        return view;
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
    public void setSummoner(SummonerModel s) {
        summoner = s;
         TextView text = (TextView) view.findViewById(R.id.Name_Text);
          text.setText(summoner.getName());
        Log.d("NAME",summoner.getName());
    }

    @Override
    public void setPresenter(Content_Contract.Presenter presenter) {

    }
}
