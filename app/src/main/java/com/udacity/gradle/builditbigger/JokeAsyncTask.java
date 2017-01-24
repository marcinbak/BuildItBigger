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

import android.os.AsyncTask;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import de.nemo.udacity.bulditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by marcinbak on 24/01/2017.
 */
public class JokeAsyncTask extends AsyncTask<Void, Void, String> {

  private static MyApi myApiService = null;

  @Override
  protected String doInBackground(Void... params) {
    if (myApiService == null) {
      MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
          new AndroidJsonFactory(), null)
          .setRootUrl("http://192.168.0.94:8080/_ah/api/")
          .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
            @Override
            public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
              request.setDisableGZipContent(true);
            }
          });
      myApiService = builder.build();
    }

    try {
      return myApiService.getJoke().execute().getJoke();
    } catch (IOException e) {
      return e.getMessage();
    }
  }

}
