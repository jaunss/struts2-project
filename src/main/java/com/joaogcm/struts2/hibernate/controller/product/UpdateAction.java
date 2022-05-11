package com.joaogcm.struts2.hibernate.controller.product;

import java.sql.ResultSet;

import com.joaogcm.struts2.hibernate.dao.impl.EmpDAOImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport {

	private static final long serialVersionUID = 4824572646601204108L;

	private String uname = "";
	private String uemail = "";
	private String upass = "";
	private String udeg = "";
	private String uemailhidden = "";
	private String msg = "";

	ResultSet rs = null;

	EmpDAOImpl productDAOImpl = null;

	String submitType;

	@Override
	public String execute() throws Exception {
		productDAOImpl = new EmpDAOImpl();
		try {
			if (submitType.equals("updatedata")) {
				rs = productDAOImpl.fetchUserDetails(uemail.trim());
				if (rs != null) {
					while (rs.next()) {
						uname = rs.getString("UNAME");
						uemail = rs.getString("UEMAIL");
						upass = rs.getString("UPASS");
						udeg = rs.getString("UDEG");
					}
				}
			} else {
				int i = productDAOImpl.updateUserDetails(uname, uemail, upass, udeg, uemailhidden);

				if (i > 0) {
					msg = "Record Updated Successfuly";
				} else {
					msg = "error";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "UPDATE";
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String getUdeg() {
		return udeg;
	}

	public void setUdeg(String udeg) {
		this.udeg = udeg;
	}

	public String getUemailhidden() {
		return uemailhidden;
	}

	public void setUemailhidden(String uemailhidden) {
		this.uemailhidden = uemailhidden;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}