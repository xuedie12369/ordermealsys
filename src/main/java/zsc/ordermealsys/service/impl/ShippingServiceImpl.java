package zsc.ordermealsys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;

import zsc.ordermealsys.common.ServerResponse;
import zsc.ordermealsys.dao.AddressMapper;
import zsc.ordermealsys.pojo.Address;
import zsc.ordermealsys.service.IShippingService;

@Service("iShippingService")
public class ShippingServiceImpl implements IShippingService{

	@Autowired
	private AddressMapper addressMapper;

	public ServerResponse add(Integer userId,Address address){
		address.setUserId(userId);
		int rowCount=addressMapper.insert(address);	
		if(rowCount>0){
			Map result=Maps.newHashMap();
			result.put("addressId", address.getId());
			return ServerResponse.createBySuccess("新建地址成功", result);
		}
		return ServerResponse.createByErrorMessage("新建地址失败");
	}

	public ServerResponse<String> del(Integer userId,Integer addressId){
		int resultCount=addressMapper.deleteByAddressIdUserId(userId, addressId);
		if(resultCount>0){
			System.out.println("删除地址成功");
			return ServerResponse.createBySuccess("删除地址成功");
		}
		return ServerResponse.createByErrorMessage("删除地址失败");
	}

	public ServerResponse update(Integer userId,Address address){
		address.setUserId(userId);
		int rowCount=addressMapper.updateByAddress(address);
		if(rowCount>0){
			System.out.println("更新地址成功");
			return ServerResponse.createBySuccess("更新地址成功");
		}
		return ServerResponse.createByErrorMessage("更新地址失败");
	}

	public ServerResponse<Address> select(Integer userId,Integer addressId){
		Address address=addressMapper.selectByAddressIdUserId(userId, addressId);
		if(address==null){
			return ServerResponse.createByErrorMessage("无法查询到该地址");
		}
		System.out.println("查询地址成功");
		System.out.println(address.getConsigneeName().toString());
		return ServerResponse.createBySuccess("查询地址成功",address);
	}
	
	public ServerResponse<PageInfo>list(Integer userId,int pageNum,int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<Address> addressList=addressMapper.selectByUserId(userId);
		PageInfo pageInfo=new PageInfo(addressList);
		return ServerResponse.createBySuccess(pageInfo);
	}
}
