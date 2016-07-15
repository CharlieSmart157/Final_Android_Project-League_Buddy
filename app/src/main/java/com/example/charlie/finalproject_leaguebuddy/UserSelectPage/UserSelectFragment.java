package com.example.charlie.finalproject_leaguebuddy.UserSelectPage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.charlie.finalproject_leaguebuddy.BaseTemplates.BaseFragment;
import com.example.charlie.finalproject_leaguebuddy.Content.Content_Contract;
import com.example.charlie.finalproject_leaguebuddy.Content.Content_Presenter;
import com.example.charlie.finalproject_leaguebuddy.MainActivity;
import com.example.charlie.finalproject_leaguebuddy.Models.RankedStatsModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerMasteryModel;
import com.example.charlie.finalproject_leaguebuddy.Models.SummonerModel;
import com.example.charlie.finalproject_leaguebuddy.ProfileHolder.ProfileFragment;
import com.example.charlie.finalproject_leaguebuddy.R;
import com.example.charlie.finalproject_leaguebuddy.Realm.RealmSummoner;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlie on 11/07/2016.
 */
public class UserSelectFragment extends BaseFragment implements Content_Contract.View{

    View view;
    ProfileFragment fragment;
    TextView userEditText;
    SharedPreferences sharedPreferences;
    Button confirmButton;
    Button searchButton;
    Content_Presenter mPresenter;
    int selectedID = 0;
    private TwitterLoginButton loginButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mPresenter = new Content_Presenter(this);
        view = inflater.inflate(R.layout.default_user_set, container, false);
        sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        Log.d("sharedprefUserID", ""+sharedPreferences.getInt("DefaultID", 0));
        userEditText = (TextView)view.findViewById(R.id.user_field);

        //Search Button
        searchButton = (Button)view.findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener(){



            @Override
            public void onClick(View v) {
                initializeProfileView(v);
                mPresenter.returnSummonerByName(userEditText.getText().toString());
            }
        });
        //Confirm Button
        confirmButton = (Button)view.findViewById(R.id.confirm_button);
        confirmButton.setOnClickListener(new View.OnClickListener(){



            @Override
            public void onClick(View v) {
                if(selectedID > 0) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("DefaultID", selectedID);
                    editor.commit();
                    MainActivity main = (MainActivity) getActivity();
                    main.SelectItem(0);
                }
            }
        });

        loginButton = (TwitterLoginButton) view.findViewById(R.id.twitter_login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // The TwitterSession is also available through:
                // Twitter.getInstance().core.getSessionManager().getActiveSession()
                TwitterSession session = result.data;
                // TODO: Remove toast and use the TwitterSession's userID
                // with your app's user model
                String msg = "@" + session.getUserName() + " logged in! (#" + session.getUserId() + ")";
                Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
            }
            @Override
            public void failure(TwitterException exception) {
                Log.d("TwitterKit", "Login with Twitter failure", exception);
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
        frgManager.beginTransaction().replace(R.id.profile_holder, fragment).commit();


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
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Make sure that the loginButton hears the result from any
        // Activity that it triggered.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }

}
