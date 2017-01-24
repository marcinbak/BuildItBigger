/*
 * (c) Neofonie Mobile GmbH (2017)
 *
 * This computer program is the sole property of Neofonie Mobile GmbH (http://mobile.neofonie.de)
 * and is protected under the German Copyright Act (paragraph 69a UrhG).
 *
 * All rights are reserved. Making copies, duplicating, modifying, using or distributing
 * this computer program in any form, without prior written consent of Neofonie Mobile GmbH, is prohibited.
 * Violation of copyright is punishable under the German Copyright Act (paragraph 106 UrhG).
 *
 * Removing this copyright statement is also a violation.
 */
package com.udacity.gradle.builditbigger;

import android.app.Activity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by marcinbak on 24/01/2017.
 */
public class InterstitialPresenter {

  InterstitialAd mInterstitialAd;

  public void init(Activity activity) {
    mInterstitialAd = new InterstitialAd(activity);
    mInterstitialAd.setAdUnitId(activity.getString(R.string.interstitial_ad_unit_id));

    requestNewInterstitial();
  }

  public void show(final Runnable listener) {
    if (mInterstitialAd == null) return;
    if (mInterstitialAd.isLoaded()) {
      mInterstitialAd.setAdListener(new AdListener() {
        @Override
        public void onAdClosed() {
          if (listener != null) listener.run();
        }
      });
      mInterstitialAd.show();
    } else {
      if (listener != null) listener.run();
    }
  }

  private void requestNewInterstitial() {
    if (mInterstitialAd == null) return;

    AdRequest adRequest = new AdRequest.Builder()
//        .addTestDevice("SEE_YOUR_LOGCAT_TO_GET_YOUR_DEVICE_ID")
        .build();

    mInterstitialAd.loadAd(adRequest);
  }

  public void onDestroy() {
    mInterstitialAd = null;
  }

}
