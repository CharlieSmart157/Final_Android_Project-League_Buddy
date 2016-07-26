package com.example.charlie.finalproject_leaguebuddy.Content;

import android.app.Activity;
import android.util.Log;

import com.example.charlie.finalproject_leaguebuddy.Models.RankedStatsModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerMasteryModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerRankedLeague;
import com.example.charlie.finalproject_leaguebuddy.Observables.ISummoner_API;
import com.example.charlie.finalproject_leaguebuddy.Realm.RealmController;
import com.example.charlie.finalproject_leaguebuddy.Realm.RealmSummoner;
import com.example.charlie.finalproject_leaguebuddy.Utility.Constants;
import com.example.charlie.finalproject_leaguebuddy.Utility.ItemTypeAdapterFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Charlie on 17/06/2016.
 */
public class Content_Presenter implements Content_Contract.Presenter{

    private CompositeSubscription _subscriptions = new CompositeSubscription();
    private final Content_Contract.View mContentView;

    //@Inject
    ISummoner_API iSummoner_api;
    Activity mActivity;
    //@Inject
    RestAdapter restapi;
    RealmController realmController;
    Realm realm;

    public Content_Presenter (Content_Contract.View v){

    mContentView = v;
    mContentView.setPresenter(this);


      realmController = RealmController.getInstance();


    }

