package com.codegnan.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.codegnan.app.util.DBConnection;

public class PaymentDAO {

    public boolean savePayment(int orderId, double amount,
                               String paymentMethod) {

        String sql = "INSERT INTO payments "
                   + "(order_id, amount, payment_method) "
                   + "VALUES (?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, orderId);
            ps.setDouble(2, amount);
            ps.setString(3, paymentMethod);

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