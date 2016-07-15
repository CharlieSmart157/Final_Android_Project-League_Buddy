package com.example.charlie.finalproject_leaguebuddy.SummonerMasteryFragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.charlie.finalproject_leaguebuddy.BaseTemplates.BaseFragment;
import com.example.charlie.finalproject_leaguebuddy.Content.Static_Info_Contract;
import com.example.charlie.finalproject_leaguebuddy.Content.Static_Info_Presenter;
import com.example.charlie.finalproject_leaguebuddy.Models.ChampionStaticDataModel;
import com.example.charlie.finalproject_leaguebuddy.R;
import com.example.charlie.finalproject_leaguebuddy.Utility.Constants;

/**
 * Created by Charlie on 12/07/2016.
 */
public class ChampMasteryFragment extends BaseFragment implements Static_Info_Contract.View{
    View view;

    Static_Info_Presenter mStaticPresenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.champ_mastery_fragment_layout, container, false);
        mStaticPresenter = new Static_Info_Presenter(this);
        Log.i("ID_ARG", getArguments().getInt("id")+"");
        if(getArguments().getInt("id") !=0) {
            mStaticPresenter.returnChampStatic(getArguments().getInt("id"));
        }


        return view;
    }

    @Override
    public void recieveChampStatic(ChampionStaticDataModel c) {



        TextView text = (TextView) view.findViewById(R.id.ChampText1);
        text.setText(c.getName());
        TextView text2 = (TextView) view.findViewById(R.id.MasteryText);
        text2.setText(getArguments().getInt("masteryPoints")+" Pts");

        ImageView img = (ImageView) view.findViewById(R.id.ChampImage1);


        Log.d("GLIDE",Constants.DDRAGON_CHAMP_IMG_URL + c.getImage().getFull() );
        Glide.with(this)
                .load(Constants.DDRAGON_CHAMP_IMG_URL + c.getImage().getFull())
                .dontTransform()
                .into(img);

    }


    @Override
    public void setPresenter(Static_Info_Contract.Presenter presenter) {

    }
}
