package Dao;

import Connect_MySQL.ConnectionMySQL;
import Model.Admin;
import Model.RankGuest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RankGuestDao implements CRUD<RankGuest> {

    public RankGuestDao() {}

    @Override
    public List<RankGuest> selectAll() {
        String spl = "SELECT * FROM RankGuest;";
        List<RankGuest> rankGuests = new ArrayList<>();
        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(spl);) {
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String rankG = resultSet.getString("rankG");
                Double discount = Double.parseDouble(resultSet.getString("discount"));

                rankGuests.add(new RankGuest(id, rankG,discount));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rankGuests;
    }

    //----------------------------SELECT A CLASS----------------------------------

    public RankGuest select(int id){
        String sql = "select * from RankGuest where id =?;";
        RankGuest rankGuest = null;

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String rankGSt = rs.getString("rankG");
                Double discount = Double.parseDouble(rs.getString("discount"));

                rankGuest = new RankGuest(id,rankGSt,discount);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rankGuest;
    }


    //----------------------------CREATE----------------------------------


    public boolean creat(RankGuest rankGuest) throws SQLException {
        String spl = "INSERT INTO RankGuest (rankG,discount ) VALUES (?,?);";
        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(spl);) {
            preparedStatement.setString(1, rankGuest.getRankG());
            preparedStatement.setDouble(2, rankGuest.getDiscount());

            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //----------------------------EDIT----------------------------------

    public boolean edit(RankGuest rankGuest) throws SQLException{
        String sql = "update RankGuest set rankG = ?,discount =? where id = ?;";
        boolean rowEdit;
        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, rankGuest.getRankG());
            preparedStatement.setDouble(2, rankGuest.getDiscount());
            preparedStatement.setInt(3, rankGuest.getId());

            rowEdit = preparedStatement.executeUpdate() > 0;
        }

        return rowEdit;
    }

    //----------------------------DELETE----------------------------------
    public boolean delete(int id) throws SQLException{
        String sql = "DELETE FROM RankGuest WHERE id = ?;";
        boolean rowDelete;

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

//----------------------------FIND----------------------------------

    public List<RankGuest> selectName(String rankG){
        String sql = "select * from RankGuest where rankG =?;";
        List<RankGuest> rankGuests = new ArrayList<>();

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, rankG);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                Double discount = rs.getDouble("discount");
                RankGuest rankGuest = new RankGuest(id, rankG, discount);

                rankGuests.add(rankGuest);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rankGuests;
    }



    public RankGuest selectRankName(String rankG){
        String sql = "select * from RankGuest where rankG =?;";
        RankGuest rankGuest = null;

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, rankG);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                Double discount = rs.getDouble("discount");
                rankGuest = new RankGuest(id, rankG, discount);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rankGuest;
    }
}
