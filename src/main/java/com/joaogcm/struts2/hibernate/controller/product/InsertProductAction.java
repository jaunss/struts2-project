package com.joaogcm.struts2.hibernate.controller.product;

import com.joaogcm.struts2.hibernate.dao.impl.ProductDAOImpl;
import com.opensymphony.xwork2.ActionSupport;

public class InsertProductAction extends ActionSupport {

	private static final long serialVersionUID = 4824572646601204108L;

	private String nmproduct;
	private Double vlpriceproduct;
	private String nmbrandproduct;
	private Integer qtdproduct;

	private ProductDAOImpl productDAOImpl = null;
	int isInsert = 0;

	@Override
	public String execute() throws Exception {
		productDAOImpl = new ProductDAOImpl();

		try {
			isInsert = productDAOImpl.insertProduct(nmproduct, vlpriceproduct, nmbrandproduct, qtdproduct);

			if (isInsert > 0) {
				addActionMessage(getText("success.product.insert"));
				productDAOImpl.listProducts();
				return "listProduct";
			} else {
				addActionMessage(getText("error.product.insert"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "insertProduct";
	}

	public String getNmproduct() {
		return nmproduct;
	}

	public void setNmproduct(String nmproduct) {
		this.nmproduct = nmproduct;
	}

	public Double getVlpriceproduct() {
		return vlpriceproduct;
	}

	public void setVlpriceproduct(Double vlpriceproduct) {
		this.vlpriceproduct = vlpriceproduct;
	}

	public String getNmbrandproduct() {
		return nmbrandproduct;
	}

	public void setNmbrandproduct(String nmbrandproduct) {
		this.nmbrandproduct = nmbrandproduct;
	}

	public Integer getQtdproduct() {
		return qtdproduct;
	}

	public void setQtdproduct(Integer qtdproduct) {
		this.qtdproduct = qtdproduct;
	}

	public int getIsInsert() {
		return isInsert;
	}

	public void setIsInsert(int isInsert) {
		this.isInsert = isInsert;
	}
}