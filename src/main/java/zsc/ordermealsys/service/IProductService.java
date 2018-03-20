package zsc.ordermealsys.service;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.ProductWithBLOBs;

public interface IProductService {
	public	ServerResponse saveOrUpdate(ProductWithBLOBs product);
	

}
