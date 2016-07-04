package com.example.charlie.finalproject_leaguebuddy.Realm;

import com.example.charlie.finalproject_leaguebuddy.Models.SummonerModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Charlie on 29/06/2016.
 */
public class RealmSummoner extends RealmObject {
    @PrimaryKey
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("profileIconId")
    @Expose
    private int profileIconId;
    @SerializedName("summonerLevel")
    @Expose
    private int summonerLevel;
    @SerializedName("revisionDate")
    @Expose
    private int revisionDate;


    public RealmSummoner(){}

    public RealmSummoner(SummonerModel s){

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
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(int id) {
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
    public int getProfileIconId() {
        return profileIconId;
    }

    /**
     *
     * @param profileIconId
     * The profileIconId
     */
    public void setProfileIconId(int profileIconId) {
        this.profileIconId = profileIconId;
    }

    /**
     *
     * @return
     * The summonerLevel
     */
    public int getSummonerLevel() {
        return summonerLevel;
    }

    /**
     *
     * @param summonerLevel
     * The summonerLevel
     */
    public void setSummonerLevel(int summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    /**
     *
     * @return
     * The revisionDate
     */
    public int getRevisionDate() {
        return revisionDate;
    }

    /**
     *
     * @param revisionDate
     * The revisionDate
     */
    public void setRevisionDate(int revisionDate) {
        this.revisionDate = revisionDate;
    }

}
