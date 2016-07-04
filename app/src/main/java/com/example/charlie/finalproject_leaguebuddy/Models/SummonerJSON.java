package com.example.charlie.finalproject_leaguebuddy.Models;

/**
 * Created by Charlie on 01/07/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SummonerJSON {

    @SerializedName("SummonerModel")
    @Expose
    private SummonerModel summonerModel;

    /**
     *
     * @return
     * The summonerModel
     */
    public SummonerModel getSummonerModel() {
        return summonerModel;
    }

    /**
     *
     * @param summonerModel
     * The SummonerModel
     */
    public void setSummonerModel(SummonerModel summonerModel) {
        this.summonerModel = summonerModel;
    }

}