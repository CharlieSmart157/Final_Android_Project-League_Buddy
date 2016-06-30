package com.example.charlie.finalproject_leaguebuddy.injection.modules;


import com.example.charlie.finalproject_leaguebuddy.Observables.ISummoner_API;
import com.example.charlie.finalproject_leaguebuddy.injection.scopes.UserScope;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

;

@Module
public class APIModule {

    @Provides
    @UserScope
    public ISummoner_API providesISummoner_API(RestAdapter retrofit) {
        return retrofit.create(ISummoner_API.class);
    }

}
