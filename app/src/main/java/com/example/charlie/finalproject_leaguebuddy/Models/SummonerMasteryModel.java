package com.example.charlie.finalproject_leaguebuddy.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Charlie on 12/07/2016.
 */
public class SummonerMasteryModel{

        @SerializedName("championPoints")
        @Expose
        private int championPoints;
        @SerializedName("playerId")
        @Expose
        private int playerId;
        @SerializedName("championPointsUntilNextLevel")
        @Expose
        private int championPointsUntilNextLevel;
        @SerializedName("chestGranted")
        @Expose
        private boolean chestGranted;
        @SerializedName("championLevel")
        @Expose
        private int championLevel;
        @SerializedName("tokensEarned")
        @Expose
        private int tokensEarned;
        @SerializedName("championId")
        @Expose
        private int championId;
        @SerializedName("championPointsSinceLastLevel")
        @Expose
        private int championPointsSinceLastLevel;
        @SerializedName("lastPlayTime")
        @Expose
        private int lastPlayTime;

        /**
         *
         * @return
         * The championPoints
         */
        public int getChampionPoints() {
            return championPoints;
        }

        /**
         *
         * @param championPoints
         * The championPoints
         */
        public void setChampionPoints(int championPoints) {
            this.championPoints = championPoints;
        }

        /**
         *
         * @return
         * The playerId
         */
        public int getPlayerId() {
            return playerId;
        }

        /**
         *
         * @param playerId
         * The playerId
         */
        public void setPlayerId(int playerId) {
            this.playerId = playerId;
        }

        /**
         *
         * @return
         * The championPointsUntilNextLevel
         */
        public int getChampionPointsUntilNextLevel() {
            return championPointsUntilNextLevel;
        }

        /**
         *
         * @param championPointsUntilNextLevel
         * The championPointsUntilNextLevel
         */
        public void setChampionPointsUntilNextLevel(int championPointsUntilNextLevel) {
            this.championPointsUntilNextLevel = championPointsUntilNextLevel;
        }

        /**
         *
         * @return
         * The chestGranted
         */
        public boolean isChestGranted() {
            return chestGranted;
        }

        /**
         *
         * @param chestGranted
         * The chestGranted
         */
        public void setChestGranted(boolean chestGranted) {
            this.chestGranted = chestGranted;
        }

        /**
         *
         * @return
         * The championLevel
         */
        public int getChampionLevel() {
            return championLevel;
        }

        /**
         *
         * @param championLevel
         * The championLevel
         */
        public void setChampionLevel(int championLevel) {
            this.championLevel = championLevel;
        }

        /**
         *
         * @return
         * The tokensEarned
         */
        public int getTokensEarned() {
            return tokensEarned;
        }

        /**
         *
         * @param tokensEarned
         * The tokensEarned
         */
        public void setTokensEarned(int tokensEarned) {
            this.tokensEarned = tokensEarned;
        }

        /**
         *
         * @return
         * The championId
         */
        public int getChampionId() {
            return championId;
        }

        /**
         *
         * @param championId
         * The championId
         */
        public void setChampionId(int championId) {
            this.championId = championId;
        }

        /**
         *
         * @return
         * The championPointsSinceLastLevel
         */
        public int getChampionPointsSinceLastLevel() {
            return championPointsSinceLastLevel;
        }

        /**
         *
         * @param championPointsSinceLastLevel
         * The championPointsSinceLastLevel
         */
        public void setChampionPointsSinceLastLevel(int championPointsSinceLastLevel) {
            this.championPointsSinceLastLevel = championPointsSinceLastLevel;
        }

        /**
         *
         * @return
         * The lastPlayTime
         */
        public int getLastPlayTime() {
            return lastPlayTime;
        }

        /**
         *
         * @param lastPlayTime
         * The lastPlayTime
         */
        public void setLastPlayTime(int lastPlayTime) {
            this.lastPlayTime = lastPlayTime;
        }

}