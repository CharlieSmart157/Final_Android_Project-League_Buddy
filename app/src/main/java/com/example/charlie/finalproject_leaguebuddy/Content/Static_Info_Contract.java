package com.example.charlie.finalproject_leaguebuddy.Content;

import com.example.charlie.finalproject_leaguebuddy.BaseTemplates.BasePresenter;
import com.example.charlie.finalproject_leaguebuddy.BaseTemplates.BaseView;
import com.example.charlie.finalproject_leaguebuddy.Models.ChampionStaticDataModel;

/**
 * Created by Charlie on 12/07/2016.
 */
public interface Static_Info_Contract {

    interface View extends BaseView<Presenter> {
        void recieveChampStatic(ChampionStaticDataModel c);
    }

    interface Presenter extends BasePresenter {
        void returnChampStatic(int i);
    }

}
