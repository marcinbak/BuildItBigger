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
package com.udacity.gradle.builditbigger.test;

import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;
import com.udacity.gradle.builditbigger.JokeAsyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertEquals;

/**
 * Created by marcinbak on 24/01/2017.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class AsynctaskTest {

  final CountDownLatch signal = new CountDownLatch(1);
  private String mResult;

  @Test
  public void testAsyncTask() throws InterruptedException {
    new JokeAsyncTask() {
      @Override
      protected void onPostExecute(String s) {
        mResult = s;
        signal.countDown();
      }
    }.execute();

    signal.await();

    assertEquals("Poor man's joke: ha ha ha", mResult);
  }

}
