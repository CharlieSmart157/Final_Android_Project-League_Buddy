package com.example.charlie.finalproject_leaguebuddy.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Charlie on 04/07/2016.
 */
public class Entry extends RealmObject {


    @SerializedName("playerOrTeamId")
    @Expose
    private String playerOrTeamId;
    @SerializedName("playerOrTeamName")
    @Expose
    private String playerOrTeamName;
    @SerializedName("division")
    @Expose
    private String division;
    @SerializedName("leaguePoints")
    @Expose
    private int leaguePoints;
    @SerializedName("wins")
    @Expose
    private int wins;
    @SerializedName("losses")
    @Expose
    private int losses;
    @SerializedName("isHotStreak")
    @Expose
    private boolean isHotStreak;
    @SerializedName("isVeteran")
    @Expose
    private boolean isVeteran;
    @SerializedName("isFreshBlood")
    @Expose
    private boolean isFreshBlood;
    @SerializedName("isInactive")
    @Expose
    private boolean isInactive;

    /**
     *
     * @return
     * The playerOrTeamId
     */
    public String getPlayerOrTeamId() {
        return playerOrTeamId;
    }

    /**
     *
     * @param playerOrTeamId
     * The playerOrTeamId
     */
    public void setPlayerOrTeamId(String playerOrTeamId) {
        this.playerOrTeamId = playerOrTeamId;
    }

    /**
     *
     * @return
     * The playerOrTeamName
     */
    public String getPlayerOrTeamName() {
        return playerOrTeamName;
    }

    /**
     *
     * @param playerOrTeamName
     * The playerOrTeamName
     */
    public void setPlayerOrTeamName(String playerOrTeamName) {
        this.playerOrTeamName = playerOrTeamName;
    }

    /**
     *
     * @return
     * The division
     */
    public String getDivision() {
        return division;
    }

    /**
     *
     * @param division
     * The division
     */
    public void setDivision(String division) {
        this.division = division;
    }

    /**
     *
     * @return
     * The leaguePoints
     */
    public int getLeaguePoints() {
        return leaguePoints;
    }

    /**
     *
     * @param leaguePoints
     * The leaguePoints
     */
    public void setLeaguePoints(int leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    /**
     *
     * @return
     * The wins
     */
    public int getWins() {
        return wins;
    }

    /**
     *
     * @param wins
     * The wins
     */
    public void setWins(int wins) {
        this.wins = wins;
    }

    /**
     *
     * @return
     * The losses
     */
    public int getLosses() {
        return losses;
    }

    /**
     *
     * @param losses
     * The losses
     */
    public void setLosses(int losses) {
        this.losses = losses;
    }

    /**
     *
     * @return
     * The isHotStreak
     */
    public boolean isIsHotStreak() {
        return isHotStreak;
    }

    /**
     *
     * @param isHotStreak
     * The isHotStreak
     */
    public void setIsHotStreak(boolean isHotStreak) {
        this.isHotStreak = isHotStreak;
    }

    /**
     *
     * @return
     * The isVeteran
     */
    public boolean isIsVeteran() {
        return isVeteran;
    }

    /**
     *
     * @param isVeteran
     * The isVeteran
     */
    public void setIsVeteran(boolean isVeteran) {
        this.isVeteran = isVeteran;
    }

    /**
     *
     * @return
     * The isFreshBlood
     */
    public boolean isIsFreshBlood() {
        return isFreshBlood;
    }

    /**
     *
     * @param isFreshBlood
     * The isFreshBlood
     */
    public void setIsFreshBlood(boolean isFreshBlood) {
        this.isFreshBlood = isFreshBlood;
    }

    /**
     *
     * @return
     * The isInactive
     */
    public boolean isIsInactive() {
        return isInactive;
    }

    /**
     *
     * @param isInactive
     * The isInactive
     */
    public void setIsInactive(boolean isInactive) {
        this.isInactive = isInactive;
    }
}