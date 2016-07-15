package com.example.charlie.finalproject_leaguebuddy.Observables;

import com.example.charlie.finalproject_leaguebuddy.Models.ChampionStaticDataModel;
import com.example.charlie.finalproject_leaguebuddy.Utility.Constants;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by Charlie on 04/07/2016.
 */
public interface IStatic_Data_API {
    @GET(Constants.CHAMPION_STATIC_INFO_URL + Constants.API_KEY)
    Observable<ChampionStaticDataModel> getChampStaticData(@Path("champId")int champ_ID);

}
