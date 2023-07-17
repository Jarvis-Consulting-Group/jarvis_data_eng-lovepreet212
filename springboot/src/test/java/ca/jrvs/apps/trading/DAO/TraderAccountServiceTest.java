package ca.jrvs.apps.trading.DAO;

import ca.jrvs.apps.trading.Models.domain.Account;
import ca.jrvs.apps.trading.Models.domain.Trader;
import ca.jrvs.apps.trading.Models.domain.TraderAccountView;
import ca.jrvs.apps.trading.Service.TraderAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@Import(TestConfig.class)
@Sql({"classpath:schema.sql"})
public class TraderAccountServiceTest {

    private TraderAccountView savedView;
    @Autowired
    private TraderAccountService traderAccountService;
    @Autowired
    private TraderDao traderDao;
    @Autowired
    private AccountDao accountDao;

    private Trader trader;
    private Account account;

    @Before
    public void setup(){
        trader = new Trader();
        trader.setFirstName("Oreoluwa");
        trader.setLastName("Lawal");
        trader.setCountry("Canada");
        trader.setEmail("oreo@gmail.com");
        trader.setDob((java.sql.Date) new Date(System.currentTimeMillis()));
        savedView =  traderAccountService.createTraderAndAccount(trader);

    }

    @Test
    public void  createTraderAndAccount(){
        assertEquals(traderDao.count(), 1);
        assertEquals(accountDao.count(), 1);

    }

    @Test
    public void  deleteTraderById(){

        traderAccountService.deleteTraderById(1);
        assertEquals(traderDao.count(), 0);
    }

    @Test
    public void deposit(){
        Account account = traderAccountService.deposit(savedView.getTrader().getId(), 20.00);

        assertTrue(account.getAmount() == 20.00);
    }

    @Test
    public void withdraw(){
        traderAccountService.deposit(savedView.getTrader().getId(), 20.00);
        Account account = traderAccountService.withdraw(savedView.getTrader().getId(), 10.00);

        assertTrue(account.getAmount() == 10.00);
    }
}