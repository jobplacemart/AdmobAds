package com.example.ads;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.view.View;

import com.example.ads.adView.MyApplication;
import com.example.ads.adView.Utils.AdGlob;
import com.example.ads.adView.Utils.AdmobBannerUtil;
import com.example.ads.adView.Utils.AdmobInterstitialAdUtil;
import com.example.ads.adView.Utils.AdmobNativeUtil;
import com.example.ads.adView.Utils.AdmobNativeUtil_300;
import com.example.ads.databinding.ActivityMainBinding;
import com.google.android.gms.ads.interstitial.InterstitialAd;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    AdmobInterstitialAdUtil admobInterstitialAdUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        admobInterstitialAdUtil = new AdmobInterstitialAdUtil(this);
        AdmobNativeUtil_300.loadNative(this, binding.rlNative, binding.ivSpace);
        AdmobBannerUtil.loadBanner(this, binding.rlBanner);

        binding.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                admobInterstitialAdUtil.showInterstitial(new AdmobInterstitialAdUtil.Callback() {
                    @Override
                    public void OnClose(boolean isFail) {

                    }
                });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        MyApplication.AD_UNIT_ID = AdGlob.Open_App.replace(BuildConfig.ADMOB_OPEN_AD, AdGlob.Open_App);
        MyApplication.init();

        Application application = getApplication();

        if (!(application instanceof MyApplication)) {
            return;
        }
    }
}