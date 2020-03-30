package com.miaosha.common.entity;

import java.util.Date;

/**
 * Created by cdh on 2020/3/29.
 */
public class ProductInfo {
	private int id;// 主键
	private String producttitle;// 商品标题
	private String productname;// 商品名称
	private String productpictureurl;// 图片地址
	private Double productprice;// 原价
	private Double productdiscounts;// 优惠价格
	private Date createTime;// 创建时间
	private Date updateTime;// 更新时间
	private int state;// 商品状态，0申请中1审核通过2退回3上架4下架
	private Date approveTime;// 审核时间
	private int mechantId;// 商户id
	private int productTypeid;// 商品类别id
	private Long productInventory;// 库存
	private int shopId;// 商铺id

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProducttitle() {
		return producttitle;
	}

	public void setProducttitle(String producttitle) {
		this.producttitle = producttitle;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductpictureurl() {
		return productpictureurl;
	}

	public void setProductpictureurl(String productpictureurl) {
		this.productpictureurl = productpictureurl;
	}

	public Double getProductprice() {
		return productprice;
	}

	public void setProductprice(Double productprice) {
		this.productprice = productprice;
	}

	public Double getProductdiscounts() {
		return productdiscounts;
	}

	public void setProductdiscounts(Double productdiscounts) {
		this.productdiscounts = productdiscounts;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getApproveTime() {
		return approveTime;
	}

	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}

	public int getMechantId() {
		return mechantId;
	}

	public void setMechantId(int mechantId) {
		this.mechantId = mechantId;
	}

	public int getProductTypeid() {
		return productTypeid;
	}

	public void setProductTypeid(int productTypeid) {
		this.productTypeid = productTypeid;
	}

	public Long getProductInventory() {
		return productInventory;
	}

	public void setProductInventory(Long productInventory) {
		this.productInventory = productInventory;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

}
