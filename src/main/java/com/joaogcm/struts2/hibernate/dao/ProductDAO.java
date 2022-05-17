package com.joaogcm.struts2.hibernate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ProductDAO {

	public Integer insertProduct(String nmproduct, Double vlpriceproduct, String nmbrandproduct, Integer qtdproduct)
			throws Exception;

	public ResultSet listProducts() throws SQLException, Exception;

	public ResultSet listProductById(Integer idproduct) throws SQLException, Exception;

	public Integer updateProductById(String nmproduct, Double vlpriceproduct, String nmbrandproduct, Integer qtdproduct,
			Integer idproduct) throws SQLException, Exception;

	public Integer deleteProductById(Integer idproduct) throws SQLException, Exception;
}
