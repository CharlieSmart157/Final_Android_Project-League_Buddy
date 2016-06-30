package com.example.charlie.finalproject_leaguebuddy.Models;

import com.example.charlie.finalproject_leaguebuddy.Realm.RealmSummoner;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

/**
 * Created by Charlie on 29/06/2016.
 */

@Generated("org.jsonschema2pojo")
public class SummonerModel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("profileIconId")
    @Expose
    private Integer profileIconId;
    @SerializedName("summonerLevel")
    @Expose
    private Integer summonerLevel;
    @SerializedName("revisionDate")
    @Expose
    private Integer revisionDate;


    public SummonerModel(RealmSummoner s){

        setId(s.getId());
        setName(s.getName());
        setProfileIconId(s.getProfileIconId());
        setRevisionDate(s.getRevisionDate());
        setSummonerLevel(s.getSummonerLevel());
    }
    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The profileIconId
     */
    public Integer getProfileIconId() {
        return profileIconId;
    }

    /**
     *
     * @param profileIconId
     * The profileIconId
     */
    public void setProfileIconId(Integer profileIconId) {
        this.profileIconId = profileIconId;
    }

    /**
     *
     * @return
     * The summonerLevel
     */
    public Integer getSummonerLevel() {
        return summonerLevel;
    }

    /**
     *
     * @param summonerLevel
     * The summonerLevel
     */
    public void setSummonerLevel(Integer summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    /**
     *
     * @return
     * The revisionDate
     */
    public Integer getRevisionDate() {
        return revisionDate;
    }

    /**
     *
     * @param revisionDate
     * The revisionDate
     */
    public void setRevisionDate(Integer revisionDate) {
        this.revisionDate = revisionDate;
    }

}

