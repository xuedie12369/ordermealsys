package zsc.ordermealsys.vo;

import java.math.BigDecimal;

public class ProductDetailVo {
	 	private Integer  id;
	    private Integer categoryId;
	    private String name;
	    private String main_pic;
	    private String sub_pic;
	    private String detail;
	    private BigDecimal price;
	    private Integer stock;
	    private Integer pic;
	    private Integer ProStatus;
		private String createTime;
	    private String updateTime;
	    
	    public Integer getProStatus() {
			return ProStatus;
		}
		public void setProStatus(Integer proStatus) {
			ProStatus = proStatus;
		}
	
		private String picHost;
	    private Integer parent_id;
	    public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(Integer categoryId) {
			this.categoryId = categoryId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMain_pic() {
			return main_pic;
		}
		public void setMain_pic(String main_pic) {
			this.main_pic = main_pic;
		}
		public String getSub_pic() {
			return sub_pic;
		}
		public void setSub_pic(String sub_pic) {
			this.sub_pic = sub_pic;
		}
		public String getDetail() {
			return detail;
		}
		public void setDetail(String detail) {
			this.detail = detail;
		}
		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		public Integer getStock() {
			return stock;
		}
		public void setStock(Integer stock) {
			this.stock = stock;
		}
		public Integer getPic() {
			return pic;
		}
		public void setPic(Integer pic) {
			this.pic = pic;
		}
		public String getCreateTime() {
			return createTime;
		}
		public void setCreateTime(String createTime) {
			this.createTime = createTime;
		}
		public String getUpdateTime() {
			return updateTime;
		}
		public void setUpdateTime(String updateTime) {
			this.updateTime = updateTime;
		}
		public String getPicHost() {
			return picHost;
		}
		public void setPicHost(String picHost) {
			this.picHost = picHost;
		}
		public Integer getParent_id() {
			return parent_id;
		}
		public void setParent_id(Integer parent_id) {
			this.parent_id = parent_id;
		}
	
}
