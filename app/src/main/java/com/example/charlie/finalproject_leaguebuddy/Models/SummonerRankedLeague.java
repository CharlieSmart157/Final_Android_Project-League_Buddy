package com.example.charlie.finalproject_leaguebuddy.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlie on 04/07/2016.
 */
public class SummonerRankedLeague {

    @SerializedName("queue")
    @Expose
    private String queue;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("entries")
    @Expose
    private List<Entry> entries = new ArrayList<Entry>();
    @SerializedName("tier")
    @Expose
    private String tier;

    /**
     *
     * @return
     * The queue
     */
    public String getQueue() {
        return queue;
    }

    /**
     *
     * @param queue
     * The queue
     */
    public void setQueue(String queue) {
        this.queue = queue;
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
     * The entries
     */
    public List<Entry> getEntries() {
        return entries;
    }

    /**
     *
     * @param entries
     * The entries
     */
    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    /**
     *
     * @return
     * The tier
     */
    public String getTier() {
        return tier;
    }

    /**
     *
     * @param tier
     * The tier
     */
    public void setTier(String tier) {
        this.tier = tier;
    }

}