package Dao;

import Connect_MySQL.ConnectionMySQL;
import Model.Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AdminDao implements CRUD<Admin> {

    public AdminDao() {}

    @Override
    public List<Admin> selectAll() {
        String spl = "SELECT * FROM ADMIN;";
        List<Admin> admins = new ArrayList<>();
        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(spl);) {
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String position = resultSet.getString("position");
                String passWord = resultSet.getString("passWord");

                admins.add(new Admin(id, name, position,passWord));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return admins;
    }

    //----------------------------SELECT A CLASS----------------------------------

    public Admin select(int id){
        String sql = "select * from ADMIN where id =?;";
        Admin admin = null;

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String position = rs.getString("position");
                String passWord = rs.getString("passWord");

                admin = new Admin(id,name,position,passWord);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return admin;
    }


    //----------------------------CREATE----------------------------------


    public boolean creat(Admin admin) throws SQLException {
        String spl = "INSERT INTO ADMIN (name, position,passWord ) VALUES (?,?,?);";
        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(spl);) {
            preparedStatement.setString(1, admin.getName());
            preparedStatement.setString(2, admin.getPosition());
            preparedStatement.setString(3, admin.getPassWord());

            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //----------------------------EDIT----------------------------------

    public boolean edit(Admin admin) throws SQLException{
        String sql = "update ADMIN set name = ?, position =?,passWord=? where id = ?;";
        boolean rowEdit;
        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, admin.getName());
            preparedStatement.setString(2, admin.getPosition());
            preparedStatement.setString(3, admin.getPassWord());
            preparedStatement.setInt(4, admin.getId());

            rowEdit = preparedStatement.executeUpdate() > 0;
        }

        return rowEdit;
    }

    //----------------------------DELETE----------------------------------
    public boolean delete(int id) throws SQLException{
        String sql = "DELETE FROM ADMIN WHERE id = ?;";
        boolean rowDelete;

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

//----------------------------FIND----------------------------------

    public List<Admin> selectName(String string){
        String sql = "select * from ADMIN where name like concat('%',?,'%');";
        List<Admin> admins = new ArrayList<>();

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, string);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String position = rs.getString("position");
                String passWord = rs.getString("passWord");
                Admin admin = new Admin(id, name, position,passWord);

                admins.add(admin);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return admins;
    }
}
