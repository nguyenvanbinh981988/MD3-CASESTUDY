package Dao;

import Connect_MySQL.ConnectionMySQL;
import Model.Admin;
import Model.Customer;
import Model.SellList;
import Model.SellProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerActionDao {
    CustomerDao customerDao =new CustomerDao();

    SellProductDao sellProductDao = new SellProductDao();

    AdminDao adminDao = new AdminDao();

    public List<SellProduct> selectByProductType(String productType) {
        String sql = "select * from SELLPRODUCT where ProductType like concat('%',?,'%');";

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


    public List<SellProduct> selectByPrice(String productType1, String maker1, int minPrice, int maxPrice) {
        String sql = "select * from SELLPRODUCT where productType like concat('%',?,'%') and maker like concat('%',?,'%');";
        List<SellProduct> sellProducts = new ArrayList<>();

        try (Connection connection = ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, productType1);
            preparedStatement.setString(2, maker1);

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


                sellProducts.add(new SellProduct(id, name, price, discount, importAmount, exportAmount, picture, properties, productType, maker));
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


//    ----------------------------giỏ hàng--------------------------

    public List<SellList> selectByGio(String statusAdmin1) {
        String sql = "select * from SellList where statusAdmin like concat('%',?,'%');";

        List<SellList> sellLists = new ArrayList<>();

        try (Connection connection = ConnectionMySQL.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, statusAdmin1);

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int exportAmount = rs.getInt("exportAmount");
                int customerId = rs.getInt("customerId");
                Customer customer = customerDao.select(customerId);

                int sellProductId = rs.getInt("sellProductId");
                SellProduct sellProduct = sellProductDao.select(sellProductId);

                int adminId = rs.getInt("adminId");
                Admin admin = adminDao.select(adminId);

                String statusCustomer = rs.getString("statusCustomer");
                String statusAdmin = rs.getString("statusAdmin");


                sellLists.add(new SellList(id, exportAmount, customer,sellProduct,admin,statusCustomer,statusAdmin));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sellLists;
    }

}
