package com.joaogcm.struts2.hibernate.controller.authenticate;

import com.joaogcm.struts2.hibernate.dao.impl.AuthenticationDAOImpl;
import com.opensymphony.xwork2.ActionSupport;

public class AuthenticationAction extends ActionSupport {

	private static final long serialVersionUID = 3453222095838270670L;

	private AuthenticationDAOImpl authentication = null;
	private String usernameLogin;
	private String passwordLogin;

	@Override
	public String execute() throws Exception {
		authentication = new AuthenticationDAOImpl();
		if (authentication.listLogin(usernameLogin, passwordLogin)) {
			return "success";
		} else {
			addActionError(getText("error.authenticate"));
			return "error";
		}
	}

	public String getUsernameLogin() {
		return usernameLogin;
	}

	public void setUsernameLogin(String usernameLogin) {
		this.usernameLogin = usernameLogin;
	}

	public String getPasswordLogin() {
		return passwordLogin;
	}

	public void setPasswordLogin(String passwordLogin) {
		this.passwordLogin = passwordLogin;
	}
}