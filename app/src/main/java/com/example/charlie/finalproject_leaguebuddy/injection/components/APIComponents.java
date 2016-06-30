package com.example.charlie.finalproject_leaguebuddy.injection.components;


import com.example.charlie.finalproject_leaguebuddy.MainActivity;
import com.example.charlie.finalproject_leaguebuddy.injection.modules.APIModule;
import com.example.charlie.finalproject_leaguebuddy.injection.scopes.UserScope;

import dagger.Component;


/**
 * Created by kalpesh on 20/01/2016.
 */

    @UserScope
    @Component(dependencies =NetComponent.class, modules = APIModule.class)
    public interface APIComponents {

    void inject(MainActivity activity);

}
