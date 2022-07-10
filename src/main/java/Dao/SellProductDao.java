package Dao;

import Connect_MySQL.ConnectionMySQL;
import Model.SellList;
import Model.SellProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SellProductDao implements CRUD<SellProduct> {

    public SellProductDao() {}

    @Override
    public List<SellProduct> selectAll() {
        String spl = "SELECT * FROM SELLPRODUCT;";
        List<SellProduct> sellProducts = new ArrayList<>();
        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(spl);) {
            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                float discount = rs.getFloat("discount");
                int importAmount = rs.getInt("importAmount");
                int exportAmount = rs.getInt("exportAmount");

                String picture = rs.getString("picture");
                String properties = rs.getString("properties");
                String productType = rs.getString("productType");
                String maker = rs.getString("maker");

                sellProducts.add(new SellProduct(id,name,price,discount,importAmount,exportAmount,picture,properties,productType,maker));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sellProducts;
    }

    //----------------------------SELECT A CLASS----------------------------------

    public SellProduct select(int id){
        String sql = "select * from SELLPRODUCT where id =?;";
        SellProduct sellProduct = null;

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                int price = rs.getInt("price");
                float discount = rs.getFloat("discount");
                int importAmount = rs.getInt("importAmount");
                int exportAmount = rs.getInt("exportAmount");

                String picture = rs.getString("picture");
                String properties = rs.getString("properties");
                String productType = rs.getString("productType");
                String maker = rs.getString("maker");

                sellProduct = new SellProduct(id, name,price,discount,importAmount,exportAmount,picture,properties,productType,maker);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sellProduct;
    }


    //----------------------------CREATE----------------------------------


    public boolean creat(SellProduct sellProduct) throws SQLException {
        String spl = "INSERT INTO SELLPRODUCT (name,price,discount,importAmount,exportAmount,picture,properties,productType,maker) VALUES (?,?,?,?,?,?,?,?,?);";
        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(spl);) {
            preparedStatement.setString(1,sellProduct.getName());
            preparedStatement.setInt(2, sellProduct.getPrice());
            preparedStatement.setFloat(3, sellProduct.getDiscount());
            preparedStatement.setInt(4, sellProduct.getImportAmount());
            preparedStatement.setInt(5, sellProduct.getExportAmount());
            preparedStatement.setString(6,sellProduct.getPicture());
            preparedStatement.setString(7,sellProduct.getProperties());
            preparedStatement.setString(8,sellProduct.getProductType());
            preparedStatement.setString(9,sellProduct.getMaker());


            return preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //----------------------------EDIT----------------------------------

    public boolean edit(SellProduct sellProduct) throws SQLException{
        String sql = "update SELLPRODUCT set name=?,price=?,discount=?,importAmount=?,exportAmount=?,picture=?,properties=?,productType=?,maker=? where id = ?;";
        boolean rowEdit;
        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1,sellProduct.getName());
            preparedStatement.setInt(2, sellProduct.getPrice());
            preparedStatement.setFloat(3, sellProduct.getDiscount());
            preparedStatement.setInt(4, sellProduct.getImportAmount());
            preparedStatement.setInt(5, sellProduct.getExportAmount());
            preparedStatement.setString(6,sellProduct.getPicture());
            preparedStatement.setString(7,sellProduct.getProperties());
            preparedStatement.setString(8,sellProduct.getProductType());
            preparedStatement.setString(9,sellProduct.getMaker());

            preparedStatement.setInt(10, sellProduct.getId());

            rowEdit = preparedStatement.executeUpdate() > 0;
        }

        return rowEdit;
    }

    //----------------------------DELETE----------------------------------
    public boolean delete(int id) throws SQLException{
        String sql = "DELETE FROM SELLPRODUCT WHERE id = ?;";
        boolean rowDelete;

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

//----------------------------FIND----------------------------------

    public List<SellProduct> selectName(String string){
        String sql = "select * from SELLPRODUCT where name like concat('%',?,'%') or productType like concat('%',?,'%') or maker like concat('%',?,'%');";
        List<SellProduct> sellProducts = new ArrayList<>();

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, string);
            preparedStatement.setString(2, string);
            preparedStatement.setString(3, string);

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                float discount = rs.getFloat("discount");
                int importAmount = rs.getInt("importAmount");
                int exportAmount = rs.getInt("exportAmount");

                String picture = rs.getString("picture");
                String properties = rs.getString("properties");
                String productType = rs.getString("productType");
                String maker = rs.getString("maker");



                SellProduct sellProduct = new SellProduct(id, name, price, discount, importAmount, exportAmount, picture, properties,productType,maker);
                sellProducts.add(sellProduct);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sellProducts;
    }

    public List<SellProduct> selectByProductType(String string){
        String sql = "select * from SELLPRODUCT where ProductType like concat('%',?,'%');";

        List<SellProduct> sellProducts = new ArrayList<>();

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, string);

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                float discount = rs.getFloat("discount");
                int importAmount = rs.getInt("importAmount");
                int exportAmount = rs.getInt("exportAmount");

                String picture = rs.getString("picture");
                String properties = rs.getString("properties");
                String maker = rs.getString("maker");



                SellProduct sellProduct = new SellProduct(id, name, price, discount, importAmount, exportAmount, picture, properties,string,maker);
                sellProducts.add(sellProduct);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sellProducts;
    }

    public List<SellProduct> selectByProductMaker(String string){
        String sql = "select * from SellProduct where maker = ?;";
        List<SellProduct> sellProducts = new ArrayList<>();

        try (Connection connection =  ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, string);

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                if (string.equals(rs.getString("productType"))) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int price = rs.getInt("price");
                    float discount = rs.getFloat("discount");
                    int importAmount = rs.getInt("importAmount");
                    int exportAmount = rs.getInt("exportAmount");

                    String picture = rs.getString("picture");
                    String properties = rs.getString("properties");
                    String maker = rs.getString("productType");



                    SellProduct sellProduct = new SellProduct(id, name, price, discount, importAmount, exportAmount, picture, properties,maker,string);
                    sellProducts.add(sellProduct);
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sellProducts;
    }
}


