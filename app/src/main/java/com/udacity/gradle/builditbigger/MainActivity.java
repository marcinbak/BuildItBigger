package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.neofonie.udacity.jokesrenderer.JokeActivity;


public class MainActivity extends AppCompatActivity {

  InterstitialPresenter mInterstitialPresenter;

  @BindView(R.id.loading_layout) View mLoadingLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    mInterstitialPresenter = new InterstitialPresenter();
    mInterstitialPresenter.init(this);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  public void tellJoke(View view) {
    mLoadingLayout.setVisibility(View.VISIBLE);
    new JokeAsyncTask() {
      @Override
      protected void onPostExecute(String s) {
        showInterstitial(s);
      }
    }.execute();
  }

  private void showInterstitial(final String s) {
    mLoadingLayout.setVisibility(View.GONE);
    mInterstitialPresenter.show(new Runnable() {
      @Override
      public void run() {
        JokeActivity.start(MainActivity.this, s);
      }
    });
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mInterstitialPresenter.onDestroy();
  }
}
