package com.example.charlie.finalproject_leaguebuddy.Content;


import com.example.charlie.finalproject_leaguebuddy.BaseTemplates.BasePresenter;
import com.example.charlie.finalproject_leaguebuddy.BaseTemplates.BaseView;
import com.example.charlie.finalproject_leaguebuddy.Models.RankedStatsModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerMasteryModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerModel;
import com.example.charlie.finalproject_leaguebuddy.Realm.RealmSummoner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlie on 17/06/2016.
 */
public interface Content_Contract {

    interface View extends BaseView<Presenter> {
    void setmAdapter(ArrayList<SummonerModel> L);
    void displaySnackbar();
    int getUserID();
    void setSummoner(RealmSummoner s);
    void setTopMastery(List<SummonerMasteryModel> m);
    void setRankedStats(RankedStatsModel rankedStats);

    }

    interface Presenter extends BasePresenter {

        void returnSummonerByName(String s);
        void returnSummonerById(int i);
        boolean doesUserExist(int i);
        boolean doesUserNameExist(String s);
        public void fetchRankedStats(int id);
    }
}
