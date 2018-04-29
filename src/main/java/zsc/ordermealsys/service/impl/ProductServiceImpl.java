package zsc.ordermealsys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import zsc.ordermealsys.common.Const;
import zsc.ordermealsys.common.ResponseCode;
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
import zsc.ordermealsys.vo.ProductListVo;
import zsc.ordermealsys.vo.ProductVo;

@Service("iProductService")
public class ProductServiceImpl implements IProductService {
	@Autowired
	ProductMapper productMapper;
	@Autowired
	CategoryMapper categoryMapper;

	/**
	 * 添加产品或更新 作者：邵海楠
	 */
	@Override
	public ServerResponse saveOrUpdate(ProductWithBLOBs product) {
		if (product != null) {
			if (product.getSubPic() != null) {
				String[] subImageArray = product.getSubPic().split(",");
				if (subImageArray.length > 0) {
					product.setMainPic(subImageArray[0]);
				}
			}
			if (product.getId() == null) {
				int rowCount = productMapper.insert(product);
				if (rowCount > 0) {
					return ServerResponse.createBySuccessMessage("新增产品成功");
				}
				/* System.out.print(rowCount); */
			}
			// 更新产品
			else {
				int rowCount = productMapper.updateByPrimaryKey(product);
				if (rowCount > 0) {
					return ServerResponse.createBySuccessMessage("新增产品成功");
				}
			}
		}
		return ServerResponse.createByErrorMessage("新增/更新产品参数不正确");
	}

	@Override
	public ServerResponse delete(Integer productId) {
		// TODO Auto-generated method stub
		if(productId!=null)
		{
			int n=productMapper.deleteByPrimaryKey(productId);
			return  n>0?ServerResponse.createBySuccessMessage("删除成功"):ServerResponse.createByErrorMessage("删除失败");
		}
		return ServerResponse.createByErrorMessage("参数错误");
	}

	/**
	 * 设置产品上下架状态 作者:邵海楠
	 */
	@Override
	public ServerResponse setSaleStatus(Integer productId, Integer proStatus) {
		// TODO Auto-generated method stub
		if (productId != null && proStatus != null) {
			Product product = new Product();
			product.setProStatus(proStatus);
			product.setId(productId);
			int rowCount = productMapper.updateByPrimaryKey(product);
			if (rowCount > 0) {
				return ServerResponse.createBySuccessMessage("更新产品状态成功");
			}
		}
		return ServerResponse.createByErrorMessage("修改产品状态失败");
	}

	@Override
	public ServerResponse manageProductDetail(Integer productId) {
		// TODO Auto-generated method stub
		if (productId == null) {
			return ServerResponse.createByErrorMessage("产品ID不正确");
		}
		ProductWithBLOBs product = productMapper.selectByPrimaryKey(productId);
		if (product == null) {
			return ServerResponse.createByErrorMessage("产品已经删除或下架");
		}
		ProductDetailVo productDetailVo = assembleProductDetailVo(product);
		System.out.print(productDetailVo.getMain_pic() + productDetailVo.getCreateTime());
		return ServerResponse.createBySuccess(productDetailVo);

	}

	/**
	 * 把实体模型转为视图模型
	 * 
	 * @param product
	 * @return
	 */
	private ProductDetailVo assembleProductDetailVo(ProductWithBLOBs product) {
		ProductDetailVo productDetailVo = new ProductDetailVo();
		productDetailVo.setId(product.getId());
		productDetailVo.setPrice(product.getPrice());
		productDetailVo.setMain_pic(product.getMainPic());
		productDetailVo.setSub_pic(product.getSubPic());
		productDetailVo.setCategoryId(product.getCategoryId());
		productDetailVo.setDetail(product.getDetail());
		productDetailVo.setName(product.getName());
		productDetailVo.setProStatus(product.getProStatus());
		productDetailVo.setStock(product.getStock());
		productDetailVo
				.setPicHost(PropertiesUtil.getProperty("ftp.server.http.prefix", "http://img.ordermealsys.com/"));
		Category category = categoryMapper.selectByPrimaryKey(product.getId());
		if (category == null) {
			productDetailVo.setParent_id(0);// 默认根节点
		} else {
			productDetailVo.setParent_id(category.getParentId());
		}
		productDetailVo.setCreateTime(DateTimeUtil.dateToStr(product.getCreateTime()));
		productDetailVo.setUpdateTime(DateTimeUtil.dateToStr(product.getUpdateTime()));
		return productDetailVo;
	}

	/**
	 * 获得产品列表 作者:邵海楠
	 */
	@Override
	public ServerResponse<PageInfo> getProductList(Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		// startPage-start
		// 填充自己的sql逻辑
		// pageHelper--收尾
		PageHelper.startPage(pageNum, pageSize);
		List<ProductVo> productVoList = new ArrayList<ProductVo>();
		List<ProductWithBLOBs> productList = productMapper.selectList();
		/* 把产品对象模型转换为业务对象模型 */
		for (ProductWithBLOBs productWithBLOBs : productList) {
			productVoList.add(assembleProductVo(productWithBLOBs));
		}
		PageInfo pageResult = new PageInfo(productList);
		pageResult.setList(productVoList);
		return ServerResponse.createBySuccess(pageResult);
	}

