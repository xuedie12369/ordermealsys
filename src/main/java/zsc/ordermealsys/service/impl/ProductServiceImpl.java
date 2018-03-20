package zsc.ordermealsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.dao.ProductMapper;
import zsc.ordermealsys.pojo.Product;
import zsc.ordermealsys.pojo.ProductWithBLOBs;
import zsc.ordermealsys.service.IProductService;
@Service("iProductService")
public class ProductServiceImpl implements IProductService {
@Autowired
	ProductMapper productMapper;
/**
 * 新增产品或更新产品
 * 作者：邵海楠
 */
@Override
public	ServerResponse saveOrUpdate(ProductWithBLOBs product)
	{
		if(product!=null)
		{
			if(product.getSub_pic()!=null)
			{
				String [] subImageArray =product.getSub_pic().split(",");
				if(subImageArray.length>0)
				{
					product.setMain_pic(subImageArray[0]);
				}
			}
			if(product.getId()==null)
			{
				int rowCount=productMapper.insert(product);
				if(rowCount>0)
				{
					return ServerResponse.createBySuccessMessage("新增产品成功");
				}
			/*	System.out.print(rowCount);*/
			}
			//更新产品
			else
			{
				int rowCount=productMapper.updateByPrimaryKey(product);
				if(rowCount>0)
				{
					return ServerResponse.createBySuccessMessage("新增产品成功");
				}
			}
		}
		return ServerResponse.createByErrorMessage("新增/更新产品参数不正确");
	}
@Override
public ServerResponse delete(ProductWithBLOBs product) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public ServerResponse setSaleStatus(Integer productId, Integer proStatus) {
	// TODO Auto-generated method stub
	if(productId!=null&&proStatus!=null)
	{
		Product product=new Product();
		product.setProStatus(proStatus);
		product.setId(productId);
		int rowCount=productMapper.updateByPrimaryKey(product);
		if(rowCount>0)
		{
			return ServerResponse.createBySuccessMessage("更新产品状态成功");
		}
	}
	 return ServerResponse.createByErrorMessage("修改产品状态失败");
}


}