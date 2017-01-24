/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package de.nemo.udacity.bulditbigger.backend;

import com.example.Joker;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
    name = "myApi",
    version = "v1",
    namespace = @ApiNamespace(
        ownerDomain = "backend.bulditbigger.udacity.nemo.de",
        ownerName = "backend.bulditbigger.udacity.nemo.de",
        packagePath = ""
    )
)
public class MyEndpoint {

  private Joker mJoker = new Joker();

  /**
   * A simple endpoint method that takes a name and says Hi back
   */
  @ApiMethod(name = "getJoke")
  public JokeResponse getJoke() {
    JokeResponse response = new JokeResponse();
    response.setJoke(mJoker.getJoke());

    return response;
  }

}
