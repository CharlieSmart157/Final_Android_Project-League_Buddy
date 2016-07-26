package com.example.charlie.finalproject_leaguebuddy.Observables;

import com.example.charlie.finalproject_leaguebuddy.Models.ChampionStaticDataModel;
import com.example.charlie.finalproject_leaguebuddy.Models.RankedStatsModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerMasteryModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerRankedLeague;
import com.example.charlie.finalproject_leaguebuddy.Utility.Constants;

import java.util.List;

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
    @GET(Constants.SUMMONER_URL_BY_ID_URL + Constants.API_KEY)

    Observable<SummonerModel> getSummonerUnrankedStats(@Path("summonerIds")String summoner_ID );
    @GET(Constants.SUMMONER_RANKED_LEAGUE_URL + Constants.API_KEY)

    Observable<SummonerRankedLeague> getSummonerRankedLeague(@Path("summonerIds")String summoner_ID );
    @GET(Constants.SUMMONER_CHAMPION_MASTERY_URL + Constants.API_KEY)
    Observable<List<SummonerMasteryModel>> getSummonerTopMastery(@Path("summonerIds")int summoner_ID);
    @GET(Constants.CHAMPION_STATIC_INFO_URL + Constants.API_KEY)
    Observable<ChampionStaticDataModel>getChampStaticData(@Path("champId")int champ_ID);
    @GET(Constants.RANKED_STATS_URL + Constants.API_KEY)
    Observable<RankedStatsModel>getRankedStatsData(@Path("summonerIds")int summoner_ID);

}
