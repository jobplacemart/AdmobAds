package com.example.ads.adView.Utils;

import android.content.Context;
import android.widget.RelativeLayout;

import com.example.ads.adView.AdmobBanner;
import com.example.ads.adView.listener.BannerListener;


public class AdmobBannerUtil {
    public static void loadBanner(final Context context, final RelativeLayout adContainer) {
        AdmobBanner.show(context, AdGlob.Banner, adContainer, new BannerListener() {
            @Override
            public void onAdFailed() {
                loadBanner(context, adContainer);
            }
        });
    }
}
