package com.example.charlie.finalproject_leaguebuddy.Observables;

import com.example.charlie.finalproject_leaguebuddy.Models.SummonerModel;
import com.example.charlie.finalproject_leaguebuddy.Utility.Constants;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by Charlie on 29/06/2016.
 */
public interface ISummoner_API {

    @GET(Constants.SUMMONER_BY_NAME_URL + Constants.API_KEY)
    Observable<SummonerModel> getSummonerByName(@Path("summonerName")String summoner_ID );
    @GET(Constants.SUMMONER_URL_BY_ID_URL + Constants.API_KEY)
    Observable<SummonerModel> getSummonerById(@Path("summonerIds")String summoner_ID );

}
