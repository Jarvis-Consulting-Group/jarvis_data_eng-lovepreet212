package ca.jrvs.apps.trading.DAO;

import ca.jrvs.apps.trading.MarketDataConfig;
import ca.jrvs.apps.trading.Models.IexQuote;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Iterables;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class MarketDataDao implements CrudRepository<IexQuote,String> {
    private static final String IEX_Batch_Path= "/stock/market/batch?symbols=%s&types=quote&token=";
    private final String IEX_BATCH_URL;

    private Logger logger = LoggerFactory.getLogger(MarketDataDao.class);
    private HttpClientConnectionManager httpClientConnectionManager;

    @Autowired
    public MarketDataDao(HttpClientConnectionManager httpClientConnectionManager, MarketDataConfig marketDataConfig) {
        this.httpClientConnectionManager = httpClientConnectionManager;
        IEX_BATCH_URL = marketDataConfig.getHost() + IEX_Batch_Path + marketDataConfig.getToken();
    }

    @Override
    public <S extends IexQuote> S save(S s) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public <S extends IexQuote> Iterable<S> saveAll(Iterable<S> iterable) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Optional<IexQuote> findById(String s) {
        Optional<IexQuote> iexQuote;
        String uri = String.format(IEX_BATCH_URL, s);
        String response = executeHttpGet(uri).orElseThrow(() -> new IllegalArgumentException("Invalid ticker"));
        JSONObject iexQuotesJson = new JSONObject( response );
        if(iexQuotesJson.length() == 0) {
            throw new IllegalArgumentException("Invalid ticker");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            iexQuote = Optional.ofNullable(objectMapper.readValue(iexQuotesJson.getJSONObject(s).get("quote").toString(), IexQuote.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return iexQuote;
    }

    @Override
    public boolean existsById(String s) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Iterable<IexQuote> findAll() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Iterable<IexQuote> findAllById(Iterable<String> iterable) {
        if(Iterables.size(iterable) == 0) {
            throw new IllegalArgumentException("Tickers is empty");
        }
        String tickerString = String.join(",", iterable);
        String uri = String.format(IEX_BATCH_URL, tickerString);
        String response = executeHttpGet(uri).orElseThrow(() -> new IllegalArgumentException("Invalid ticker"));
        logger.error(response);
        JSONObject IexQuotesJson = new JSONObject(response);

        if(IexQuotesJson.length() == 0) {
            throw new IllegalArgumentException("Invalid ticker");
        }

        List<IexQuote> quotes = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        for (String ticker : iterable) {
            if (IexQuotesJson.has(ticker)) {
                try {
                    IexQuote quote = objectMapper.readValue(IexQuotesJson.getJSONObject(ticker).get("quote").toString(), IexQuote.class);
                    quotes.add(quote);
                } catch (IOException e) {
                    logger.error("Failed to map JSON to class", e);
                }
            } else {
                throw new IllegalArgumentException("Invalid ticker");
            }
        }

        return quotes;

    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteById(String s) {
        throw new UnsupportedOperationException("Not implemented");

    }

    @Override
    public void delete(IexQuote iexQuote) {
        throw new UnsupportedOperationException("Not implemented");

    }

    @Override
    public void deleteAll(Iterable<? extends IexQuote> iterable) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not implemented");

    }
    private Optional<String> executeHttpGet(String url){
        CloseableHttpClient httpClient = getHttpClient();
        HttpUriRequest request = new HttpGet(url);
        try{
            HttpResponse response = httpClient.execute(request);
            String entity = EntityUtils.toString(response.getEntity());
            return Optional.of(entity);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private CloseableHttpClient getHttpClient(){
        return HttpClients.custom().setConnectionManager(httpClientConnectionManager)
                .setConnectionManagerShared(true)
                .build();
    }
}
