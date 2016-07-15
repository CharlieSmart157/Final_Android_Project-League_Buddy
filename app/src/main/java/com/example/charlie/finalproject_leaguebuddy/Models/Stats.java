package com.example.charlie.finalproject_leaguebuddy.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Charlie on 13/07/2016.
 */
public class Stats extends RealmObject {

    @SerializedName("totalDeathsPerSession")
    @Expose
    private int totalDeathsPerSession;
    @SerializedName("totalSessionsPlayed")
    @Expose
    private Integer totalSessionsPlayed;
    @SerializedName("totalDamageTaken")
    @Expose
    private int totalDamageTaken;
    @SerializedName("totalQuadraKills")
    @Expose
    private int totalQuadraKills;
    @SerializedName("totalTripleKills")
    @Expose
    private int totalTripleKills;
    @SerializedName("totalMinionKills")
    @Expose
    private int totalMinionKills;
    @SerializedName("maxChampionsKilled")
    @Expose
    private int maxChampionsKilled;
    @SerializedName("totalDoubleKills")
    @Expose
    private int totalDoubleKills;
    @SerializedName("totalPhysicalDamageDealt")
    @Expose
    private int totalPhysicalDamageDealt;
    @SerializedName("totalChampionKills")
    @Expose
    private int totalChampionKills;
    @SerializedName("totalAssists")
    @Expose
    private int totalAssists;
    @SerializedName("mostChampionKillsPerSession")
    @Expose
    private int mostChampionKillsPerSession;
    @SerializedName("totalDamageDealt")
    @Expose
    private int totalDamageDealt;
    @SerializedName("totalFirstBlood")
    @Expose
    private int totalFirstBlood;
    @SerializedName("totalSessionsLost")
    @Expose
    private int totalSessionsLost;
    @SerializedName("totalSessionsWon")
    @Expose
    private int totalSessionsWon;
    @SerializedName("totalMagicDamageDealt")
    @Expose
    private int totalMagicDamageDealt;
    @SerializedName("totalGoldEarned")
    @Expose
    private int totalGoldEarned;
    @SerializedName("totalPentaKills")
    @Expose
    private int totalPentaKills;
    @SerializedName("totalTurretsKilled")
    @Expose
    private int totalTurretsKilled;
    @SerializedName("mostSpellsCast")
    @Expose
    private int mostSpellsCast;
    @SerializedName("maxNumDeaths")
    @Expose
    private int maxNumDeaths;
    @SerializedName("totalUnrealKills")
    @Expose
    private int totalUnrealKills;

    /**
     *
     * @return
     * The totalDeathsPerSession
     */
    public int getTotalDeathsPerSession() {
        return totalDeathsPerSession;
    }

    /**
     *
     * @param totalDeathsPerSession
     * The totalDeathsPerSession
     */
    public void setTotalDeathsPerSession(int totalDeathsPerSession) {
        this.totalDeathsPerSession = totalDeathsPerSession;
    }

    /**
     *
     * @return
     * The totalSessionsPlayed
     */
    public Integer getTotalSessionsPlayed() {
        return totalSessionsPlayed;
    }

    /**
     *
     * @param totalSessionsPlayed
     * The totalSessionsPlayed
     */
    public void setTotalSessionsPlayed(Integer totalSessionsPlayed) {
        this.totalSessionsPlayed = totalSessionsPlayed;
    }

    /**
     *
     * @return
     * The totalDamageTaken
     */
    public int getTotalDamageTaken() {
        return totalDamageTaken;
    }

    /**
     *
     * @param totalDamageTaken
     * The totalDamageTaken
     */
    public void setTotalDamageTaken(int totalDamageTaken) {
        this.totalDamageTaken = totalDamageTaken;
    }

    /**
     *
     * @return
     * The totalQuadraKills
     */
    public int getTotalQuadraKills() {
        return totalQuadraKills;
    }

    /**
     *
     * @param totalQuadraKills
     * The totalQuadraKills
     */
    public void setTotalQuadraKills(int totalQuadraKills) {
        this.totalQuadraKills = totalQuadraKills;
    }

    /**
     *
     * @return
     * The totalTripleKills
     */
    public int getTotalTripleKills() {
        return totalTripleKills;
    }

    /**
     *
     * @param totalTripleKills
     * The totalTripleKills
     */
    public void setTotalTripleKills(int totalTripleKills) {
        this.totalTripleKills = totalTripleKills;
    }

    /**
     *
     * @return
     * The totalMinionKills
     */
    public int getTotalMinionKills() {
        return totalMinionKills;
    }

    /**
     *
     * @param totalMinionKills
     * The totalMinionKills
     */
    public void setTotalMinionKills(int totalMinionKills) {
        this.totalMinionKills = totalMinionKills;
    }

    /**
     *
     * @return
     * The maxChampionsKilled
     */
    public int getMaxChampionsKilled() {
        return maxChampionsKilled;
    }

    /**
     *
     * @param maxChampionsKilled
     * The maxChampionsKilled
     */
    public void setMaxChampionsKilled(int maxChampionsKilled) {
        this.maxChampionsKilled = maxChampionsKilled;
    }

    /**
     *
     * @return
     * The totalDoubleKills
     */
    public int getTotalDoubleKills() {
        return totalDoubleKills;
    }

    /**
     *
     * @param totalDoubleKills
     * The totalDoubleKills
     */
    public void setTotalDoubleKills(int totalDoubleKills) {
        this.totalDoubleKills = totalDoubleKills;
    }

