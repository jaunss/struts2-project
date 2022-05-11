package com.joaogcm.struts2.hibernate.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.joaogcm.struts2.hibernate.connection.database.ConnectionDatabase;
import com.joaogcm.struts2.hibernate.dao.AuthenticationDAO;

public class AuthenticationDAOImpl extends ConnectionDatabase implements AuthenticationDAO {

	@Override
	public Boolean listLogin(String usernameLogin, String passwordLogin) {
		Connection conn = null;
		PreparedStatement ps = null;

		ResultSet rs = null;
		Boolean status = false;

		try {
			conn = getConnection();

			String sql = "SELECT usernameLogin, passwordLogin FROM login WHERE usernameLogin = ? AND passwordLogin = ?";
			ps = conn.prepareStatement(sql.toString());

			ps.setString(1, usernameLogin);
			ps.setString(2, passwordLogin);

			rs = ps.executeQuery();

			status = rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}
}