	/**
	 * 数据库模型转为业务模型
	 * 
	 * @param product
	 * @return
	 */
	private ProductVo assembleProductVo(ProductWithBLOBs product) {
		ProductVo productVo = new ProductVo();
		productVo.setCategoryId(product.getCategoryId());
		productVo.setId(product.getId());
		productVo.setMainPic(product.getMainPic());
		productVo.setName(product.getName());
		productVo.setPicHost(PropertiesUtil.getProperty("ftp.server.http.prefix", "http://img.ordermealsys.com/"));
		productVo.setPro_status(product.getProStatus());
		productVo.setSales(product.getSales());
		productVo.setStock(product.getStock());
		productVo.setPrice(product.getPrice());
		return productVo;
	}

	/**
	 * 查询产品
	 */
	@Override
	public ServerResponse searchProduct(String name, Integer id, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub

		PageHelper.startPage(pageNum, pageSize);
		List<ProductVo> productVoList = new ArrayList<ProductVo>();
		if (name != null) {
			name = new StringBuilder().append("%").append(name).append("%").toString();
		}
		List<ProductWithBLOBs> productList = productMapper.searchProduct(name, id);
		/* 把产品对象模型转换为业务对象模型 */
		for (ProductWithBLOBs productWithBLOBs : productList) {
			productVoList.add(assembleProductVo(productWithBLOBs));
		}
		PageInfo pageResult = new PageInfo(productList);
		pageResult.setList(productVoList);
		System.out.print(productVoList.get(0).getName());
		return ServerResponse.createBySuccess(pageResult);
	}

	@Override
	public ServerResponse<ProductDetailVo> getProductDetail(Integer productId) {
		// TODO Auto-generated method stub
		if (productId == null) {
			return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),
					ResponseCode.ILLEGAL_ARGUMENT.getDesc());
		}
		ProductWithBLOBs product = productMapper.selectByPrimaryKey(productId);

		if (product == null) {
			return ServerResponse.createByErrorMessage("产品已下架或者删除");
		}
		if (product.getProStatus() != Const.ProductStatusEnum.ON_SALE.getCode()) {
			return ServerResponse.createByErrorMessage("产品已下架或者删除");
		}
		ProductDetailVo productDetailVo = assembleProductDetailVo(product);
		System.out.print("执行了获得详情的方法" + productDetailVo.getMain_pic());
		return ServerResponse.createBySuccess(productDetailVo);
	}

	@Override
	 public ServerResponse<PageInfo> getProductByKeywordCategory(String keyword,Integer categoryId,int pageNum,int pageSize,String orderBy){
        if(keyword==null && categoryId == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        List<Integer> categoryIdList = new ArrayList<Integer>();

        if(categoryId != null){
            Category category = categoryMapper.selectByPrimaryKey(categoryId);
            if(category == null && keyword.isEmpty()){
                //没有该分类,并且还没有关键字,这个时候返回一个空的结果集,不报错
                PageHelper.startPage(pageNum,pageSize);
                List<ProductListVo> productListVoList = new ArrayList<ProductListVo>();
                PageInfo pageInfo = new PageInfo(productListVoList);
                return ServerResponse.createBySuccess(pageInfo);
            }
//            categoryIdList = iCategoryService.selectCategoryAndChildrenById(category.getId()).getData();
        }
        if(keyword!=null||keyword!=""){
            keyword = new StringBuilder().append("%").append(keyword).append("%").toString();
        }

        PageHelper.startPage(pageNum,pageSize);
        //排序处理
    /*    if(StringUtils.isNotBlank(orderBy)){
            if(Const.ProductListOrderBy.PRICE_ASC_DESC.contains(orderBy)){
                String[] orderByArray = orderBy.split("_");
                PageHelper.orderBy(orderByArray[0]+" "+orderByArray[1]);
            }
        }*/
//        List<Product> productList = productMapper.selectByNameAndCategoryIds(StringUtils.isBlank(keyword)?null:keyword,categoryIdList.size()==0?null:categoryIdList);
        List<ProductWithBLOBs> productList=productMapper.searchProduct(keyword, categoryId);
        List<ProductListVo> productListVoList =new ArrayList<ProductListVo>();
        for(ProductWithBLOBs product : productList){
            ProductListVo productListVo = assembleProductListVo(product);
            productListVoList.add(productListVo);
        }

        PageInfo pageInfo = new PageInfo(productList);
        pageInfo.setList(productListVoList);
        System.out.print(productListVoList.get(0).getMainPic()+"主图"+"adasfasf");
        return ServerResponse.createBySuccess(pageInfo);
    }

	 private ProductListVo assembleProductListVo(ProductWithBLOBs product){
	        ProductListVo productListVo = new ProductListVo();
	        productListVo.setId(product.getId());
	        productListVo.setName(product.getName());
	        productListVo.setCategoryId(product.getCategoryId());
	        productListVo.setPicHost(PropertiesUtil.getProperty("ftp.server.http.prefix","http://img.happymmall.com/"));
	        productListVo.setMainPic(product.getMainPic());
	        productListVo.setPrice(product.getPrice());
	        productListVo.setProSatus(product.getProStatus());
	        return productListVo;
	    }

	@Override
	public ServerResponse<List<ProductWithBLOBs>> listAll() {
		// TODO Auto-generated method stub
		
		return ServerResponse.createBySuccess(productMapper.selectList());
	}

	@Override
	public ServerResponse<ProductDetailVo> searchProductById(Integer productId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