   private void FetchSummonerByName(String id){
       final int[] idNo = {0};
       Gson gson = new GsonBuilder().registerTypeAdapterFactory(new ItemTypeAdapterFactory(id)).create();
       restapi = new RestAdapter.Builder()
               .setEndpoint(Constants.BASE_URL)
               .setConverter(new GsonConverter(gson))
               .setLogLevel(RestAdapter.LogLevel.FULL)
               .build();

        iSummoner_api = restapi.create(ISummoner_API.class);
        _subscriptions.add(iSummoner_api.getSummonerByName(id)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<SummonerModel>() {
                        @Override
                        public void onCompleted() {
                            //Send Results to View
                            Log.i("onCOMPLETED", "DONE");
                            FetchRankedLeagueBySummonerID(idNo[0]);


                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.i("onERROR", e+"");
                        }

                        @Override
                        public void onNext(SummonerModel datum) {
                            realmController.addSummoner(datum);
                            idNo[0] = datum.getId();
                           // mContentView.setSummoner(realmController.getSummoner(datum.getId()));

                        }
                    })


            );

    }

   private void FetchSummonerByID(final int id){
       Gson gson = new GsonBuilder().registerTypeAdapterFactory(new ItemTypeAdapterFactory(""+id)).create();
       Log.i("ID", id+"");
       restapi = new RestAdapter.Builder()
               .setConverter(new GsonConverter(gson))
               .setEndpoint(Constants.BASE_URL)
               .setLogLevel(RestAdapter.LogLevel.FULL)
               .build();
        iSummoner_api = restapi.create(ISummoner_API.class);
        _subscriptions.add(iSummoner_api.getSummonerById(""+id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SummonerModel>() {
                    @Override
                    public void onCompleted() {
                        //Send Results to View
                        Log.i("COMPLETE","Good");
                        FetchRankedLeagueBySummonerID(id);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("ERROR",""+e.toString());
                    }

                    @Override
                    public void onNext(SummonerModel datum) {
                        Log.d("NAME", datum.getName());
                        realmController.addSummoner(datum);
                       // FetchRankedLeagueBySummonerID(datum.getId());

                    }
                })


        );

    }


    public void FetchRankedLeagueBySummonerID(final int id){

       Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().registerTypeAdapterFactory(new ItemTypeAdapterFactory(""+id)).create();

        restapi = new RestAdapter.Builder()
                .setConverter(new GsonConverter(gson))
                .setEndpoint(Constants.BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        iSummoner_api = restapi.create(ISummoner_API.class);

        _subscriptions.add(iSummoner_api.getSummonerRankedLeague(""+id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SummonerRankedLeague>() {
                    @Override
                    public void onCompleted() {
                        //Send Results to View
                        Log.i("COMPLETE","Good");


                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("ERROR Throw",""+e.toString());
                        mContentView.setSummoner(realmController.getSummoner(id));
                        //FetchSummonerByIDUnranked(id);
                    }

                    @Override
                    public void onNext(SummonerRankedLeague datum) {
                        Log.d("SummonerRL",datum.getEntries().get(0).getPlayerOrTeamId()+"");
                        Log.d("REALM_OUTPUT",""+realmController.getSummoner(Integer.parseInt(datum.getEntries().get(0).getPlayerOrTeamId())));
                        RealmSummoner RSummoner = new RealmSummoner(realmController.getSummoner(Integer.parseInt(datum.getEntries().get(0).getPlayerOrTeamId())));
                        RSummoner.setRankedLeague(datum.getEntries().get(0));
                        RSummoner.setRankTier(datum.getTier());
                        realmController.addOrUpdateSummoner(RSummoner);
                        mContentView.setSummoner(realmController.getSummoner(Integer.parseInt(datum.getEntries().get(0).getPlayerOrTeamId())));
                    }
                })


        );

    }


    public void fetchSummonerTopMastery(int id){
        final int[] idNo = {0};
        final List<SummonerMasteryModel> MasteryList = new ArrayList<SummonerMasteryModel>();

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().registerTypeAdapterFactory(new ItemTypeAdapterFactory(""+id)).create();

        restapi = new RestAdapter.Builder()
                .setConverter(new GsonConverter(gson))
                .setEndpoint(Constants.BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        iSummoner_api = restapi.create(ISummoner_API.class);
        _subscriptions.add(iSummoner_api.getSummonerTopMastery(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<SummonerMasteryModel>>() {
                    @Override
                    public void onCompleted() {
                        //Send Results to View
                        Log.i("onCOMPLETED", "DONE");
                        mContentView.setTopMastery(MasteryList);


                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("MasteryOnERROR", e+"");
                    }

                    @Override
                    public void onNext(List<SummonerMasteryModel> datum) {
                       MasteryList.addAll(datum);
                    }
                })

        );



    }

    public void downloadRankedStats(final int id){
        Log.d("FETCHING", id + "");

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().registerTypeAdapterFactory(new ItemTypeAdapterFactory("" + id)).create();


        restapi = new RestAdapter.Builder()
                .setConverter(new GsonConverter(gson))
                .setEndpoint(Constants.BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        iSummoner_api = restapi.create(ISummoner_API.class);
        _subscriptions.add(iSummoner_api.getRankedStatsData(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<RankedStatsModel>() {
                    @Override
                    public void onCompleted() {
                        //Send Results to View
                        Log.i("onCOMPLETED", "RANK STATS DONE");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("onERRORrrrrrrrrss", e + "");
                        RankedStatsModel emptyStats = new RankedStatsModel();
                        emptyStats.setSummonerId(id);
                   //     emptyStats.setChampions(null);
                        mContentView.setRankedStats(emptyStats);

                    }

                    @Override
                    public void onNext(RankedStatsModel datum) {
                        Log.i("DATUM SIZE", datum.getChampions().size() + "");
                        realmController.addRankedStats(datum);
                        mContentView.setRankedStats(datum);
                    }
                })


        );
    }


    public void fetchRankedStats(int id){

        if(doesRankedDataExist(id)==false) {
       downloadRankedStats(id);
        }
        else
            mContentView.setRankedStats(realmController.getRankedData(id));

    }



    @Override
    public void returnSummonerByName(String s){

                if(doesUserNameExist(s))
                    mContentView.setSummoner(realmController.getSummonerByName(s));
        else

                  FetchSummonerByName(s);


    }

    @Override
    public void returnSummonerById(int i) {
        if(doesUserExist(i))
            mContentView.setSummoner(realmController.getSummoner(i));
        else
           FetchSummonerByID(i);
    }


    @Override
    public boolean doesUserExist(int i){
     if(RealmController.getInstance().getSummoner(i)!= null)
       return true;
      else
       return false;
    }

    @Override
    public boolean doesUserNameExist(String s){
        if(realmController.getSummonerByName(s)!=null)
            return true;
        else
            return  false;
    }

    public boolean doesRankedDataExist(int i){
        if(realmController.getRankedData(i)!= null)
            return true;
        else
            return  false;
    }

}
