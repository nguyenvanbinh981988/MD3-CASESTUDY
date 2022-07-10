package Dao;

import Connect_MySQL.ConnectionMySQL;
import Model.Admin;
import Model.Customer;
import Model.RankGuest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    RankGuestDao rankGuestDao = new RankGuestDao();

    public Customer selectByPassWord(String name,String passWord){
        String sql = "select * from CUSTOMER where name = ? and passWord = ? ;";
        Customer customer = null;

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, passWord);

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();
            int id = rs.getInt("id");
            int rankGuestId =rs.getInt("rankGId");
            RankGuest rankGuest = rankGuestDao.select(rankGuestId);
            String address = rs.getString("address");
            String bankCard = rs.getString("bankCard");


            customer = new Customer(id,name,bankCard,rankGuest,address,passWord);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }



    public Customer selectByBankCard(String name,String bankCard){
        String sql = "select * from CUSTOMER where name =? and bankCard =? ;";
        Customer customer = null;

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, bankCard);

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();
            int id = rs.getInt("id");
            int rankGuestId =rs.getInt("rankGId");
            RankGuest rankGuest = rankGuestDao.select(rankGuestId);
            String address = rs.getString("address");
            String passWord = rs.getString("passWord");


            customer = new Customer(id,name,bankCard,rankGuest,address,passWord);

        } catch (SQLException e) {
            return customer;
        }
        return customer;
    }

    public Admin selectByPassWordAdmin(String name, String passWord){
        String sql = "select * from ADMIN where name =? and passWord =? ;";
        Admin admin = null;

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, passWord);

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();
            int id = rs.getInt("id");
            String position = rs.getString("position");


            admin = new Admin(id,name,position,passWord);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return admin;
    }

    public Admin selectById(int id,String name){
        String sql = "select * from CUSTOMER where name =? and id =? ;";
        Admin admin = null;

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();
            String position = rs.getString("position");
            String passWord = rs.getString("passWord");


            admin = new Admin(id,name,position,passWord);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return admin;
    }
}

