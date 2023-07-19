package ca.jrvs.apps.trading.DAO;

import ca.jrvs.apps.trading.Models.domain.Account;
import ca.jrvs.apps.trading.Models.domain.TraderAccountView;
import ca.jrvs.apps.trading.Service.TraderAccountService;
import ca.jrvs.apps.trading.Models.domain.Trader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;


import java.sql.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfig.class})
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
        trader.setFirstName("Love");
        trader.setLastName("Kaur");
        trader.setCountry("Canada");
        trader.setEmail("lovekaur@gmail.com");
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