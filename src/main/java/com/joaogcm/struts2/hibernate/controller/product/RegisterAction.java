package com.joaogcm.struts2.hibernate.controller.product;

import com.joaogcm.struts2.hibernate.dao.impl.EmpDAOImpl;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 4824572646601204108L;

	private String uname;
	private String uemail;
	private String upass;
	private String udeg;
	private String msg = "";

	EmpDAOImpl productDAOImpl = null;
	int ctr = 0;

	@Override
	public String execute() throws Exception {
		productDAOImpl = new EmpDAOImpl();

		try {
			ctr = productDAOImpl.registerUser(uname, uemail, upass, udeg);

			if (ctr > 0) {
				msg = "Registration Successfull";
			} else {
				msg = "Some error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "REGISTER";
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}