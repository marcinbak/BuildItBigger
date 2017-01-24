package de.nemo.udacity.bulditbigger.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class JokeResponse {

  private String joke;

  public String getJoke() {
    return joke;
  }

  public void setJoke(String joke) {
    this.joke = joke;
  }
}