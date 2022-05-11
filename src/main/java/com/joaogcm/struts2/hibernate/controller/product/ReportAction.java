package com.joaogcm.struts2.hibernate.controller.product;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.joaogcm.struts2.hibernate.bean.EmpBean;
import com.joaogcm.struts2.hibernate.dao.impl.EmpDAOImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ReportAction extends ActionSupport {

	private static final long serialVersionUID = 4824572646601204108L;

	ResultSet rs = null;
	EmpBean empBean = null;
	List<EmpBean> listBean = null;
	EmpDAOImpl productDAOImpl = new EmpDAOImpl();
	private boolean noData = false;

	@Override
	public String execute() throws Exception {
		try {
			listBean = new ArrayList<EmpBean>();
			rs = productDAOImpl.report();
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					empBean = new EmpBean();
					empBean.setSrNo(i);
					empBean.setUname(rs.getString("UNAME"));
					empBean.setUemail(rs.getString("UEMAIL"));
					empBean.setUpass(rs.getString("UPASS").replaceAll("(?s).", "*"));
					empBean.setUdeg(rs.getString("UDEG"));

					listBean.add(empBean);
				}
			}

			if (i == 0) {
				noData = false;
			} else {
				noData = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "REPORT";
	}

	public List<EmpBean> getListBean() {
		return listBean;
	}

	public void setListBean(List<EmpBean> listBean) {
		this.listBean = listBean;
	}

	public Boolean isNoData() {
		return noData;
	}

	public void setNoData(Boolean noData) {
		this.noData = noData;
	}
}