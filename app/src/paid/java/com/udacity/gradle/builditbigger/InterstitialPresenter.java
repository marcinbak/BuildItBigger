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

/**
 * Created by marcinbak on 24/01/2017.
 */
public class InterstitialPresenter {


  public void init(Activity activity) {
  }

  public void show(Runnable listener) {
    if (listener != null) listener.run();
  }

  public void onDestroy() {
  }

}
