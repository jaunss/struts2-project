package com.joaogcm.struts2.hibernate.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.joaogcm.struts2.hibernate.connection.database.ConnectionDatabase;
import com.joaogcm.struts2.hibernate.dao.EmpDAO;

public class EmpDAOImpl extends ConnectionDatabase implements EmpDAO {

	@Override
	public Integer registerUser(String uname, String uemail, String upass, String udeg) throws Exception {
		PreparedStatement ps = null;
		int i = 0;

		try {
			getConnection();

			String sql = "INSERT INTO struts2crud (uname, uemail, upass, udeg) VALUES (?,?,?,?)";
			ps = getConnection().prepareStatement(sql);

			ps.setString(1, uname);
			ps.setString(2, uemail);
			ps.setString(3, upass);
			ps.setString(4, udeg);

			i = ps.executeUpdate();

			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	@Override
	public ResultSet report() throws SQLException, Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			getConnection();

			String sql = "SELECT uname, uemail, upass, udeg FROM struts2crud";
			ps = getConnection().prepareStatement(sql);

			rs = ps.executeQuery();

			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	@Override
	public ResultSet fetchUserDetails(String uemail) throws SQLException, Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			getConnection();

			String sql = "SELECT uname, uemail, upass, udeg FROM struts2crud WHERE uemail = ?";
			ps = getConnection().prepareStatement(sql);

			ps.setString(1, uemail);

			rs = ps.executeQuery();

			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	@Override
	public Integer updateUserDetails(String uname, String uemail, String upass, String udeg, String uemailhidden)
			throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		PreparedStatement ps = null;
		int i = 0;

		try {
			getConnection();

			String sql = "UPDATE struts2crud SET uname = ?, uemail = ?, upass = ?, udeg = ? WHERE uemail = ?";
			ps = getConnection().prepareStatement(sql);

			ps.setString(1, uname);
			ps.setString(2, uemail);
			ps.setString(3, upass);
			ps.setString(4, udeg);
			ps.setString(5, uemailhidden);

			i = ps.executeUpdate();

			return i;
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return 0;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

	@Override
	public Integer deleteUserDetails(String uemail) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		PreparedStatement ps = null;
		int i = 0;

		try {
			getConnection();

			String sql = "DELETE FROM struts2crud WHERE uemail = ?";
			ps = getConnection().prepareStatement(sql);

			ps.setString(1, uemail);

			i = ps.executeUpdate();

			return i;
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return 0;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
}