package ca.jrvs.apps.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecutor {
    public static void main(String... args) {

        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "hplussport", "postgres", "password");
        try {
            Connection connection=dcm.getConnection();
            CustomerDAO customerDAO= new CustomerDAO(connection);
            /*Customer customer=new Customer();
            customer.setFirstname("Lovepreet");
            customer.setLastname("Kaur");
            customer.setEmail("love@gmail.com");
            customer.setPhone("(682) 789-9846");
            customer.setAddress("26 yuile court");
            customer.setCity("Toronto");
            customer.setState("Punjab");
            customer.setZipcode("L9R5S2");
            customerDAO.create(customer);*/

            Customer customer=customerDAO.findbyId(10000);
            /*System.out.println(customer.getFirstname()+" "+customer.getLastname()+""+customer.getEmail());
            customer.setEmail("mahi@gmail.com");
            customer=customerDAO.update(customer);
            System.out.println(customer.getFirstname()+" "+customer.getLastname()+""+customer.getEmail());*/
            customerDAO.delete(customer.getID());
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

}

