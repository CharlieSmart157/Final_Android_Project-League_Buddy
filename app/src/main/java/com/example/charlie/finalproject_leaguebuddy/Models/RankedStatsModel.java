package com.example.charlie.finalproject_leaguebuddy.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Charlie on 13/07/2016.
 */
public class RankedStatsModel extends RealmObject {

    @SerializedName("modifyDate")
    @Expose
    private int modifyDate;
    @SerializedName("champions")
    @Expose
    private RealmList<Champion> champions = new RealmList<Champion>();
    @PrimaryKey
    @SerializedName("summonerId")
    @Expose
    private int summonerId;

/**
 *
 * @return
 * The modifyDate
 */
    public int getModifyDate() {
        return modifyDate;
    }

    /**
     *
     * @param modifyDate
     * The modifyDate
     */
    public void setModifyDate(int modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     *
     * @return
     * The champions
     */
    public RealmList<Champion> getChampions() {
        return champions;
    }

    /**
     *
     * @param champions
     * The champions
     */
    public void setChampions(RealmList<Champion> champions) {


       // if(champions!=null)
            this.champions = champions;

    }

    /**
     *
     * @return
     * The summonerId
     */
    public int getSummonerId() {
        return summonerId;
    }

    /**
     *
     * @param summonerId
     * The summonerId
     */
    public void setSummonerId(int summonerId) {
        this.summonerId = summonerId;
    }


    public int getPlayerTotal(){
        int value = 0;
        for(int i = 0; i < champions.size(); i++){
            if(champions.get(i).getId()==0)
                value = i;

        }
        return value;
    }

}
