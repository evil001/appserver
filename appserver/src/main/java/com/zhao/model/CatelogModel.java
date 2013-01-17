package com.zhao.model;

public class CatelogModel {

	private Integer id;

	private String name; // 图录名称

	private String imageUrl; // 图录图片

	private String specailCode; // 拍场编号

	private Double catelogPrice;// 图录价格

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSpecailCode() {
		return specailCode;
	}

	public void setSpecailCode(String specailCode) {
		this.specailCode = specailCode;
	}

	public Double getCatelogPrice() {
		return catelogPrice;
	}

	public void setCatelogPrice(Double catelogPrice) {
		this.catelogPrice = catelogPrice;
	}

}
