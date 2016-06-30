package com.example.charlie.finalproject_leaguebuddy.Content;


import com.example.charlie.finalproject_leaguebuddy.BaseTemplates.BasePresenter;
import com.example.charlie.finalproject_leaguebuddy.BaseTemplates.BaseView;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerModel;

import java.util.ArrayList;

/**
 * Created by Charlie on 17/06/2016.
 */
public interface Content_Contract {

    interface View extends BaseView<Presenter> {
    void setmAdapter(ArrayList<SummonerModel> L);
    void displaySnackbar();

    }

    interface Presenter extends BasePresenter {

        void returnSummoner(String s);
    }
}
