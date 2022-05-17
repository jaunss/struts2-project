package com.joaogcm.struts2.hibernate.bean;

public class ProductBean {

	private Integer idproduct;
	private String nmproduct;
	private Double vlpriceproduct;
	private String nmbrandproduct;
	private Integer qtdproduct;

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
}