package com.example.charlie.finalproject_leaguebuddy.Realm;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import com.example.charlie.finalproject_leaguebuddy.Models.RankedStatsModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerModel;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Charlie on 17/06/2016.
 */

public class RealmController {

    private static RealmController instance;
    private final Realm realm;

    public RealmController(Application application) {
        realm = Realm.getDefaultInstance();
    }

    public static RealmController with(Fragment fragment) {

        if (instance == null) {
            instance = new RealmController(fragment.getActivity().getApplication());
        }
        return instance;
    }

    public static RealmController with(Activity activity) {

        if (instance == null) {
            instance = new RealmController(activity.getApplication());
        }
        return instance;
    }

    public static RealmController with(Application application) {

        if (instance == null) {
            instance = new RealmController(application);
        }
        return instance;
    }

    public static RealmController getInstance() {

        return instance;
    }

    public Realm getRealm() {

        return realm;
    }

    //Refresh the realm instance
   // public void refresh() {

    //    realm.
   // }

    //clear all objects from Book.class
    public void clearAll() {
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }

    //find all objects in the Result.class
    public RealmResults<RealmSummoner> getSummoners() {

        return realm.where(RealmSummoner.class).findAll();
    }

    //find all objects in the Result.class
    public ArrayList<Integer> getSummonerIDs() {
        List<RealmSummoner> RSList= new ArrayList<RealmSummoner>();
        ArrayList<Integer>intList = new ArrayList<Integer>();
        RSList.addAll(realm.where(RealmSummoner.class).equalTo("WatchList",true).findAll());
        for(int i =0; i<RSList.size();i++){
            intList.add(RSList.get(i).getId());
        }
        return intList;

    }


    //query a single item with the given id
    public RealmSummoner getSummonerByName(String id) {

        return realm.where(RealmSummoner.class).equalTo("name",id).findFirst();
    }

    //query a single item with the given id
    public RealmSummoner getSummoner(int id) {

        return realm.where(RealmSummoner.class).equalTo("id",id).findFirst();
    }

    public RankedStatsModel getRankedData(int id) {

        return realm.where(RankedStatsModel.class).equalTo("summonerId",id).findFirst();
    }

    //check if RealmSummoner.class is empty
    public boolean hasResults() {

        //return !realm.where(RealmSummoner.class).isNotEmpty();
        return true;
    }


    public ArrayList<SummonerModel> getLocalList(){
        ArrayList<SummonerModel> n = new ArrayList<SummonerModel>();
        ArrayList<RealmSummoner>r = new ArrayList<RealmSummoner>();

        r.addAll(getSummoners());
        for(int i=0;i<r.size();i++){
            SummonerModel a = new SummonerModel(r.get(i));
            n.add(a);
        }

        return n;
    }

    public void addLocalList(List<SummonerModel> L){
        for(int i=0; i < L.size();i++){
            RealmSummoner RResult = new RealmSummoner(L.get(i));
            if(RealmController.getInstance().getSummoner(RResult.getId())==null)
                RResult.setId(RealmController.getInstance().getSummoners().size());

                realm.beginTransaction();
                realm.copyToRealmOrUpdate(RResult);
                realm.commitTransaction();


        }
    }

    public void addSummoner(SummonerModel S){

        RealmSummoner RSummoner = new RealmSummoner(S);
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(RSummoner);
        realm.commitTransaction();
    }

    public void addOrUpdateSummoner(RealmSummoner S){


        realm.beginTransaction();
        realm.copyToRealmOrUpdate(S);
        realm.commitTransaction();
    }

    //query example
    public RealmResults<RealmSummoner> queriedResults() {

        return realm.where(RealmSummoner.class)
                .contains("author", "Author 0")
                .or()
                .contains("title", "Realm")
                .findAll();

    }

    public void addRankedStats(RankedStatsModel s){
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(s);
        realm.commitTransaction();
    }

}
