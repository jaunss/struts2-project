package com.joaogcm.struts2.hibernate.controller.product;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.joaogcm.struts2.hibernate.bean.ProductBean;
import com.joaogcm.struts2.hibernate.dao.impl.ProductDAOImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ListProductAction extends ActionSupport {

	private static final long serialVersionUID = 4824572646601204108L;

	private ResultSet rs = null;
	private ProductBean productBean = null;
	private List<ProductBean> listProduct = null;

	private ProductDAOImpl productDAOImpl = null;
	private boolean noData = false;

	@Override
	public String execute() throws Exception {
		productDAOImpl = new ProductDAOImpl();

		try {
			listProduct = new ArrayList<ProductBean>();

			rs = productDAOImpl.listProducts();
			int isList = 0;

			if (rs != null) {
				while (rs.next()) {
					isList++;

					productBean = new ProductBean();
					productBean.setIdproduct(rs.getInt("IDPRODUCT"));
					productBean.setNmproduct(rs.getString("NMPRODUCT"));
					productBean.setVlpriceproduct(rs.getDouble("VLPRICEPRODUCT"));
					productBean.setNmbrandproduct(rs.getString("NMBRANDPRODUCT"));
					productBean.setQtdproduct(rs.getInt("QTDPRODUCT"));

					listProduct.add(productBean);
				}
			}

			if (isList == 0) {
				noData = false;
			} else {
				noData = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "listProduct";
	}

	public List<ProductBean> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<ProductBean> listProduct) {
		this.listProduct = listProduct;
	}

	public Boolean isNoData() {
		return noData;
	}

	public void setNoData(Boolean noData) {
		this.noData = noData;
	}
}