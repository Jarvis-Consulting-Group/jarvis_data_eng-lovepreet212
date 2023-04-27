package ca.jrvs.apps.twitter.dao.helper;

import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.springframework.stereotype.Component;

@Component
public interface HttpHelper {


  /**
   * Execute a HTTP Get call
   * @param uri
   * @return
   */
  HttpResponse httpGet(URI uri);

  HttpResponse httpDelete(URI uri);

  HttpResponse httpPost(URI uri, StringEntity stringEntity);
}
