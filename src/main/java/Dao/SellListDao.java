package Dao;

import Connect_MySQL.ConnectionMySQL;
import Model.Admin;
import Model.Customer;
import Model.SellList;
import Model.SellProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SellListDao implements CRUD<SellList> {
    AdminDao adminDao = new AdminDao();
    CustomerDao customerDao = new CustomerDao();
    SellProductDao sellProductDao =new SellProductDao();

    public SellListDao() {}

    @Override
    public List<SellList> selectAll() {
        String spl = "SELECT * FROM SELLLIST;";
        List<SellList> sellLists = new ArrayList<>();
        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(spl);) {
            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                int id = rs.getInt("id");
                int exportAmount = rs.getInt("exportAmount");
                Customer customer = customerDao.select( rs.getInt("customerId"));
                SellProduct sellProduct = sellProductDao.select(rs.getInt("sellProductId"));
                Admin admin = adminDao.select(rs.getInt("adminId"));

                String statusCustomer = rs.getString("statusCustomer");
                String statusAdmin = rs.getString("statusAdmin");

                sellLists.add(new SellList(id, exportAmount,customer,sellProduct,admin,statusCustomer,statusAdmin));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sellLists;
    }

    //----------------------------SELECT A CLASS----------------------------------

    public SellList select(int id){
        String sql = "select * from SELLLIST where id =?;";
        SellList sellList = null;

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int exportAmount = rs.getInt("exportAmount");
                Customer customer = customerDao.select( rs.getInt("customerId"));
                SellProduct sellProduct = sellProductDao.select(rs.getInt("sellProductId"));
                Admin admin = adminDao.select(rs.getInt("adminId"));

                String statusCustomer = rs.getString("statusCustomer");
                String statusAdmin = rs.getString("statusAdmin");

                sellList = new SellList(id, exportAmount,customer,sellProduct,admin,statusCustomer,statusAdmin);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sellList;
    }


    //----------------------------CREATE----------------------------------


    public boolean creat(SellList sellList) throws SQLException {
        String spl = "INSERT INTO SELLLIST (exportAmount, customerId,sellProductId,adminId,statusCustomer,statusAdmin) VALUES (?,?,?,?,?,?);";
        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(spl);) {
            preparedStatement.setInt(1, sellList.getExportAmount());
            preparedStatement.setInt(2, sellList.getCustomer().getId());
            preparedStatement.setInt(3, sellList.getSellProduct().getId());
            preparedStatement.setInt(4, sellList.getAdmin().getId());
            preparedStatement.setString(5,sellList.getStatusCustomer());
            preparedStatement.setString(6,sellList.getStatusAdmin());


            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //----------------------------EDIT----------------------------------

    public boolean edit(SellList sellList) throws SQLException{
        String sql = "update SELLLIST set exportAmount=?, customerId=?,sellProductId=?,adminId=?,statusCustomer=?,statusAdmin=? where id = ?;";
        boolean rowEdit;
        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, sellList.getExportAmount());
            preparedStatement.setInt(2, sellList.getCustomer().getId());
            preparedStatement.setInt(3, sellList.getSellProduct().getId());
            preparedStatement.setInt(4, sellList.getAdmin().getId());
            preparedStatement.setString(5,sellList.getStatusCustomer());
            preparedStatement.setString(6,sellList.getStatusAdmin());

            preparedStatement.setInt(7, sellList.getId());

            rowEdit = preparedStatement.executeUpdate() > 0;
        }

        return rowEdit;
    }

    //----------------------------DELETE----------------------------------
    public boolean delete(int id) throws SQLException{
        String sql = "DELETE FROM SELLLIST WHERE id = ?;";
        boolean rowDelete;

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

//----------------------------FIND----------------------------------

    public List<SellList> selectName(String string){
        String sql = "select * from SELLLIST where name like concat('%',?,'%') ;";
        List<SellList> sellLists = new ArrayList<>();

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, string);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                Customer name = customerDao.select(rs.getInt("name"));
                int exportAmount = rs.getInt("exportAmount");
                Customer customer = customerDao.select(rs.getInt("customerId"));
                SellProduct sellProduct = sellProductDao.select(rs.getInt("sellProductId"));
                Admin admin = adminDao.select(rs.getInt("adminId"));

                String statusCustomer = rs.getString("statusCustomer");
                String statusAdmin = rs.getString("statusAdmin");

                SellList sellList = new SellList(id, exportAmount, customer, sellProduct, admin, statusCustomer, statusAdmin);
                sellLists.add(sellList);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sellLists;
    }
}


