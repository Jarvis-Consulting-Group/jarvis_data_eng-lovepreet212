package ca.jrvs.apps.trading.DAO;

import ca.jrvs.apps.trading.Models.domain.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
@Repository
public class QuoteDao implements CrudRepository<Quote,String> {
    private static final String TABLE_NAME = "quote";
    private static final String ID_COLUMN_NAME = "ticker";
    private static final Logger logger = LoggerFactory.getLogger(QuoteDao.class);
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;
    @Autowired
    public QuoteDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName(TABLE_NAME);
    }

    @Override
    public Quote save(Quote quote) {
        if(existsById(quote.getTicker())){
            int updateRowNo = updateOne(quote);
            if(updateRowNo != 1){
                throw new DataRetrievalFailureException("Unable to update quote");
            }
        }
        else{
            addOne(quote);
        }
        return quote;
    }

    private void addOne(Quote quote){
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(quote);
        int row = simpleJdbcInsert.execute(parameterSource);
        if(row != 1){
            throw new IncorrectResultSizeDataAccessException("Failed to insert", 1, row);
        }
    }

    private int updateOne(Quote quote){
        String update_sql = "UPDATE quote SET last_price=?, bid_price=?, "
                + "bid_size=?, ask_price=?, ask_size=? WHERE ticker=?";
        return jdbcTemplate.update(update_sql, makeUpdateValues(quote));
    }

    private Object makeUpdateValues(Quote quote) {
        Object[] values = new Object[]{quote.getLastPrice(), quote.getBidPrice(), quote.getBidSize(),
                quote.getAskPrice(), quote.getAskSize(), quote.getId()};
        return values;
    }

    @Override
    public <S extends Quote> Iterable<S> saveAll(Iterable<S> iterable) {
        iterable.forEach(quote -> save(quote));
        return (List<S>) iterable;
    }

    @Override
    public Optional<Quote> findById(String ticker) {
        Quote quote = null;
        String selectSql = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID_COLUMN_NAME + " =?";

        try {
            quote = jdbcTemplate
                    .queryForObject(selectSql,
                            BeanPropertyRowMapper.newInstance(Quote.class), ticker);
        } catch (EmptyResultDataAccessException e) {
            logger.debug("Can't find trader id:" + ticker, e);
        }
        if (quote == null) {
            return Optional.empty();
        }

        return Optional.of(quote);
    }

    @Override
    public boolean existsById(String id) {
        if(findById(id).isPresent()) return true;

        return false;
    }

    @Override
    public Iterable<Quote> findAll() {
        String select_all = "SELECT * FROM " + TABLE_NAME;
        List<Quote> quotes = jdbcTemplate.query(select_all, BeanPropertyRowMapper.newInstance(Quote.class));
        return quotes;
    }

    @Override
    public Iterable<Quote> findAllById(Iterable<String> iterable) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public long count() {
        String query = "SELECT COUNT(*) FROM " + TABLE_NAME;

        return jdbcTemplate.queryForObject(query, long.class);
    }

    @Override
    public void deleteById(String id) {
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + ID_COLUMN_NAME + "=?";
        jdbcTemplate.update(query, id);
    }

    @Override
    public void delete(Quote quote) {
        throw new UnsupportedOperationException("Not implemented");

    }

    @Override
    public void deleteAll() {
        String query = "DELETE FROM " + TABLE_NAME;
        jdbcTemplate.update(query);
    }


    @Override
    public void deleteAll(Iterable<? extends Quote> iterable) {
      throw new UnsupportedOperationException("Not implemented");
    }

}
