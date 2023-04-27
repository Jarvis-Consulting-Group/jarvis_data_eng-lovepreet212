package ca.jrvs.apps.twitter.dao.helper;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
@Component
public class TwitterHtttpHelper implements HttpHelper {
    private OAuthConsumer consumer;
    private HttpClient httpClient;

    public TwitterHtttpHelper(String consumerKey, String consumerSecret,String accessToken,String tokenSecret){
        consumer=new CommonsHttpOAuthConsumer(consumerKey,consumerSecret);
        consumer.setTokenWithSecret(accessToken,tokenSecret);
        httpClient=new DefaultHttpClient();
    }
    public TwitterHtttpHelper() {
        String CONSUMER_KEY = System.getenv("consumerKey");
        String CONSUMER_SECRET = System.getenv("consumerSecret");
        String ACCESS_TOKEN = System.getenv("accessToken");
        String TOKEN_SECRET = System.getenv("tokenSecret");
        consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        consumer.setTokenWithSecret(ACCESS_TOKEN,TOKEN_SECRET);
        httpClient = new DefaultHttpClient();
    }


    public HttpResponse httpPost(URI uri,StringEntity str)  {
        try{
            return executeHttpRequest(HttpMethod.POST,uri,str);
        } catch (OAuthException|IOException e) {
            throw new RuntimeException(e);
        }


    }

    private HttpResponse executeHttpRequest(HttpMethod method, URI uri, StringEntity stringEntity) throws OAuthException,IOException {
        if(method==HttpMethod.POST){
            HttpPost request=new HttpPost(uri);
            request.setHeader("content-type","application/json");
            if(stringEntity!=null){
                stringEntity.setContentType("application/json");
                request.setEntity(stringEntity);
            }
            consumer.sign(request);
            return httpClient.execute(request);
        }
        else if(method==HttpMethod.GET){
            HttpGet request=new HttpGet(uri);
            consumer.sign(request);
            return httpClient.execute(request);
        }
        else if(method==HttpMethod.DELETE){
            HttpDelete request=new HttpDelete(uri);
            consumer.sign(request);
            return httpClient.execute(request);
        }
        else{
            throw new IllegalArgumentException("Unknown Http method:"+method.name());
        }
    }

    @Override
    public HttpResponse httpGet(URI uri) {
        try{
            return executeHttpRequest(HttpMethod.GET,uri,null);
        } catch (OAuthException|IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public HttpResponse httpDelete(URI uri) {
        try{
            return executeHttpRequest(HttpMethod.DELETE,uri,null);
        } catch (OAuthException|IOException e) {
            throw new RuntimeException(e);
        }
    }

}
