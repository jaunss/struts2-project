package com.joaogcm.struts2.hibernate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EmpDAO {

	public Integer registerUser(String uname, String uemail, String upass, String udeg) throws Exception;

	public ResultSet report() throws SQLException, Exception;

	public ResultSet fetchUserDetails(String uemail) throws SQLException, Exception;

	public Integer updateUserDetails(String uname, String uemail, String upass, String udeg, String uemailhidden)
			throws SQLException, Exception;

	public Integer deleteUserDetails(String uemail) throws SQLException, Exception;
}
