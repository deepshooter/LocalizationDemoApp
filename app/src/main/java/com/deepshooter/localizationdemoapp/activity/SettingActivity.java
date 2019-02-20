package com.deepshooter.localizationdemoapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.deepshooter.localizationdemoapp.App;
import com.deepshooter.localizationdemoapp.R;

import static com.deepshooter.localizationdemoapp.utils.LocaleManager.LANGUAGE_ENGLISH;
import static com.deepshooter.localizationdemoapp.utils.LocaleManager.LANGUAGE_HINDI;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Button englishButton = findViewById(R.id.englishButton);
        Button hindiButton = findViewById(R.id.hindiButton);


        englishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setNewLocale(LANGUAGE_ENGLISH,false);
            }
        });

        hindiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setNewLocale(LANGUAGE_HINDI,true);
            }
        });


    }

    private boolean setNewLocale(String language, boolean restartProcess) {
        App.localeManager.setNewLocale(this, language);

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));

        if (restartProcess) {
            System.exit(0);
        } else {
            Toast.makeText(this, "Activity restarted", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
