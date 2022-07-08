package Dao;

import Connect_MySQL.ConnectionMySQL;
import Model.Customer;
import Model.SellProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerActionDao {
    public List<SellProduct> selectByProductType(String productType) {
        String sql = "select * from RankGuest where productType =?";
        List<SellProduct> sellProducts = new ArrayList<>();

        try (Connection connection = ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, productType);

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


                sellProducts.add(new SellProduct(id, name, price, discount, importAmount, exportAmount, picture, properties, productType, maker));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sellProducts;
    }


    public List<SellProduct> selectByPrice(String productType, String maker1, int minPrice, int maxPrice) {
        String sql = "select * from RankGuest where productType =?";
        List<SellProduct> sellProducts = new ArrayList<>();

        try (Connection connection = ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, productType);

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


                sellProducts.add(new SellProduct(id, name, price, discount, importAmount, exportAmount, picture, properties, productType, maker));
            }

            if (maker1 != null) {
                for (int i = 0; i < sellProducts.size(); i++) {
                    if (!maker1.equals(sellProducts.get(i).getMaker())) {
                        sellProducts.remove(i);
                    }
                }
            }

            for (int i = 0; i < sellProducts.size(); i++) {
                if (sellProducts.get(i).getPrice() < minPrice) {
                    sellProducts.remove(i);
                }
            }

            if (maxPrice != 0) {
                for (int i = 0; i < sellProducts.size(); i++) {
                    if (sellProducts.get(i).getPrice() > maxPrice) {
                        sellProducts.remove(i);
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sellProducts;
    }
}
