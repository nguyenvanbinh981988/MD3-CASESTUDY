package Dao;

import Connect_MySQL.ConnectionMySQL;
import Model.Customer;
import Model.RankGuest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CustomerDao implements CRUD<Customer> {

    private RankGuestDao rankGuestDao = new RankGuestDao();

    public CustomerDao() {}

    @Override
    public List<Customer> selectAll() {
        String spl = "SELECT * FROM customer;";
        List<Customer> customers = new ArrayList<>();
        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(spl);) {
            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String bankCard = rs.getString("bankCard");
                int rankGId = rs.getInt("rankGId");
                RankGuest rankGuest = rankGuestDao.select(rankGId);
                String address = rs.getString("address");
                String passWord = rs.getString("passWord");

                customers.add(new Customer(id, name, bankCard,rankGuest,address,passWord));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    //----------------------------SELECT A CLASS----------------------------------

    public Customer select(int id){
        String sql = "select * from CUSTOMER where id =?;";
        Customer customer = null;

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String bankCard = rs.getString("bankCard");
                int rankGId = rs.getInt("rankGId");
                RankGuest rankGuest = rankGuestDao.select(rankGId);
                String address = rs.getString("address");
                String passWord = rs.getString("passWord");


                customer = new Customer(id, name, bankCard,rankGuest,address,passWord);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }


    //----------------------------CREATE----------------------------------


    public boolean creat(Customer customer) throws SQLException {
        String spl = "INSERT INTO CUSTOMER (name, bankCard,rankGId,address,passWord) VALUES (?,?,?,?,?);";
        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(spl);) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getBankCard());
            preparedStatement.setInt(3, customer.getRankGuest().getId());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.setString(5, customer.getPassWord());


            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //----------------------------EDIT----------------------------------

    public boolean edit(Customer customer) throws SQLException{
        String sql = "update CUSTOMER set name = ?, bankcard =?,rankGId=?,address=?,passWord = ? where id = ?;";
        boolean rowEdit;
        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getBankCard());
            preparedStatement.setInt(3, customer.getRankGuest().getId());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.setString(5, customer.getPassWord());

            preparedStatement.setInt(6, customer.getId());

            rowEdit = preparedStatement.executeUpdate() > 0;
        }

        return rowEdit;
    }

    //----------------------------DELETE----------------------------------
    public boolean delete(int id) throws SQLException{
        String sql = "DELETE FROM CUSTOMER WHERE id = ?;";
        boolean rowDelete;

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

//----------------------------FIND----------------------------------

    public List<Customer> selectName(String string){
        String sql = "select * from CUSTOMER where name like concat('%',?,'%') or bankCard like concat('%',?,'%');";
        List<Customer> customers = new ArrayList<>();

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, string);
            preparedStatement.setString(2, string);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String bankCard = rs.getString("bankCard");
                int rankGId = rs.getInt("rankGId");
                RankGuest rankGuest = rankGuestDao.select(rankGId);
                String address = rs.getString("address");
                String passWord = rs.getString("passWord");

                Customer customer = new Customer(id, name, bankCard, rankGuest, address,passWord);
                customers.add(customer);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }
}

