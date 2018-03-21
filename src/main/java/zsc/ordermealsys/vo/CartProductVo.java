package zsc.ordermealsys.vo;

import java.math.BigDecimal;

/**
 * @author 黄俊淞
 */
public class CartProductVo {

	//结合了产品和购物车的抽象对象
	private Integer id;
	private Integer userId;
	private Integer productId;
	private Integer productNum;//购物车中商品的数量
	private String productName;
	//private String productSubtitle;//商品副标题
	private String productMainPic;//商品主图
	private BigDecimal productPrice;
	private Integer productStatus;//商品状态
	private BigDecimal productTotalPrice;//商品总价
	private Integer productStock;//商品库存
	private Integer productChecked;//此商品是否勾选
	
	private String limitQuantity;//数量限制

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getProductNum() {
		return productNum;
	}

	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductMainPic() {
		return productMainPic;
	}

	public void setProductMainPic(String productMainPic) {
		this.productMainPic = productMainPic;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}

	public BigDecimal getProductTotalPrice() {
		return productTotalPrice;
	}

	public void setProductTotalPrice(BigDecimal productTotalPrice) {
		this.productTotalPrice = productTotalPrice;
	}

	public Integer getProductStock() {
		return productStock;
	}

	public void setProductStock(Integer productStock) {
		this.productStock = productStock;
	}

	public Integer getProductChecked() {
		return productChecked;
	}

	public void setProductChecked(Integer productChecked) {
		this.productChecked = productChecked;
	}

	public String getLimitQuantity() {
		return limitQuantity;
	}

	public void setLimitQuantity(String limitQuantity) {
		this.limitQuantity = limitQuantity;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
