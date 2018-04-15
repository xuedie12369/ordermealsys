package zsc.ordermealsys.controller.portal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.pojo.ProductWithBLOBs;
import zsc.ordermealsys.service.IProductService;
import zsc.ordermealsys.vo.ProductDetailVo;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	IProductService iProductService;
	/**前端获取产品详情
	 * 作者：邵海楠
	 * @param productId
	 * @return
	 */
	@RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse<ProductDetailVo> detail(Integer productId){
        return iProductService.getProductDetail(productId);
    }
	
	/**
	 * 通过关键字或者分类查找产品
	 * @param keyword
	 * @param categoryId
	 * @param pageNum
	 * @param pageSize
	 * @param orderBy
	 * @return
	 */
	
	 @RequestMapping("list.do")
	    @ResponseBody
	    public ServerResponse<PageInfo> list(@RequestParam(value = "keyword",required = false)String keyword,
	                                         @RequestParam(value = "categoryId",required = false)Integer categoryId,
	                                         @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
	                                         @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
	                                         @RequestParam(value = "orderBy",defaultValue = "") String orderBy){
	        return iProductService.getProductByKeywordCategory(keyword,categoryId,pageNum,pageSize,orderBy);
	    }
		
	 	@RequestMapping("listAll.do")
	    @ResponseBody
	    public ServerResponse<List<ProductWithBLOBs>> listAll()
	    {
	 		System.out.print(iProductService.listAll().getData().size()+"这是大小 ");
		 return iProductService.listAll();
	    }

}
