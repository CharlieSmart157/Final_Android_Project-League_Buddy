package com.example.charlie.finalproject_leaguebuddy.SummonerMasteryFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.charlie.finalproject_leaguebuddy.BaseTemplates.BaseFragment;
import com.example.charlie.finalproject_leaguebuddy.Content.Content_Contract;
import com.example.charlie.finalproject_leaguebuddy.Content.Content_Presenter;
import com.example.charlie.finalproject_leaguebuddy.Content.Static_Info_Presenter;
import com.example.charlie.finalproject_leaguebuddy.Models.RankedStatsModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerMasteryModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerModel;
import com.example.charlie.finalproject_leaguebuddy.R;
import com.example.charlie.finalproject_leaguebuddy.Realm.RealmSummoner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlie on 12/07/2016.
 */
public class SummonerTopMasteryFragment extends BaseFragment implements Content_Contract.View{

    View view;
    Content_Presenter mContentPresenter;
    Static_Info_Presenter mStaticPresenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.summonertopmastery_layout, container, false);
        mContentPresenter = new Content_Presenter(this);

                mContentPresenter.fetchSummonerTopMastery(getArguments().getInt("id"));



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
    public void setSummoner(RealmSummoner s) {

    }



    @Override
    public void setTopMastery(List<SummonerMasteryModel> m){

        Fragment fragment;
        Bundle args = new Bundle();
        args.putInt("id", m.get(0).getChampionId());
        args.putInt("masteryPoints", m.get(0).getChampionPoints());

        Log.d("ARGS_PUT", args.getInt("id")+"");
        android.support.v4.app.FragmentManager frgManager = getActivity().getSupportFragmentManager();

        fragment = new ChampMasteryFragment();
        fragment.setArguments(args);
        frgManager.beginTransaction().replace(R.id.Mastery1, fragment).commit();

        Bundle args2 = new Bundle();
        args2.putInt("id", m.get(1).getChampionId());
        Log.d("ARGS_PUT", args.getInt("id")+"");
        args2.putInt("masteryPoints", m.get(1).getChampionPoints());
        Fragment fragment2;
        fragment2 = new ChampMasteryFragment();
        fragment2.setArguments(args2);
        frgManager.beginTransaction().replace(R.id.Mastery2, fragment2).commit();

        Bundle args3 = new Bundle();
        args3.putInt("id", m.get(2).getChampionId());
        args3.putInt("masteryPoints", m.get(2).getChampionPoints());
        Fragment fragment3;
        fragment3 = new ChampMasteryFragment();
        fragment3.setArguments(args3    );
        frgManager.beginTransaction().replace(R.id.Mastery3, fragment3).commit();


    }

    @Override
    public void setRankedStats(RankedStatsModel rankedStats) {

    }


    {


    }
    @Override
    public void setPresenter(Content_Contract.Presenter presenter) {

    }





}
