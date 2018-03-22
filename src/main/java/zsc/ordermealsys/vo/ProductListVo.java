package zsc.ordermealsys.vo;
import java.math.BigDecimal;

public class ProductListVo {

    public ProductListVo() {
		super();
	}

	private Integer id;
    private Integer categoryId;

    private String name;
    private String mainPic;
    public ProductListVo(Integer id, Integer categoryId, String name, String mainPic, BigDecimal price,
			Integer proSatus, String picHost) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.mainPic = mainPic;
		this.price = price;
		this.proSatus = proSatus;
		this.picHost = picHost;
	}

	private BigDecimal price;

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

	public String getMainPic() {
		return mainPic;
	}

	public void setMainPic(String mainPic) {
		this.mainPic = mainPic;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getProSatus() {
		return proSatus;
	}

	public void setProSatus(Integer proSatus) {
		this.proSatus = proSatus;
	}

	public String getPicHost() {
		return picHost;
	}

	public void setPicHost(String picHost) {
		this.picHost = picHost;
	}

	private Integer proSatus;

    private String picHost;

}
