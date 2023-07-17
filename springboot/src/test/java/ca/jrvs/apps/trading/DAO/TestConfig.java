package ca.jrvs.apps.trading.DAO;

import ca.jrvs.apps.trading.MarketDataConfig;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;


public class TestConfig {

    @Bean
    public MarketDataConfig marketDataConfig(){
        MarketDataConfig config = new MarketDataConfig();
        config.setHost("https://cloud.iexapis.com/v1/");
        config.setToken(System.getenv("IEX_PUB_TOKEN"));
        return config;
    }

    @Bean
    public DataSource dataSource(){
        System.out.println("Creating Apache Data Source...");
        String host = System.getenv("PSQL_HOST");
        String port = System.getenv("PSQL_PORT");
        String db = System.getenv("PSQL_DB");
        String jdbcUrl = "jdbc:postgresql://" + host + ":" + port + "/" + db;
        String user = System.getenv("PSQL_USER");
        String password = System.getenv("PSQL_PASSWORD");

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(jdbcUrl);
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(password);
        return basicDataSource;
    }

    @Bean
    public HttpClientConnectionManager httpClientConnectionManager(){
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
        manager.setMaxTotal(50);
        manager.setDefaultMaxPerRoute(50);
        return manager;
    }
}
