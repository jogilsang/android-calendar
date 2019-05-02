package app.worker.check.application;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;
import com.google.firebase.FirebaseApp;

import app.worker.check.kakasubstitutedriving.R;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseApp.initializeApp(this);

        MobileAds.initialize(this, getString(R.string.admob));

    }

}