package com.example.ads.adView.Utils;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.ads.adView.AdmobNative;
import com.example.ads.adView.listener.NativeListener;


public class AdmobNativeUtil_300 {

    public static void loadNative(final Context context, final RelativeLayout adContainer, View space) {
        AdmobNative.loadNativeAd_300(context,  AdGlob.Native_Advanced, adContainer, space, true, new NativeListener() {
            @Override
            public void onAdFailed() {
                android.util.Log.e("fksdsdkjs", "fiallll");
            }
        });
    }

}
