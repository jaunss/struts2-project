package com.joaogcm.struts2.hibernate.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.joaogcm.struts2.hibernate.connection.database.ConnectionDatabase;
import com.joaogcm.struts2.hibernate.dao.ProductDAO;

public class ProductDAOImpl extends ConnectionDatabase implements ProductDAO {

	@Override
	public Integer insertProduct(String nmproduct, Double vlpriceproduct, String nmbrandproduct, Integer qtdproduct)
			throws Exception {
		PreparedStatement ps = null;
		int i = 0;

		try {
			getConnection();

			String sql = "INSERT INTO product (nmproduct, vlpriceproduct, nmbrandproduct, qtdproduct) VALUES (?,?,?,?)";
			ps = getConnection().prepareStatement(sql);

			ps.setString(1, nmproduct);
			ps.setDouble(2, vlpriceproduct);
			ps.setString(3, nmbrandproduct);
			ps.setInt(4, qtdproduct);

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
	public ResultSet listProducts() throws SQLException, Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			getConnection();

			String sql = "SELECT idproduct, nmproduct, vlpriceproduct, nmbrandproduct, qtdproduct FROM product";
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
	public ResultSet listProductById(Integer idproduct) throws SQLException, Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			getConnection();

			String sql = "SELECT idproduct, nmproduct, vlpriceproduct, nmbrandproduct, qtdproduct FROM product WHERE idproduct = ?";
			ps = getConnection().prepareStatement(sql);

			ps.setInt(1, idproduct);

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
	public Integer updateProductById(String nmproduct, Double vlpriceproduct, String nmbrandproduct, Integer qtdproduct,
			Integer idproduct) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		PreparedStatement ps = null;
		int i = 0;

		try {
			getConnection();

			String sql = "UPDATE product SET nmproduct = ?, vlpriceproduct = ?, nmbrandproduct = ?, qtdproduct = ? WHERE idproduct = ?";
			ps = getConnection().prepareStatement(sql);

			ps.setString(1, nmproduct);
			ps.setDouble(2, vlpriceproduct);
			ps.setString(3, nmbrandproduct);
			ps.setInt(4, qtdproduct);
			ps.setInt(5, idproduct);

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
	public Integer deleteProductById(Integer idproduct) throws SQLException, Exception {
		getConnection().setAutoCommit(false);
		PreparedStatement ps = null;
		int i = 0;

		try {
			getConnection();

			String sql = "DELETE FROM product WHERE idproduct = ?";
			ps = getConnection().prepareStatement(sql);

			ps.setInt(1, idproduct);

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