package de.neofonie.udacity.jokesrenderer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

  private static final String JOKE_EXTRA = "JOKE_EXTRA";

  public static void start(Context context, String joke) {
    Intent intent = new Intent(context, JokeActivity.class);
    intent.putExtra(JOKE_EXTRA, joke);
    context.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_joke);

    String joke = getIntent().getStringExtra(JOKE_EXTRA);
    TextView tv = (TextView) findViewById(R.id.joke_text_view);
    tv.setText(joke);
  }
}
