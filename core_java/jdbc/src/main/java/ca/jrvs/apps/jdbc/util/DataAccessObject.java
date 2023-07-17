package ca.jrvs.apps.jdbc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class DataAccessObject <T extends DataTransferObject>{
    protected final Connection connection;
    protected final static String LAST_VAL="Select last_value  FROM";
    protected final static String Customer_Sequence="customer_seq";

    public DataAccessObject(Connection connection) {
        super();
        this.connection = connection;
    }
    public abstract T findbyId(long id);
    public abstract List<T> findAll();
    public abstract T update(T dto);
    public abstract T create(T dto);
    public abstract void delete(long id);
    protected int getLastVal(String sequence){
        int key=0;
        String sql= LAST_VAL+sequence;
        try(Statement statement=connection.createStatement()) {
            ResultSet resultSet= statement.executeQuery(sql);
            while(resultSet.next()){
                key= resultSet.getInt(1);
            }
            return key;
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
