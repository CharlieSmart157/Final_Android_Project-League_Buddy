package com.example.charlie.finalproject_leaguebuddy.ProfileHolder;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.charlie.finalproject_leaguebuddy.BaseTemplates.BaseFragment;
import com.example.charlie.finalproject_leaguebuddy.Content.Content_Contract;
import com.example.charlie.finalproject_leaguebuddy.Content.Content_Presenter;
import com.example.charlie.finalproject_leaguebuddy.Models.RankedStatsModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerMasteryModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerModel;
import com.example.charlie.finalproject_leaguebuddy.R;
import com.example.charlie.finalproject_leaguebuddy.Realm.RealmController;
import com.example.charlie.finalproject_leaguebuddy.Realm.RealmSummoner;
import com.example.charlie.finalproject_leaguebuddy.Utility.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlie on 29/06/2016.
 */
public class ProfileFragment extends BaseFragment implements Content_Contract.View{

    View view;
    RealmSummoner summoner;
    Content_Presenter mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.profile_holder_card, container, false);
        mPresenter = new Content_Presenter(this);
        if(getArguments().getBoolean("idMode")==true){
         if(getArguments().getInt("id") !=0) {
              mPresenter.returnSummonerById(getArguments().getInt("id"));
         }
        }
        else
        if(getArguments().getBoolean("idMode")==false){
              mPresenter.returnSummonerByName(getArguments().getString("name"));
        }
        return view;
    }

    @Override
    public void setmAdapter(ArrayList<SummonerModel> L) {

    }

    @Override
    public void displaySnackbar() {

    }

    @Override
    public int getUserID() {
        return 0;
    }

    @Override
    public void setSummoner(RealmSummoner s) {
         summoner = s;
         TextView text = (TextView) view.findViewById(R.id.Name_Text);
         text.setText(summoner.getName());
         ImageView img = (ImageView) view.findViewById(R.id.profileImage);
         TextView text2 =(TextView) view.findViewById(R.id.RankText);
         text2.setText(summoner.getRankTier()+" "+summoner.getRankedLeague().getDivision());
         CheckBox watchBox = (CheckBox)view.findViewById(R.id.WatchButton);
         watchBox.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Boolean prevBool = summoner.getWatchList();

                RealmSummoner RSum = new RealmSummoner(summoner);
                RSum.setWatchList(!prevBool);
                RealmController.getInstance().addOrUpdateSummoner(RSum);
                Toast.makeText(getContext(), "Watch List Edited", Toast.LENGTH_SHORT).show();
            }
        });
        watchBox.setChecked(summoner.getWatchList());

        Glide.with(this)
                .load(Constants.DDRAGON_IMG_URL + summoner.getProfileIconId()+".png")
                .dontTransform()
                .into(img);

         Log.d("NAME",summoner.getName());
         Log.d("IMG", Constants.DDRAGON_IMG_URL + summoner.getProfileIconId()+".png");
    }

    @Override
    public void setTopMastery(List<SummonerMasteryModel> m) {

    }

    @Override
    public void setRankedStats(RankedStatsModel rankedStats) {

    }

    @Override
    public void setPresenter(Content_Contract.Presenter presenter) {

    }
}
