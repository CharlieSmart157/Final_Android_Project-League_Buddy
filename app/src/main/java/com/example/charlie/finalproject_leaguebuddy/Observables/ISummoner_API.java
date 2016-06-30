package com.example.charlie.finalproject_leaguebuddy.Observables;

import com.example.charlie.finalproject_leaguebuddy.Models.SummonerModel;
import com.example.charlie.finalproject_leaguebuddy.Utility.Constants;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Charlie on 29/06/2016.
 */
public interface ISummoner_API {

    @GET(Constants.SUMMONER_URL)
    Observable<SummonerModel> getSummoners(@Query("summonerName")String summoner_ID );

}
