package zsc.ordermealsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.dao.CategoryMapper;
import zsc.ordermealsys.dao.ProductMapper;
import zsc.ordermealsys.pojo.Category;
import zsc.ordermealsys.pojo.Product;
import zsc.ordermealsys.pojo.ProductWithBLOBs;
import zsc.ordermealsys.service.IProductService;
import zsc.ordermealsys.util.DateTimeUtil;
import zsc.ordermealsys.util.PropertiesUtil;
import zsc.ordermealsys.vo.ProductDetailVo;
@Service("iProductService")
public class ProductServiceImpl implements IProductService {
@Autowired
	ProductMapper productMapper;
@Autowired
CategoryMapper categoryMapper;

/**
 * 添加产品或更新
 * 作者：邵海楠
 */
@Override
public	ServerResponse saveOrUpdate(ProductWithBLOBs product)
	{
		if(product!=null)
		{
			if(product.getSubPic()!=null)
			{
				String [] subImageArray =product.getSubPic().split(",");
				if(subImageArray.length>0)
				{
					product.setMainPic(subImageArray[0]);
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
/**
 * 设置产品上下架状态
 * 作者:邵海楠
 */
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
@Override
public ServerResponse manageProductDetail(Integer productId) {
	// TODO Auto-generated method stub
	if(productId==null)
	{
		 return ServerResponse.createByErrorMessage("产品ID不正确");
	}
	ProductWithBLOBs product=productMapper.selectByPrimaryKey(productId);
	if(product==null)
	{
		return ServerResponse.createByErrorMessage("产品已经删除或下架");
	}
	ProductDetailVo productDetailVo=assembleProductDetailVo(product);
	System.out.print(productDetailVo.getMain_pic()+productDetailVo.getCreateTime());
	return ServerResponse.createBySuccessMessage(productDetailVo);
	
}
/**
 * 把实体模型转为视图模型
 * @param product
 * @return
 */
private ProductDetailVo assembleProductDetailVo(ProductWithBLOBs product){
    ProductDetailVo productDetailVo = new ProductDetailVo();
    productDetailVo.setId(product.getId());
    productDetailVo.setPrice(product.getPrice());
    productDetailVo.setMain_pic(product.getMainPic());
    productDetailVo.setSub_pic(product.getSubPic());
    productDetailVo.setCategoryId(product.getId());
    productDetailVo.setDetail(product.getDetail());
    productDetailVo.setName(product.getName());
    productDetailVo.setProStatus(product.getProStatus());
    productDetailVo.setStock(product.getStock());
    productDetailVo.setPicHost(PropertiesUtil.getProperty("ftp.server.http.prefix","http://img.ordermealsys.com/"));
    Category category = categoryMapper.selectByPrimaryKey(product.getId());
    if(category == null){
        productDetailVo.setParent_id(0);//默认根节点
    }else{
        productDetailVo.setParent_id(category.getParentId());
    }
    productDetailVo.setCreateTime(DateTimeUtil.dateToStr(product.getCreateTime()));
    productDetailVo.setUpdateTime(DateTimeUtil.dateToStr(product.getUpdateTime()));
    return productDetailVo;
}




}