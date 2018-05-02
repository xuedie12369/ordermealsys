package zsc.ordermealsys.vo;

import java.math.BigDecimal;

public class ProductVo {
	private Integer id;
    private Integer categoryId;

    private String name;
    private String mainPic;
    private BigDecimal price;

    private Integer pro_status;

    private String picHost;
    
    private Integer sales;
    public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	private Integer stock;
    public String getMainPic() {
		return mainPic;
	}

	public void setMainPic(String mainPic) {
		this.mainPic = mainPic;
	}

	public Integer getPro_status() {
		return pro_status;
	}

	public void setPro_status(Integer pro_status) {
		this.pro_status = pro_status;
	}

	public String getPicHost() {
		return picHost;
	}

	public void setPicHost(String picHost) {
		this.picHost = picHost;
	}

	

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


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    
}
