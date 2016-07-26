package com.example.charlie.finalproject_leaguebuddy.Leaderboards;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.charlie.finalproject_leaguebuddy.BaseTemplates.BaseFragment;
import com.example.charlie.finalproject_leaguebuddy.Content.Content_Contract;
import com.example.charlie.finalproject_leaguebuddy.Content.Content_Presenter;
import com.example.charlie.finalproject_leaguebuddy.MainActivity;
import com.example.charlie.finalproject_leaguebuddy.Models.RankedStatsModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerMasteryModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerModel;
import com.example.charlie.finalproject_leaguebuddy.R;
import com.example.charlie.finalproject_leaguebuddy.Realm.RealmController;
import com.example.charlie.finalproject_leaguebuddy.Realm.RealmSummoner;
import com.example.charlie.finalproject_leaguebuddy.Utility.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Charlie on 14/07/2016.
 */
public class SummonerLeaderboardFragment extends BaseFragment implements Content_Contract.View {

    View view;
    TableLayout leaderboard;
    Content_Presenter mPresenter;
    List<Integer> SummonerIDs;
    List<RankedStatsModel>PlayerStatsList = new ArrayList<RankedStatsModel>();
    ProgressDialog progress;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.leaderboard_layout, container, false);
        mPresenter = new Content_Presenter(this);
        initializeLeaderBoard();

        return view;
    }

    public void initializeLeaderBoard(){

        progress = ProgressDialog.show(getContext(), "Fetching Data",
                "Please Wait...", true);

        leaderboard = (TableLayout) view.findViewById(R.id.LB_Table);
      SummonerIDs = getArguments().getIntegerArrayList("ids");
        Log.i("SUMMONERIDS",""+SummonerIDs.size());
        for(int i=0; i< SummonerIDs.size();i++){
            if(getArguments().getBoolean("local")==true)
            mPresenter.fetchRankedStats(SummonerIDs.get(i));
        else
            mPresenter.downloadRankedStats(SummonerIDs.get(i));
        }

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
    public void setRankedStats(final RankedStatsModel rankedStats) {
        if (!PlayerStatsList.contains(rankedStats)) {
            PlayerStatsList.add(rankedStats);
            if(PlayerStatsList.size() == SummonerIDs.size())
            initializeRow();
        }


    }

    public void sortTable(){
        Log.i("SORTING", "TRUE");
        Collections.sort(PlayerStatsList, new Comparator<RankedStatsModel>() {
            @Override
            public int compare(RankedStatsModel var1, RankedStatsModel var2)
            {
                return  var2.getChampions().get(var2.getPlayerTotal()).getStats().getTotalSessionsPlayed().compareTo(var1.getChampions().get(var1.getPlayerTotal()).getStats().getTotalSessionsPlayed());
            }
        });
    }

    public void initializeRow(){
    //    sortTable();
      //  Log.d("RANKED SIZE", PlayerStatsList.size()+"");
        for(int j =0; j < PlayerStatsList.size(); j++){
        final RankedStatsModel rankedStats = PlayerStatsList.get(j);
Log.d("RANKEDCHECK", rankedStats.getSummonerId()+"");
Log.d("RANKEDVALID", rankedStats.getChampions().size()+"");
       if(rankedStats.getChampions().size()>0)
        for (int i=0; i < rankedStats.getChampions().size(); i++){
            if( rankedStats.getChampions().get(i).getId()==0) {

                View tableRow = TableLayout.inflate(getContext(), R.layout.summoner_leaderboard_row, null);

                TextView rank = (TextView) tableRow.findViewById(R.id.rank);
                rank.setText(RealmController.getInstance().getSummoner(rankedStats.getSummonerId()).getRankTier() + " " + RealmController.getInstance().getSummoner(rankedStats.getSummonerId()).getRankedLeague().getDivision());


                TextView name = (TextView) tableRow.findViewById(R.id.summonerName);
                name.setText(RealmController.getInstance().getSummoner(rankedStats.getSummonerId()).getName());

                TextView wins = (TextView) tableRow.findViewById(R.id.wins);
                wins.setText(rankedStats.getChampions().get(i).getStats().getTotalSessionsWon() + "");

                TextView losses = (TextView) tableRow.findViewById(R.id.losses);
                losses.setText(rankedStats.getChampions().get(i).getStats().getTotalSessionsLost() + "");

                TextView gamesPlayed = (TextView) tableRow.findViewById(R.id.gamesPlayed);
                gamesPlayed.setText(rankedStats.getChampions().get(i).getStats().getTotalSessionsPlayed() + "");

                ImageView img = (ImageView)tableRow.findViewById(R.id.summoner_icon);

                Glide.with(this)
                        .load(Constants.DDRAGON_IMG_URL + RealmController.getInstance().getSummoner(rankedStats.getSummonerId()).getProfileIconId()+".png")
                        .dontTransform()
                        .into(img);


                tableRow.setOnClickListener(new View.OnClickListener(){



                    @Override
                    public void onClick(View v) {

                        MainActivity main = (MainActivity) getActivity();
                        main.SelectItem(2, rankedStats.getSummonerId());

                    }
                });
                leaderboard.addView(tableRow);
            }
        }
     else
       {

           Log.d("UNRANKED ROW", "ADDED");

           View tableRow = TableLayout.inflate(getContext(), R.layout.summoner_leaderboard_row, null);

           TextView name = (TextView) tableRow.findViewById(R.id.summonerName);
           name.setText(RealmController.getInstance().getSummoner(rankedStats.getSummonerId()).getName());

           TextView rank = (TextView) tableRow.findViewById(R.id.rank);
           rank.setText("N/A");

           TextView wins = (TextView) tableRow.findViewById(R.id.wins);
           wins.setText("N/A");

           TextView losses = (TextView) tableRow.findViewById(R.id.losses);
           losses.setText("N/A");

           TextView gamesPlayed = (TextView) tableRow.findViewById(R.id.gamesPlayed);
           gamesPlayed.setText("N/A");

           ImageView img = (ImageView)tableRow.findViewById(R.id.summoner_icon);

           Glide.with(this)
                   .load(Constants.DDRAGON_IMG_URL + RealmController.getInstance().getSummoner(rankedStats.getSummonerId()).getProfileIconId()+".png")
                   .dontTransform()
                   .into(img);


           tableRow.setOnClickListener(new View.OnClickListener(){



               @Override
               public void onClick(View v) {

                   MainActivity main = (MainActivity) getActivity();
                   main.SelectItem(2, rankedStats.getSummonerId());

               }
           });
           leaderboard.addView(tableRow);
       }
    }

        progress.dismiss();
 }


    @Override
    public void setPresenter(Content_Contract.Presenter presenter) {

    }
}
