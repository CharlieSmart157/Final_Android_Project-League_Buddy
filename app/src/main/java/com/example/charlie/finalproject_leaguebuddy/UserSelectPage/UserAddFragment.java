package com.example.charlie.finalproject_leaguebuddy.UserSelectPage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.charlie.finalproject_leaguebuddy.Content.Content_Contract;
import com.example.charlie.finalproject_leaguebuddy.Content.Content_Presenter;
import com.example.charlie.finalproject_leaguebuddy.MainActivity;
import com.example.charlie.finalproject_leaguebuddy.Models.RankedStatsModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerMasteryModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerModel;
import com.example.charlie.finalproject_leaguebuddy.ProfileHolder.ProfileFragment;
import com.example.charlie.finalproject_leaguebuddy.R;
import com.example.charlie.finalproject_leaguebuddy.Realm.RealmSummoner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlie on 11/07/2016.
 */
public class UserAddFragment extends android.support.v4.app.DialogFragment implements Content_Contract.View{

    View view;
    ProfileFragment fragment;
    TextView userEditText;
    SharedPreferences sharedPreferences;
    Button confirmButton;
    Button searchButton;
    Content_Presenter mPresenter;
    int selectedID = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mPresenter = new Content_Presenter(this);
        view = inflater.inflate(R.layout.user_add, container, false);
        sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        Log.d("sharedprefUserID", ""+sharedPreferences.getInt("DefaultID", 0));
        userEditText = (TextView)view.findViewById(R.id.user_field);

        //Search Button
        searchButton = (Button)view.findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener(){

        FrameLayout frameLayout = (FrameLayout)view.findViewById(R.id.dialog_profile_holder);

            @Override
            public void onClick(View v) {
                //initializeProfileView(view);
                mPresenter.returnSummonerByName(userEditText.getText().toString());

            }
        });
        return view;
    }




    public void initializeProfileView(View v){
        Bundle args = new Bundle();
        args.putString("name", userEditText.getText().toString());
        Log.i("ARGS", args.getString("name"));
        args.putBoolean("idMode", false);
        fragment = new ProfileFragment();
        fragment.setArguments(args);
        android.support.v4.app.FragmentManager frgManager = getActivity().getSupportFragmentManager();
        frgManager.beginTransaction().replace(R.id.dialog_profile_holder, fragment).commit();


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
        selectedID = s.getId();
        MainActivity main = (MainActivity) getActivity();
        main.SelectItem(2, selectedID);
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
