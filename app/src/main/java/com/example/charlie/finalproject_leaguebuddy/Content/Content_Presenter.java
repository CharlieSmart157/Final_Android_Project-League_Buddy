package com.example.charlie.finalproject_leaguebuddy.Content;

import android.app.Activity;
import android.util.Log;

import com.example.charlie.finalproject_leaguebuddy.Models.SummonerModel;
import com.example.charlie.finalproject_leaguebuddy.Observables.ISummoner_API;
import com.example.charlie.finalproject_leaguebuddy.Realm.RealmController;
import com.example.charlie.finalproject_leaguebuddy.Utility.Constants;
import com.example.charlie.finalproject_leaguebuddy.Utility.ItemTypeAdapterFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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



                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(SummonerModel datum) {
                            RealmController.getInstance().addSummoner(datum);
                            mContentView.setSummoner( new SummonerModel(realmController.getSummoner(datum.getId())));

                        }
                    })


            );

    }

   private void FetchSummonerByID(int id){
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


                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("ERROR",""+e.toString());
                    }

                    @Override
                    public void onNext(SummonerModel datum) {
                        Log.d("NAME", datum.getName());
                        realmController.addSummoner(datum);
                        mContentView.setSummoner( new SummonerModel(realmController.getSummoner(datum.getId())));

                    }
                })


        );

    }


    @Override
    public void returnSummonerByName(String s){

                if(doesUserNameExist(s))
                    mContentView.setSummoner(new SummonerModel(realmController.getSummonerByName(s)));
        else

                  FetchSummonerByName(s);


    }

    @Override
    public void returnSummonerById(int i) {

        if(doesUserExist(i))
            mContentView.setSummoner(new SummonerModel(realmController.getSummoner(i)));
        else

           FetchSummonerByID(i);


    }


    @Override
    public boolean doesUserExist(int i){
        if(RealmController.getInstance().getSummoner(i)!= null)
      return true;
      else
       return  false;
    }

    @Override
    public boolean doesUserNameExist(String s){
        if(realmController.getSummonerByName(s)!=null)
            return true;
        else
            return  false;
    }

}
