package com.asadullahnawaz.xgridtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView optionRecyclerView;
    OptionsAdapter optionsAdapter;
    ArrayList<OptionModel> options = new ArrayList<OptionModel>();
    ImageView nightMode;
    TextView personName;
    TextView personEmail;
    TextView logoutText;
    CardView logout;
    int currentNightMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personName = findViewById(R.id.person_name);
        personEmail = findViewById(R.id.person_email);
        logout = findViewById(R.id.logout);
        optionRecyclerView = findViewById(R.id.options_recycler_view);
        optionRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        nightMode = findViewById(R.id.night_mode);
        logoutText = findViewById(R.id.logout_text);

        options.add(new OptionModel("Privacy", R.drawable.privacy_icon));
        options.add(new OptionModel("Purchase History", R.drawable.history_icon));
        options.add(new OptionModel("Help & Support", R.drawable.help_icon));
        options.add(new OptionModel("Settings", R.drawable.settings_icon));
        options.add(new OptionModel("Invite a Friend", R.drawable.invite_icon));

        optionsAdapter = new OptionsAdapter(this,options);
        optionRecyclerView.setAdapter(optionsAdapter);

        currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;

        if(currentNightMode == Configuration.UI_MODE_NIGHT_YES){
            personName.setTextColor(Color.parseColor("#FFFFFF"));
            personEmail.setTextColor(Color.parseColor("#FFFFFF"));
            logoutText.setTextColor(Color.parseColor("#000000"));
            logout.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
        }

        else{
            personName.setTextColor(Color.parseColor("#000000"));
            personEmail.setTextColor(Color.parseColor("#000000"));
            logoutText.setTextColor(Color.parseColor("#FFFFFF"));

            logout.setCardBackgroundColor(Color.parseColor("#000000"));
        }

        nightMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(currentNightMode == Configuration.UI_MODE_NIGHT_YES){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

                    personName.setTextColor(Color.parseColor("#000000"));
                    personEmail.setTextColor(Color.parseColor("#000000"));
                }

                else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    personName.setTextColor(Color.parseColor("#FFFFFF"));
                    personEmail.setTextColor(Color.parseColor("#FFFFFF"));
                }

                recreate();

            }
        });

    }
}