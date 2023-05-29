package ca.jrvs.apps.trading.DAO;

import ca.jrvs.apps.trading.Models.domain.Trader;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@Sql({"classpath:schema.sql"})
public class TraderDaoIntTest {
    @Autowired
    private TraderDao traderDao;
    private Trader trader;

    @Before
    public void insertOne(){

        trader = new Trader();
        trader.setFirstName("Mahi");
        trader.setLastName("Kaur");
        trader.setCountry("India");
        trader.setEmail("love@gmail.com");
        trader.setDob(new Date(System.currentTimeMillis()));
        traderDao.save(trader);
    }

    @Test
    public void findAllById(){
        List<Trader> traders = Lists.newArrayList(traderDao.findAllById(Arrays.asList(1, -1)));
        assertEquals(1, traders.size());
        assertEquals(trader.getCountry(), traders.get(0).getCountry());
    }

    @Test
    public void findById(){
        Optional<Trader> traders = traderDao.findById(1);
        assertEquals(trader.getCountry(), traders.get().getCountry());
    }

    @Test
    public void deleteOne(){
        traderDao.deleteById(trader.getId());
        assertTrue(traderDao.count() == 0);
    }
}
