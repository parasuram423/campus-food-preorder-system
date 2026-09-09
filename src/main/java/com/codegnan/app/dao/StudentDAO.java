 package com.codegnan.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.codegnan.app.util.DBConnection;

public class StudentDAO {

	public boolean validateStudent(String email, String password) {

	    String sql =
	            "SELECT * FROM students WHERE email = ? AND password = ?";

	    try {

	        Connection con = DBConnection.getConnection();

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, email);
	        ps.setString(2, password);

	        ResultSet rs = ps.executeQuery();

	        boolean valid = rs.next();

	        rs.close();
	        ps.close();
	        con.close();

	        return valid;

	    } catch (Exception e) {

	        throw new RuntimeException(e);

	    }
	}
}