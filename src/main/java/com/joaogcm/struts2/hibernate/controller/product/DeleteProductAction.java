package com.joaogcm.struts2.hibernate.controller.product;

import com.joaogcm.struts2.hibernate.dao.impl.ProductDAOImpl;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteProductAction extends ActionSupport {

	private static final long serialVersionUID = 4824572646601204108L;

	Integer idproduct;
	private ProductDAOImpl productDAOImpl = null;
	int isDelete = 0;

	@Override
	public String execute() throws Exception {
		productDAOImpl = new ProductDAOImpl();
		try {
			isDelete = productDAOImpl.deleteProductById(idproduct);

			if (isDelete > 0) {
				addActionMessage(getText("success.product.delete"));
				productDAOImpl.listProducts();
				return "listProduct";
			} else {
				addActionMessage(getText("error.product.delete"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "deleteProduct";
	}

	public Integer getIdproduct() {
		return idproduct;
	}

	public void setIdproduct(Integer idproduct) {
		this.idproduct = idproduct;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
}