    /**
     *
     * @return
     * The totalPhysicalDamageDealt
     */
    public int getTotalPhysicalDamageDealt() {
        return totalPhysicalDamageDealt;
    }

    /**
     *
     * @param totalPhysicalDamageDealt
     * The totalPhysicalDamageDealt
     */
    public void setTotalPhysicalDamageDealt(int totalPhysicalDamageDealt) {
        this.totalPhysicalDamageDealt = totalPhysicalDamageDealt;
    }

    /**
     *
     * @return
     * The totalChampionKills
     */
    public int getTotalChampionKills() {
        return totalChampionKills;
    }

    /**
     *
     * @param totalChampionKills
     * The totalChampionKills
     */
    public void setTotalChampionKills(int totalChampionKills) {
        this.totalChampionKills = totalChampionKills;
    }

    /**
     *
     * @return
     * The totalAssists
     */
    public int getTotalAssists() {
        return totalAssists;
    }

    /**
     *
     * @param totalAssists
     * The totalAssists
     */
    public void setTotalAssists(int totalAssists) {
        this.totalAssists = totalAssists;
    }

    /**
     *
     * @return
     * The mostChampionKillsPerSession
     */
    public int getMostChampionKillsPerSession() {
        return mostChampionKillsPerSession;
    }

    /**
     *
     * @param mostChampionKillsPerSession
     * The mostChampionKillsPerSession
     */
    public void setMostChampionKillsPerSession(int mostChampionKillsPerSession) {
        this.mostChampionKillsPerSession = mostChampionKillsPerSession;
    }

    /**
     *
     * @return
     * The totalDamageDealt
     */
    public int getTotalDamageDealt() {
        return totalDamageDealt;
    }

    /**
     *
     * @param totalDamageDealt
     * The totalDamageDealt
     */
    public void setTotalDamageDealt(int totalDamageDealt) {
        this.totalDamageDealt = totalDamageDealt;
    }

    /**
     *
     * @return
     * The totalFirstBlood
     */
    public int getTotalFirstBlood() {
        return totalFirstBlood;
    }

    /**
     *
     * @param totalFirstBlood
     * The totalFirstBlood
     */
    public void setTotalFirstBlood(int totalFirstBlood) {
        this.totalFirstBlood = totalFirstBlood;
    }

    /**
     *
     * @return
     * The totalSessionsLost
     */
    public int getTotalSessionsLost() {
        return totalSessionsLost;
    }

    /**
     *
     * @param totalSessionsLost
     * The totalSessionsLost
     */
    public void setTotalSessionsLost(int totalSessionsLost) {
        this.totalSessionsLost = totalSessionsLost;
    }

    /**
     *
     * @return
     * The totalSessionsWon
     */
    public int getTotalSessionsWon() {
        return totalSessionsWon;
    }

    /**
     *
     * @param totalSessionsWon
     * The totalSessionsWon
     */
    public void setTotalSessionsWon(int totalSessionsWon) {
        this.totalSessionsWon = totalSessionsWon;
    }

    /**
     *
     * @return
     * The totalMagicDamageDealt
     */
    public int getTotalMagicDamageDealt() {
        return totalMagicDamageDealt;
    }

    /**
     *
     * @param totalMagicDamageDealt
     * The totalMagicDamageDealt
     */
    public void setTotalMagicDamageDealt(int totalMagicDamageDealt) {
        this.totalMagicDamageDealt = totalMagicDamageDealt;
    }

    /**
     *
     * @return
     * The totalGoldEarned
     */
    public int getTotalGoldEarned() {
        return totalGoldEarned;
    }

    /**
     *
     * @param totalGoldEarned
     * The totalGoldEarned
     */
    public void setTotalGoldEarned(int totalGoldEarned) {
        this.totalGoldEarned = totalGoldEarned;
    }

    /**
     *
     * @return
     * The totalPentaKills
     */
    public int getTotalPentaKills() {
        return totalPentaKills;
    }

    /**
     *
     * @param totalPentaKills
     * The totalPentaKills
     */
    public void setTotalPentaKills(int totalPentaKills) {
        this.totalPentaKills = totalPentaKills;
    }

    /**
     *
     * @return
     * The totalTurretsKilled
     */
    public int getTotalTurretsKilled() {
        return totalTurretsKilled;
    }

    /**
     *
     * @param totalTurretsKilled
     * The totalTurretsKilled
     */
    public void setTotalTurretsKilled(int totalTurretsKilled) {
        this.totalTurretsKilled = totalTurretsKilled;
    }

    /**
     *
     * @return
     * The mostSpellsCast
     */
    public int getMostSpellsCast() {
        return mostSpellsCast;
    }

    /**
     *
     * @param mostSpellsCast
     * The mostSpellsCast
     */
    public void setMostSpellsCast(int mostSpellsCast) {
        this.mostSpellsCast = mostSpellsCast;
    }

    /**
     *
     * @return
     * The maxNumDeaths
     */
    public int getMaxNumDeaths() {
        return maxNumDeaths;
    }

    /**
     *
     * @param maxNumDeaths
     * The maxNumDeaths
     */
    public void setMaxNumDeaths(int maxNumDeaths) {
        this.maxNumDeaths = maxNumDeaths;
    }

    /**
     *
     * @return
     * The totalUnrealKills
     */
    public int getTotalUnrealKills() {
        return totalUnrealKills;
    }

    /**
     *
     * @param totalUnrealKills
     * The totalUnrealKills
     */
    public void setTotalUnrealKills(int totalUnrealKills) {
        this.totalUnrealKills = totalUnrealKills;
    }


}