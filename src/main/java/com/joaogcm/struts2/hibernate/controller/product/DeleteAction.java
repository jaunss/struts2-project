package com.joaogcm.struts2.hibernate.controller.product;

import com.joaogcm.struts2.hibernate.dao.impl.EmpDAOImpl;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport {

	private static final long serialVersionUID = 4824572646601204108L;

	String uemail;
	EmpDAOImpl productDAOImpl = null;
	String msg = "";

	@Override
	public String execute() throws Exception {
		productDAOImpl = new EmpDAOImpl();
		try {
			int isDeleted = productDAOImpl.deleteUserDetails(uemail);

			if (isDeleted > 0) {
				msg = "Record deleted successfully";
			} else {
				msg = "Some error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "DELETE";
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}