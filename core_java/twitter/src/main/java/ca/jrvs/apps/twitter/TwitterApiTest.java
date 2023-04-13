package ca.jrvs.apps.twitter;

import com.google.gdata.util.common.base.PercentEscaper;
import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.commons.codec.binary.BaseNCodec;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.net.HttpCookie;
import java.util.Arrays;

public class TwitterApiTest {
    private static String Consumer_Key="EkzE6VVQySY3y20Cux0PtBAxb";
    private static String ConsumerSecret="Na4kcQ9RWlAbvdSXlaXdZIBTfUSA8YyJscamEIu644FnZ98Lpq";
    private static String Access_Token="1640394588807479305-8tra8hmDGbf4iQ1O2spjbgRBL3gwb4";
    private static String Token_Secret="T9bO4hDSF3PfsZRUxDgUU829BEbeDkmm7IBEwNBm1TnZC";

    public static void main(String[] args) throws Exception{
        OAuthConsumer oAuthConsumer = new CommonsHttpOAuthConsumer(Consumer_Key,
                ConsumerSecret);
        oAuthConsumer.setTokenWithSecret(Access_Token, Token_Secret);
        String status="Nice Day";
        PercentEscaper percentEscaper=new PercentEscaper("",false);
        HttpPost httpPost = new HttpPost(
                "http://api.twitter.com/2/statuses/update.json?status="+percentEscaper.escape(status));

        oAuthConsumer.sign(httpPost);

        System.out.println("HTTP Request headers");
        Arrays.stream(httpPost.getAllHeaders()).forEach(System.out::println);
        HttpClient httpClient= HttpClientBuilder.create().build();
        HttpResponse httpResponse=httpClient.execute(httpPost);
        System.out.println(EntityUtils.toString(httpResponse.getEntity()));
    }
}
