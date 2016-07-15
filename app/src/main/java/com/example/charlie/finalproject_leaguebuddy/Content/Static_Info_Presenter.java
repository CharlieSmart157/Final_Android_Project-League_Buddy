package com.example.charlie.finalproject_leaguebuddy.Content;

import android.app.Activity;
import android.util.Log;

import com.example.charlie.finalproject_leaguebuddy.Models.ChampionStaticDataModel;
import com.example.charlie.finalproject_leaguebuddy.Observables.ISummoner_API;
import com.example.charlie.finalproject_leaguebuddy.Utility.Constants;

import retrofit.RestAdapter;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Charlie on 12/07/2016.
 */
public class Static_Info_Presenter implements Static_Info_Contract.Presenter{

    private CompositeSubscription _subscriptions = new CompositeSubscription();
    private final Static_Info_Contract.View mContentView;

    //@Inject
    ISummoner_API iSummoner_api;
    Activity mActivity;
    //@Inject
    RestAdapter restapi;

    public Static_Info_Presenter (Static_Info_Contract.View v){

        mContentView = v;
        mContentView.setPresenter(this);



    }

    @Override
    public void returnChampStatic(int i) {

        restapi = new RestAdapter.Builder()
                .setEndpoint(Constants.STATIC_DATA_BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        iSummoner_api = restapi.create(ISummoner_API.class);
        _subscriptions.add(iSummoner_api.getChampStaticData(i)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ChampionStaticDataModel>() {
                    @Override
                    public void onCompleted() {
                        //Send Results to View
                        Log.i("onCOMPLETED", "DONE");


                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("onERROR", e+"");
                    }

                    @Override
                    public void onNext(ChampionStaticDataModel datum) {

                        mContentView.recieveChampStatic(datum);

                    }
                })
        );
    }




}
