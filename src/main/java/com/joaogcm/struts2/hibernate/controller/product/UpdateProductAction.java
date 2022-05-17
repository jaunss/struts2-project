package com.joaogcm.struts2.hibernate.controller.product;

import java.sql.ResultSet;

import com.joaogcm.struts2.hibernate.dao.impl.ProductDAOImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateProductAction extends ActionSupport {

	private static final long serialVersionUID = 4824572646601204108L;

	private Integer idproduct = null;
	private String nmproduct = null;
	private Double vlpriceproduct = null;
	private String nmbrandproduct = null;
	private Integer qtdproduct = null;

	private ResultSet rs = null;

	private ProductDAOImpl productDAOImpl = null;

	private String submitType;
	int isUpdate = 0;

	@Override
	public String execute() throws Exception {
		productDAOImpl = new ProductDAOImpl();

		try {
			if (submitType.equals("updatedata")) {
				rs = productDAOImpl.listProductById(idproduct);
				if (rs != null) {
					while (rs.next()) {
						nmproduct = rs.getString("NMPRODUCT");
						vlpriceproduct = rs.getDouble("VLPRICEPRODUCT");
						nmbrandproduct = rs.getString("NMBRANDPRODUCT");
						qtdproduct = rs.getInt("QTDPRODUCT");
					}
				}
			} else {
				isUpdate = productDAOImpl.updateProductById(nmproduct, vlpriceproduct, nmbrandproduct, qtdproduct,
						idproduct);

				if (isUpdate > 0) {
					addActionMessage(getText("success.product.update"));
					productDAOImpl.listProducts();
					return "listProduct";
				} else {
					addActionMessage(getText("error.product.update"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "updateProduct";
	}

	public Integer getIdproduct() {
		return idproduct;
	}

	public void setIdproduct(Integer idproduct) {
		this.idproduct = idproduct;
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

	public int getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(int isUpdate) {
		this.isUpdate = isUpdate;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}
}