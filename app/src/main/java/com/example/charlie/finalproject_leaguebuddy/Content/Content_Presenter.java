package com.example.charlie.finalproject_leaguebuddy.Content;

import android.app.Activity;

import com.example.charlie.finalproject_leaguebuddy.Models.SummonerModel;
import com.example.charlie.finalproject_leaguebuddy.Observables.ISummoner_API;
import com.example.charlie.finalproject_leaguebuddy.Realm.RealmController;
import com.example.charlie.finalproject_leaguebuddy.Utility.Constants;

import retrofit.RestAdapter;
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
    RestAdapter restapi;


    @Override
    public void start() {}

    public Content_Presenter (Content_Contract.View v){

    mContentView = v;
    mContentView.setPresenter(this);
         restapi = new RestAdapter.Builder()
                .setEndpoint(Constants.BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

    }

    public void FetchSummoner(String id){

        iSummoner_api = restapi.create(ISummoner_API.class);
        _subscriptions.add(iSummoner_api.getSummoners(id)
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

                        }
                    })


            );



            mContentView.setmAdapter(RealmController.getInstance().getLocalList());
            mContentView.displaySnackbar();

    }




    @Override
    public void returnSummoner( String s){


                 FetchSummoner(s);
    }


}
