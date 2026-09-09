 package com.codegnan.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.codegnan.app.util.DBConnection;

public class OrderItemDAO {

    public boolean saveOrderItem(int orderId,
                                 int menuId,
                                 int quantity,
                                 double price,
                                 double totalPrice) {

        String sql = "INSERT INTO order_items "
                   + "(order_id, menu_id, quantity, price, total_price) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, orderId);
            ps.setInt(2, menuId);
            ps.setInt(3, quantity);
            ps.setDouble(4, price);
            ps.setDouble(5, totalPrice);

            int result = ps.executeUpdate();

            ps.close();
            con.close();

            return result > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
}