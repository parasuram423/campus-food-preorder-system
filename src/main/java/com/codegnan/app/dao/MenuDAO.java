 package com.codegnan.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.codegnan.app.model.Menu;
import com.codegnan.app.util.DBConnection;

public class MenuDAO {

    public List<Menu> getAllMenuItems() {

        List<Menu> menuList = new ArrayList<>();

        String sql = "SELECT * FROM menu";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Menu menu = new Menu();

                menu.setId(rs.getInt("id"));
                menu.setItemName(rs.getString("item_name"));
                menu.setPrice(rs.getDouble("price"));

                menuList.add(menu);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return menuList;
    }
}