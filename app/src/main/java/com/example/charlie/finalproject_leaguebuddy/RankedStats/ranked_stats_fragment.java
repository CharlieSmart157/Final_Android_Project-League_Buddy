package com.example.charlie.finalproject_leaguebuddy.RankedStats;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.charlie.finalproject_leaguebuddy.BaseTemplates.BaseFragment;
import com.example.charlie.finalproject_leaguebuddy.Content.Content_Contract;
import com.example.charlie.finalproject_leaguebuddy.Content.Content_Presenter;
import com.example.charlie.finalproject_leaguebuddy.Models.RankedStatsModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerMasteryModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerModel;
import com.example.charlie.finalproject_leaguebuddy.R;
import com.example.charlie.finalproject_leaguebuddy.Realm.RealmSummoner;
import com.example.charlie.finalproject_leaguebuddy.Static_Asset_Fetchers.Champ_Icon_Fragment;
import com.example.charlie.finalproject_leaguebuddy.Static_Asset_Fetchers.Champ_Name_Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlie on 13/07/2016.
 */
public class ranked_stats_fragment extends BaseFragment  implements Content_Contract.View{

    View view;
    Content_Presenter mPresenter;
    ProgressDialog progress;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.ranked_stats_table_frag_layout, container, false);
        mPresenter = new Content_Presenter(this);
        progress = ProgressDialog.show(getContext(), "Fetching Data",
                "Please Wait...", true);
        mPresenter.fetchRankedStats(getArguments().getInt("id"));



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

    }

    @Override
    public void setTopMastery(List<SummonerMasteryModel> m) {

    }

    @Override
    public void setRankedStats(RankedStatsModel rankedStats) {
        TableLayout table = (TableLayout)view.findViewById(R.id.stats_tableView);
        if(rankedStats.getChampions().size() > 0){

        for (int i=0; i < rankedStats.getChampions().size(); i++){
            if( rankedStats.getChampions().get(i).getId()!=0) {
                View tableRow = TableLayout.inflate(getContext(), R.layout.ranked_stats_row, null);
                Log.d("CHAMP NAME", rankedStats.getChampions().get(i).getId() + "");
                TextView wins = (TextView) tableRow.findViewById(R.id.NoOfWins);
                wins.setText(rankedStats.getChampions().get(i).getStats().getTotalSessionsWon() + "");
                TextView losses = (TextView) tableRow.findViewById(R.id.NoOfLosses);
                losses.setText(rankedStats.getChampions().get(i).getStats().getTotalSessionsLost() + "");
                TextView kills = (TextView) tableRow.findViewById(R.id.Avg_Kills);
                kills.setText(rankedStats.getChampions().get(i).getStats().getMaxChampionsKilled() + "");
                TextView deaths = (TextView) tableRow.findViewById(R.id.Avg_Deaths);
                deaths.setText(rankedStats.getChampions().get(i).getStats().getMaxNumDeaths() + "");
                TextView gamesPlayed = (TextView) tableRow.findViewById(R.id.TotalGames);
                gamesPlayed.setText(rankedStats.getChampions().get(i).getStats().getTotalSessionsPlayed() + "");

                Fragment fragment;
                Bundle args = new Bundle();

                args.putInt("id", rankedStats.getChampions().get(i).getId());
                android.support.v4.app.FragmentManager frgManager = getActivity().getSupportFragmentManager();

                FrameLayout champ_icon = (FrameLayout) tableRow.findViewById(R.id.champ_icon);
                champ_icon.setId(i + 100);
                fragment = new Champ_Icon_Fragment();
                fragment.setArguments(args);
                frgManager.beginTransaction().replace(i + 100, fragment).commit();


                Fragment fragment2;

                FrameLayout champ_name = (FrameLayout) tableRow.findViewById(R.id.champ_name);
                champ_name.setId(i + 200);
                fragment2 = new Champ_Name_Fragment();
                fragment2.setArguments(args);
                frgManager.beginTransaction().replace(i + 200, fragment2).commit();

                table.addView(tableRow);
            }

        }
}
        else{
            TextView tableRow = new TextView(getContext());
            tableRow.setText("No Ranked Data Found for this Season");

            table.addView(tableRow);
        }
        progress.dismiss();
    }

    @Override
    public void setPresenter(Content_Contract.Presenter presenter) {

    }
}
