package com.example.charlie.finalproject_leaguebuddy.Utility;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.example.charlie.finalproject_leaguebuddy.injection.components.APIComponents;
import com.example.charlie.finalproject_leaguebuddy.injection.components.DaggerAPIComponents;
import com.example.charlie.finalproject_leaguebuddy.injection.components.DaggerNetComponent;
import com.example.charlie.finalproject_leaguebuddy.injection.components.NetComponent;
import com.example.charlie.finalproject_leaguebuddy.injection.modules.APIModule;
import com.example.charlie.finalproject_leaguebuddy.injection.modules.AppModule;
import com.example.charlie.finalproject_leaguebuddy.injection.modules.NetModule;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Charlie on 29/06/2016.
 */

public class myApp extends Application {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "7dJwGAgdd5gyh4Brg8Iik6zht";
    private static final String TWITTER_SECRET = "FVSCpS2pKBiJHQlJ57RhK4USaFOeu7PgRxxxYC90SzWFNFwFd9";

    private NetComponent mNetComponent;
    private APIComponents mApiComponents;
    @Override
    public void onCreate() {
        super.onCreate();
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig), new Crashlytics());
        mNetComponent= DaggerNetComponent.builder()
                .netModule(new NetModule(Constants.BASE_URL))
                .appModule(new AppModule(this))
                .build();

        mApiComponents= DaggerAPIComponents.builder()
                .netComponent(mNetComponent)
                .aPIModule(new APIModule())
                .build();


        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name("LeagueBuddyRealm.realm")
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);

    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }

    public APIComponents getApiComponent() {
        return mApiComponents;
    }

}
